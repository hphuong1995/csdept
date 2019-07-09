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
            console.log(this.attachmentList);
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
    console.log(this.currentCourse);
    this.dataService.getQuestions(this.route.snapshot.params['cid'], this.route.snapshot.params['tid']).subscribe(data => {
       this.questionSet = data;
       //console.log(this.questionSet[0].content);
       this.questionSet.forEach( (question) => {
         question.formated_Content = "<pre>" + question.content.replace( /[\\]n/g, '<br>') + "<pre>";
         //question.content = this.domSanitizer.bypassSecurityTrustHtml(question.content);
         //console.log(question.formated_Content);
       });
       this.currentQuestion =  this.questionSet[this.curQuesNum];
       if(this.currentQuestion.type_id === 1){
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

  // handleFileInput(files : FileList){
  //   this.fileToUpload = files.item(0);
  //   this.dataService.postFile(this.fileToUpload,this.currentQuestion.qid).subscribe(data => {
  //     // do something, if upload success
  //     let retData : any = data;
  //     this.codeQuestionResponse = retData.output;
  //   });
  // }

  selectOption( opt ){
    this.currentSelectedOpt = opt;
  }

  back() {
    this._location.back();
  }
}
