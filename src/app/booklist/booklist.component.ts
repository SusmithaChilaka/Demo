import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';

@Component({
  selector: 'app-booklist',
  templateUrl: './booklist.component.html',
  styleUrls: ['./booklist.component.scss']
})
export class BooklistComponent implements OnInit {

  books:any =[];
 
  constructor(public bookservice:BookService, private toast:NgToastService) { }

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

}
