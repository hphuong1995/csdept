import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  submitted = false;


  constructor(private formBuilder : FormBuilder,
                private userService : UserService,
                private router: Router,) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      email: ['', Validators.required],
      password: ['', Validators.required],
      re_password:['', Validators.required],
      fullName: ['', Validators.required],
    });
  }

  get f() { return this.registerForm.controls; }

  onSubmit(){
    if(this.f.password.value === this.f.re_password.value){
      var newUser = {'username' : this.f.username.value,
                     'email': this.f.email.value,
                     'password':this.f.password.value,
                     'fullName' : this.f.fullName.value};
      this.userService.userRegister( newUser ).subscribe( data =>{
        console.log(data);
        var retData : any = data;
        if(retData.valid === true){
          this.router.navigate(['login']);
        }
      });
    }
  }

}
