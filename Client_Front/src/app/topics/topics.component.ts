import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../user.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


export interface Topic {
  tid: number
  topic_name: string
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
      date: ['']
    });

    this.dataService.getTopics(this.route.snapshot.params['cid']).subscribe(data => {
      this.topics = data;
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
}

function convertTopic(topic): Topic {
  return {
    tid: topic.tid,
    topic_name: topic.topic_name
  };
}
