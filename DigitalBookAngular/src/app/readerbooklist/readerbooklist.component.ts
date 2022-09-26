import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-readerbooklist',
  templateUrl: './readerbooklist.component.html',
  styleUrls: ['./readerbooklist.component.scss']
})
export class ReaderbooklistComponent implements OnInit {

  books:any =[];
  constructor(public bookservice:BookService, private toast:NgToastService, private route:Router, private http:HttpClient) { }

  username:any;
  email:any;
  id:any;
  login:any;

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
    this.getBooks();
    this.username=localStorage.getItem('username');
    this.email=localStorage.getItem('email');
  }

  getBooks() {
    const observable = this.bookservice.getBooks();
    observable.subscribe(books => {
      this.books = books;
    })
  }

  PurchaseBook() {
    const data = {
      bookId: this.id,
      username: this.username,
      useremail: this.email,
    };
    this.http.post('http://localhost:8088/books/buy', data, {responseType: 'text'}).subscribe(
      (resp) => {
        console.log(data);
        alert('Purchased Successfully')
       console.log(resp);
      },
      (error) => {
        console.log('error',error);
      }
    );
    
  }
  getID(event:Event,id:any){
    this.id = id;
    console.log(this.id);
    this.PurchaseBook()
  }

  key:string ='price';
  reverse:boolean=false;
  sort(key){
    this.key=key;
    this.reverse=!this.reverse;
  }
}