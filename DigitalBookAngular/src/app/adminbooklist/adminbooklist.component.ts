import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';

@Component({
  selector: 'app-adminbooklist',
  templateUrl: './adminbooklist.component.html',
  styleUrls: ['./adminbooklist.component.scss']
})
export class AdminbooklistComponent implements OnInit {

  books:any =[];
  constructor(public bookservice:BookService, private toast:NgToastService, private route:Router) { }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
    this.getBooks();
  }

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

}
