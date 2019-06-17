import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(  private formBuilder : FormBuilder,
                private userService : UserService,
                private router: Router,
              ) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });
  }

  get f() { return this.loginForm.controls; }

  onSubmit() {
      this.submitted = true;
      // stop here if form is invalid
      if (this.loginForm.invalid) {
          return;
      }

      this.loading = true;
      this.userService.login(this.f.username.value, this.f.password.value).subscribe(data => {
        var retData : any;
        retData = data;
        this.loading = false;
        if(retData.success === true){
          delete retData.success;
          localStorage.setItem('user', JSON.stringify(retData));
          this.router.navigate(['courses']);
        }
        else{
          this.submitted = false;
        }
      });


  }
}
