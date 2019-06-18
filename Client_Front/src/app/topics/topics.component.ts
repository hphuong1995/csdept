import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../user.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import {MatDatepickerInputEvent} from '@angular/material/datepicker';


export interface Topic {
  tid: number
  topic_name: string
  date: string
  formatedDate: string
}

@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit {
  topics: Object;
  currentCourse : any;
  currentInstructorId : string;
  topicsToAddList: any;

  edittingTopic: any = {
    topic_name: "",
    date: ""
  };

  editTopicForm: FormGroup;

  _this = this;

  displayedColumns: string[] = ['topicName', 'action'];

  dataSource: MatTableDataSource<Topic>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(  private _location: Location,
                private dataService: DataService,
                private route:ActivatedRoute,
                private userService: UserService,
                private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.currentCourse = JSON.parse(localStorage.getItem('currentCourse'));

    this.editTopicForm = this.formBuilder.group({
      topic_name: ['', Validators.required],
    });

    this.dataService.getTopics(this.route.snapshot.params['cid']).subscribe(data => {
      let retData : any = data;
      this.topics = retData.map( topic =>  convertTopic( topic));
      this.dataService.getAllTopics(this.route.snapshot.params['cid']).subscribe( topics=>{
        let retData : any = topics;


        this.topicsToAddList = retData.map( topic =>  convertTopic( topic));

        this.dataSource = new MatTableDataSource(this.topicsToAddList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
    });
  }

  setCurrentTopic(currentTopic :string){
    localStorage.setItem("currentTopic", currentTopic);
  }

  back() {
    this._location.back();
  }

  applyFilter(filterValue: string) {
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  addTopic(topic){
    this.dataService.addTopicToCourse(topic, this.route.snapshot.params['cid']).subscribe( data =>{
      this.topics = data;
        this.topicsToAddList = this.topicsToAddList.filter( topicToFilter =>  topicToFilter.tid !== topic);

        this.topicsToAddList = this.topicsToAddList.map( topic =>  convertTopic( topic));

        this.dataSource = new MatTableDataSource(this.topicsToAddList);
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    });
  }

  topicDateChange(type: string, event: MatDatepickerInputEvent<Date>): void {
    this.edittingTopic.date = event.value;
  }

  editTopic(topic){
    this.edittingTopic = topic;
    this.editTopicForm = this.formBuilder.group({
      topic_name: [this.edittingTopic.topic_name, Validators.required],
    });
  }

  get editTopicFormControl() { return this.editTopicForm.controls; }

  submitEditTopic(){
    this.edittingTopic.topic_name = this.editTopicFormControl.topic_name.value;
    this.dataService.updateTopic( this.edittingTopic , this.route.snapshot.params['cid']).subscribe( data =>{
      let retData : any = data;
      this.topics = retData.map( topic =>  convertTopic( topic));
    });
  }

  checkAppearance(topic){
    console.log(this.userService.getCurrentUser().type, this.userService.getCurrentUser().uid, this.currentCourse.uid);
    if(this.userService.getCurrentUser().type === 1 && this.userService.getCurrentUser().uid === this.currentCourse.uid){
      return true;
    }
    else{
      if(new Date(topic.date).getTime() > new Date().getTime()){
        return false;
      }
      else if( !topic.date){
        return false;
      }
      else{
        return true;
      }
    }
  }
}

function convertTopic(topic): Topic {
  let formatedDate = "";
  if(!topic.date){
    formatedDate = "Not Specified";
  }
  else{
    let topicDate = new Date(topic.date).getTime();
    let currentDate = new Date().getTime();
    if(topicDate <= currentDate){
      formatedDate = "Currently Available";
    }
    else{
      formatedDate = "Available on " + topic.date.substr(0,16);
    }
  }
  return {
    tid: topic.tid,
    topic_name: topic.topic_name,
    date : topic.date,
    formatedDate: formatedDate
  };
}
