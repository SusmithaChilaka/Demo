import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { title } from 'process';
import { observable } from 'rxjs';
import { BookService } from '../book.service';
import Book from '../entity/book';

@Component({
  selector: 'app-searchbook',
  templateUrl: './searchbook.component.html',
  styleUrls: ['./searchbook.component.scss']
})
export class SearchbookComponent implements OnInit {

  title="";
  books:any=[];
  author="";
  price="";
  publisher="";
  date="";
  category="";
  content="";

  public searchform:FormGroup
  constructor(public bookservice:BookService, private toast:NgToastService, private route:Router) {
    this.searchform=new FormGroup({
      'title': new FormControl(''),
    }) 
   }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
    
  }

  searchBook(title) {
    const observable = this.bookservice.searchBook(this.title);
    console.log(this.title);
    observable.subscribe(books => {
      this.books=books;
      console.log(this.books);
    },
    (error)=>{   //error handler
      this.toast.warning({detail:"Error Message", summary:"No Book Found",});
    })
  }
} 