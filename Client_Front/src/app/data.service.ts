import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class DataService {

  public currentCourse: string;
  public currentTopic: string;
  public currentCourseId: string;

  constructor( private http: HttpClient) { }

  getCourses(){
    return this.http.get('/api/v1/courses');
  }

  getTopics(cid : string){
    console.log('/api/v1/courses/' + cid + '/topics');
    return this.http.get('/api/v1/courses/' + cid + '/topics');
  }

  getQuestions(cid: string, tid : string){
    return this.http.get('api/v1/courses/' + cid + '/topics/' + tid + '/questions')
  }

  getOptionsOfMultQuestion( qid: string){
    return this.http.get('api/v1/questions/' + qid + "/options");
  }

  getAllTopics(cid :string){
    return this.http.get('api/v1/topics?cid=' + cid);
  }

  addTopicToCourse( tid: string, cid: string ){
    return this.http.post('api/v1/admin/courses/' + cid + "/topics", {tid: tid, cid: cid});
  }

  updateTopic( updatedTopic : any, cid: string){
    return this.http.put('api/v1/admin/courses/' + cid + "/topics/" + updatedTopic.tid, updatedTopic);
  }

  removeTopicFromCourse(tid : string, cid : string){
    return this.http.delete('api/v1/admin/courses/' + cid + "/topics/" + tid);
  }
}
