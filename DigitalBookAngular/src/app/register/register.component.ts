import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../entity/user';
import { LoginService } from '../login.service';
import {FormBuilder, FormControl, FormGroup, FormsModule, Validators} from '@angular/forms'
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  public loginform:FormGroup
  user:User = new User();
  constructor(public loginservice:LoginService, private route:Router, private toast:NgToastService) { 
    this.loginform=new FormGroup({
      'username': new FormControl('',Validators.required),
      'password': new FormControl('',[Validators.required, Validators.maxLength(20),Validators.minLength(4)]),
      'email': new FormControl('',[Validators.required, Validators.email]),
      'mobilenumber': new FormControl('',[Validators.required, Validators.maxLength(10)]),
      'role':new FormControl('',Validators.required),
    })
   }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
  }

  register(){
    console.log ('clicked');
    const observable = this.loginservice.register(this.user);
    observable.subscribe((response)=>{ //sucess handler
      console.log(response);
      this.route.navigateByUrl('/login')
      this.toast.success({detail:"Success Message", summary:"Registered successfully", duration:5000})
    },
    (error)=>{   //error handler
      this.toast.error({detail:"Error Message", summary:"Please check the details you have entered",});
    }
    )
  }
  
}

