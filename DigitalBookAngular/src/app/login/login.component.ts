import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { User } from '../entity/user';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  
  public loginform:FormGroup
  user:User = new User();
  submitted=false;
  constructor(public loginservice:LoginService, private toast:NgToastService, private route:Router, private Http:HttpClient) {
    this.loginform=new FormGroup({
      'username': new FormControl('',Validators.required),
      'password': new FormControl('',Validators.required),
    })
  }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";
  ebook:string="assets/img/ebook.JPG";
  Role:any;
  ngOnInit(): void {
  }
  onSubmit() {
    this.submitted = true;
    this.userLogin();
  }
  userLogin(){
    console.log(this.user);
    localStorage.setItem('email',this.user.email);
    localStorage.setItem('username',this.user.username);
    
    this.loginservice.userLogin(this.user).subscribe(data=>{
     // console.log(data);
      this.Http.get("http://localhost:8088/books/user/"+this.user.username).subscribe(response=>{
            //console.log(JSON.stringify(response));
            type responsekey=keyof typeof response;
            let name='role' as responsekey;
            console.log(response[name]);
            this.Role=response[name];
            if(this.Role=="author"){
              this.route.navigateByUrl('/home');
            }
            else if(this.Role=="reader"){
              this.route.navigateByUrl('/readerhome');
            }
            else if(this.Role=="admin"){
              this.route.navigateByUrl('/adminhome');
            }
      })
      this.toast.success({detail:"Success Message", summary:"Login successful", duration:5000})
    }, 
    error=> this.toast.error({detail:"Error Message", summary:"Please provide correct credentials",}));
  }
}