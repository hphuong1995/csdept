import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {Location} from '@angular/common';



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

  currentOptionsSet: any;


  constructor(  private _location: Location,
                private formBuilder : FormBuilder,
                private dataService: DataService,
                private route:ActivatedRoute,) { }

  get f() { return this.answerForm.controls; }

  ngOnInit() {
    this.answerForm = this.formBuilder.group({
      multAnswer: [''],
      answer: [''],
    });

    this.currentTopic = JSON.parse(JSON.stringify(localStorage.getItem('currentTopic')));
    this.currentCourse = JSON.parse(JSON.stringify(localStorage.getItem('currentCourse')));

    this.dataService.getQuestions(this.route.snapshot.params['cid'], this.route.snapshot.params['tid']).subscribe(data => {
       this.questionSet = data;
       //console.log(this.questionSet[0].content);
       this.questionSet.forEach( (question) => {
         question.content = "<pre>" + question.content.replace( /[\\]n/g, '<br>') + "<pre>";
         //question.content = this.domSanitizer.bypassSecurityTrustHtml(question.content);
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

  nextQuestion(){
    this.curQuesNum = this.curQuesNum + 1;
    this.currentQuestion =  this.questionSet[this.curQuesNum];
    this.correctAnswer = 0;
    this.displayCurrentQues = this.displayCurrentQues+1;
    this.f.answer.setValue('');
    this.f.answer.enable();
    if(this.currentQuestion.type_id === 1){
      this.dataService.getOptionsOfMultQuestion(this.currentQuestion.qid).subscribe( data =>{
        let retData = data;
        this.currentOptionsSet = retData;
      });
    }
  }

  submit(){
    if(this.currentQuestion.type_id === 0){
      var answer = this.f.answer.value;
      answer = answer.trim();
      if(answer === this.currentQuestion.question_key){
        this.f.answer.disable();
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

  selectOption( opt ){
    this.currentSelectedOpt = opt;
  }

  back() {
    this._location.back();
  }
}
