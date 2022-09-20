import { Component, OnInit } from '@angular/core';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';
import Book from '../entity/book';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})
export class BookformComponent implements OnInit{

  book:Book= new Book('Othello', 'shakesphere','SVNC','1998-08-17','drama', 500 ,'othello book');

  constructor(public bookservice:BookService, private toast:NgToastService) { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"
  ngOnInit(): void {
   
  }

  save(){

    console.log ('clicked');
    const observable = this.bookservice.saveBook(this.book);
    observable.subscribe((response)=>{ //sucess handler
      console.log(response);
      this.toast.success({detail:"Success Message", summary:"Book Created Successfully", duration:5000})
    },
    (error)=>{   //error handler
      this.toast.error({detail:"Error Message", summary:"Something went wrong",});
    }
    )
  }
}