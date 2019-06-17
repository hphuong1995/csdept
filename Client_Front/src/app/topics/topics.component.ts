import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../user.service';


@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit {
  topics: Object;
  currentCourse : string;
  currentInstructorId : string;

  constructor( private _location: Location,
              private dataService: DataService,
              private route:ActivatedRoute,
              private userService: UserService) { }

  ngOnInit() {
    this.currentCourse = JSON.parse(localStorage.getItem('currentCourse'));
    this.dataService.getTopics(this.route.snapshot.params['cid']).subscribe(data => {
      this.topics = data;
      console.log(this.currentCourse);
    })
  }

  setCurrentTopic(currentTopic :string){
    localStorage.setItem("currentTopic", currentTopic);
  }

  back() {
    this._location.back();
  }
}
