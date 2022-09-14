import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import Book from '../entity/book';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})
export class BookformComponent implements OnInit{

  book:Book= new Book('Othello', 'shakesphere','SVNC','1998-08-17','drama', 500 ,'othello book');
  books:any =[];
 
  constructor(public bookservice:BookService) { }
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
    })
  }

  save(){

    console.log ('clicked');
    const observable = this.bookservice.saveBook(this.book);
    observable.subscribe((response)=>{ //sucess handler
      console.log(response);
    },
    (error)=>{   //error handler
      alert('something went wrong');
    }
    )
  }

}
