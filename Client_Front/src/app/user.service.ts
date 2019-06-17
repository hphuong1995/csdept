import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router, ActivatedRoute } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient,
              private router: Router) { }

  logout(){
    localStorage.setItem('user', null);
    this.http.get('api/v1/logout').subscribe( data =>{
      console.log(data);
      var retData : any = data;
      if(retData.redirect){
        this.router.navigate([retData.redirect]);
      }
    });
  }

  login(user: string, password: string){
    var loginUser = { "username": user, "password": password};
    return this.http.post('api/v1/login', JSON.stringify(loginUser),{headers:{'api-key': 'csdept',
                                                                              'Content-Type': 'application/json'}});
  }

  isAuthenticated(){
    if(localStorage.getItem('user')){
      if(JSON.parse(localStorage.getItem('user'))){
        return true;
      }
    }
    return false;
  }

  getCurrentUser(){
    return JSON.parse(localStorage.getItem('user'));
  }

  userRegister( newUser : any){
    return this.http.post('api/v1/register', JSON.stringify(newUser),{headers:{'api-key': 'csdept',                                                        'Content-Type': 'application/json'}} );
  }
}
