import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';
import { LoginService } from '../login.service';

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.scss']
})
export class UserlistComponent implements OnInit {

  users:any =[];
  constructor(public bookservice:BookService, private toast:NgToastService, private route:Router, public loginservice:LoginService) { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    const observable = this.bookservice.getUsers();
    observable.subscribe(users => {
      this.users = users;
    })
  }

  deleteUser(id: number) {
    const observable = this.loginservice.deleteUser(id);
    observable.subscribe(response => {
      this.getUsers();
      this.toast.info({detail:"Success Message", summary:"User Deleted Successfully", duration:5000})
    },
    (error)=>{   //error handler
      this.toast.error({detail:"Error Message", summary:"Something went wrong",});
    })
  }
}
