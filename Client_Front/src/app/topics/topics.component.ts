import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';


@Component({
  selector: 'app-topics',
  templateUrl: './topics.component.html',
  styleUrls: ['./topics.component.css']
})
export class TopicsComponent implements OnInit {
  topics: Object;
  currentCourse : string;

  constructor( private _location: Location,
              private data: DataService,
              private route:ActivatedRoute) { }

  ngOnInit() {
    this.currentCourse = JSON.parse(JSON.stringify(localStorage.getItem('currentCourse')));
    console.log();
    this.data.getTopics(this.route.snapshot.params['cid']).subscribe(data => {
      this.topics = data;
    })
  }

  setCurrentTopic(currentTopic :string){
    localStorage.setItem("currentTopic", currentTopic);
  }

  back() {
    this._location.back();
  }
}
