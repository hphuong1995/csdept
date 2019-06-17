import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';


@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  private courses: Object;

  constructor( private _location: Location,
                private data: DataService,
               private router: Router) { }

  ngOnInit() {
    this.data.getCourses().subscribe(data => {
      var retData : any = data;
      if(retData.redirect){
        console.log(retData.redirect);
        this.router.navigate([retData.redirect]);
      }else{
        this.courses = data;
      }
    })
  }

  setCurrentCourses(course){
    localStorage.setItem("currentCourse", JSON.stringify(course));
  }

  back() {
    this._location.back();
  }
}
