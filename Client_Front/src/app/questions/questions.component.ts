import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Location} from '@angular/common';
import { UserService } from '../user.service';
import { FileSelectDirective, FileUploader} from 'ng2-file-upload';


@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrls: ['./questions.component.css']
})
export class QuestionsComponent implements OnInit {
  currentQuestion: any;
  curQuesNum = 0;
  questionSet : any;
  correctAnswer = 0;
  currentTopic : string;
  currentCourse : string;
  displayCurrentQues = 1;
  answerForm: FormGroup;
  currentSelectedOpt: string = '';
  codeQuestionResponse: string = '';

  hint : string = "Note:\nWhite space: The corresponding lines are in common. That is, either the lines are identical, or the difference is ignored because of one of the --ignore options \n'|': The corresponding lines differ, and they are either both complete or both incomplete.\n'<': The files differ and only the first file contains the line.\n'>': The files differ and only the second file contains the line."

  fileToUpload: File = null;
  uploader:FileUploader = new FileUploader({url:'http://localhost:4200/api/v1/questions/uploadAnswer'});

  attachmentList:any = [];

  currentOptionsSet: any;
  editQuestionForm: FormGroup;

  constructor(  private _location: Location,
                private formBuilder : FormBuilder,
                private dataService: DataService,
                private route:ActivatedRoute,
                private userService: UserService) {

                  this.uploader.onCompleteItem = (item:any, response:any , status:any, headers:any) => {
            this.attachmentList.push(JSON.parse(response));
            this.codeQuestionResponse = this.attachmentList[0].output;
        }

                 }

  get answerFormControl() { return this.answerForm.controls; }
  get editFormControl() {return this.editQuestionForm.controls;}

  ngOnInit() {
    this.currentQuestion = {};
    this.questionSet = [];

    this.answerForm = this.formBuilder.group({
      multAnswer: [''],
      answer: [''],
    });

    this.editQuestionForm = this.formBuilder.group({
      question_content: [''],
      question_key: [''],
      question_opt_1: [''],
      question_opt_2 : [''],
      question_opt_3: [''],
      question_opt_4: ['']
    });

    this.currentTopic = JSON.parse(localStorage.getItem('currentTopic'));
    this.currentCourse = JSON.parse(localStorage.getItem('currentCourse'));
    this.dataService.getQuestions(this.route.snapshot.params['cid'], this.route.snapshot.params['tid']).subscribe(data => {
       this.questionSet = data;
       //console.log(this.questionSet[0].content);
       this.questionSet.forEach( (question) => {
         question.question_code = question.content.split('`')[1];
         question.question_content = question.content.split('`')[0];
         console.log(question.question_code);
         if(question.question_code){
           question.formated_content = "<pre>" + question.question_code.replace( /[\\]n/g, '<br>') + "<pre>";
         }
         console.log(question.formated_content);
         //question.content = this.domSanitizer.bypassSecurityTrustHtml(question.content);

       });
       this.currentQuestion =  this.questionSet[this.curQuesNum];
       if(this.currentQuestion && this.currentQuestion.type_id === 1){
         this.dataService.getOptionsOfMultQuestion(this.currentQuestion.qid).subscribe( data =>{
           let retData = data;
           this.currentOptionsSet = retData;
         });
       }
    });
  }

  setEditFormValue(){
    this.editFormControl.question_content.setValue(this.currentQuestion.content);
    this.editFormControl.question_key.setValue(this.currentQuestion.question_key);
    if(this.currentOptionsSet && this.currentOptionsSet.length === 4){
      this.editFormControl.question_opt_1.setValue(this.currentOptionsSet[0].opt);
      this.editFormControl.question_opt_2.setValue(this.currentOptionsSet[1].opt);
      this.editFormControl.question_opt_3.setValue(this.currentOptionsSet[2].opt);
      this.editFormControl.question_opt_4.setValue(this.currentOptionsSet[3].opt);
    }
  }

  editQuestion(){
    this.setEditFormValue();
  }


  nextQuestion(){
    this.curQuesNum = this.curQuesNum + 1;
    this.currentQuestion =  this.questionSet[this.curQuesNum];
    this.correctAnswer = 0;
    this.displayCurrentQues = this.displayCurrentQues+1;
    this.answerFormControl.answer.setValue('');
    this.answerFormControl.answer.enable();
    if(this.currentQuestion.type_id === 1){
      this.dataService.getOptionsOfMultQuestion(this.currentQuestion.qid).subscribe( data =>{
        let retData = data;
        this.currentOptionsSet = retData;
      });
    }
  }

  submit(){
    if(this.currentQuestion.type_id === 0){
      var answer = this.answerFormControl.answer.value;
      answer = answer.trim();
      if(answer === this.currentQuestion.question_key){
        this.answerFormControl.answer.disable();
        this.correctAnswer = 2;
      }
      else{
        this.correctAnswer = 1;
      }
    }
    else if (this.currentQuestion.type_id === 1){
      if(this.currentSelectedOpt === this.currentQuestion.question_key){
        this.correctAnswer = 2;
        this.currentSelectedOpt = '';
      }
      else{
        this.correctAnswer = 1;
      }
    }
  }

  submitEditQuestion(){
    let editObj: any;
    editObj = {
      question_content: this.editFormControl.question_content.value,
      qid: this.currentQuestion.qid,
      question_type_id: this.currentQuestion.type_id
    }
    if(this.currentQuestion.type_id === 0){
      editObj.question_key = this.editFormControl.question_key.value;
    }

    if(this.currentQuestion.type_id === 1){
      editObj.question_key = this.editFormControl.question_key.value;
      editObj.question_options = [];
      editObj.question_options.push(this.editFormControl.question_opt_1.value);
      editObj.question_options.push(this.editFormControl.question_opt_2.value);
      editObj.question_options.push(this.editFormControl.question_opt_3.value);
      editObj.question_options.push(this.editFormControl.question_opt_4.value);
    }

    this.dataService.editQuestion(editObj).subscribe( data =>{
      console.log(data);
      let retData :any = data;
      if(retData.success === "true"){
        this.currentQuestion.content = this.editFormControl.question_content.value;
        this.currentQuestion.formated_Content = "<pre>" + this.currentQuestion.content.replace( /[\\]n/g, '<br>') + "<pre>";

        if(this.currentQuestion.type_id === 0){
          this.currentQuestion.question_key = this.editFormControl.question_key.value;
        }
        if(this.currentQuestion.type_id === 1){
          this.currentQuestion.question_key = this.editFormControl.question_key.value;
          console.log(this.currentOptionsSet);
          this.currentOptionsSet = [];
          this.currentOptionsSet.push({question_qid: this.currentQuestion.qid, opt: this.editFormControl.question_opt_1.value});
          this.currentOptionsSet.push({question_qid: this.currentQuestion.qid, opt: this.editFormControl.question_opt_2.value});
          this.currentOptionsSet.push({question_qid: this.currentQuestion.qid, opt: this.editFormControl.question_opt_3.value});
          this.currentOptionsSet.push({question_qid: this.currentQuestion.qid, opt: this.editFormControl.question_opt_4.value});
        }

      }
    });
  }

  selectOption( opt ){
    this.currentSelectedOpt = opt;
  }

  back() {
    this._location.back();
  }
}
