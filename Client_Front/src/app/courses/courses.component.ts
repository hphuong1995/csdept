import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import { UserService } from '../user.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import * as $ from 'jquery';


@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  private courses: Object;

  editCourseForm: FormGroup;
  createCourseForm: FormGroup;
  currentEditCourse: string = "";

  missingInputForCreatingCourse: boolean = false;

  constructor(  private _location: Location,
                private dataService: DataService,
                private userService: UserService,
                private router: Router,
                private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.editCourseForm = this.formBuilder.group({
      course_name_edit: ['', Validators.required],
    });
    this.createCourseForm = this.formBuilder.group({
      course_name_create: ['', Validators.required],
    });

    this.dataService.getCourses().subscribe(data => {
      var retData : any = data;
      if(retData.redirect){
        this.router.navigate([retData.redirect]);
      }else{
        this.courses = data;
      }
    })
  }

  setCurrentCourses(course){
    localStorage.setItem("currentCourse", JSON.stringify(course));
  }

  get editCourseFormControl() { return this.editCourseForm.controls; }
  get createCourseFormControl() { return this.createCourseForm.controls; }


  submitCreateCourse(){
    this.dataService.createNewCourse(this.createCourseFormControl.course_name_create.value, this.userService.getCurrentUser().uid).subscribe(data =>{
      this.courses = data;
    });
  }

  removeCourse(course){
    this.dataService.deleteCourse(course.cid).subscribe(data =>{
      this.courses = data;
    });
  }

  startEdit(course){
    this.currentEditCourse = course.cid;
    this.editCourseForm = this.formBuilder.group({
      course_name_edit: [course.course_name, Validators.required],
    });
  }

  submitEditCourse(){
    this.dataService.editCourse(this.editCourseFormControl.course_name_edit.value, this.currentEditCourse).subscribe(data =>{
      this.courses = data;
    });
  }

  back() {
    this._location.back();
  }
}
