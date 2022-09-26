import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';
import Book from '../entity/book';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.scss']
})
export class BooklistComponent implements OnInit {

  books:any =[];
 
  constructor(public bookservice:BookService, private toast:NgToastService, private route:Router) { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
    this.getBooks();
  }

  public popoverTitle='Title';
  public popoverMessage='message';
  public confirmClicked:boolean=false;
  public cancelClicked:boolean=false;

  getBooks() {
    const observable = this.bookservice.getBooks();
    observable.subscribe(books => {
      this.books = books;
    })
  }

  deleteBook(id: number) {
    const observable = this.bookservice.deleteBook(id);
    observable.subscribe(response => {
      this.getBooks();
      this.toast.info({detail:"Success Message", summary:"Book Deleted Successfully", duration:5000})
    },
    (error)=>{   //error handler
      this.toast.error({detail:"Error Message", summary:"Something went wrong",});
    })
  }
  updateBook(id: number){
    this.bookservice.ID=id;
  }


  key:string ='price';
  reverse:boolean=false;
  sort(key){
    this.key=key;
    this.reverse=!this.reverse;
  }
}