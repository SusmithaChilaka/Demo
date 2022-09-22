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
  constructor(public loginservice:LoginService, private toast:NgToastService, private route:Router) {
    this.loginform=new FormGroup({
      'username': new FormControl('',Validators.required),
      'password': new FormControl('',Validators.required),
    })
  }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";
  ebook:string="assets/img/ebook.JPG";

  ngOnInit(): void {
  }
  userLogin(){
    console.log(this.user);
    this.loginservice.userLogin(this.user).subscribe(data=>{
      this.route.navigateByUrl('/home')
      this.toast.success({detail:"Success Message", summary:"Login successful", duration:5000})
    }, error=> this.toast.error({detail:"Error Message", summary:"Please provide correct credentials",}));
  }
}