import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import Book from '../entity/book';
import { NgToastService } from 'ng-angular-popup';
import { ActivatedRoute, Router } from '@angular/router';
import { AnyTxtRecord } from 'dns';
import { JsonpClientBackend } from '@angular/common/http';

@Component({
  selector: 'app-updateform',
  templateUrl: './updateform.component.html',
  styleUrls: ['./updateform.component.scss']
})
export class UpdateformComponent implements OnInit {
  id:any;
  book:any;

  constructor(public bookservice:BookService, private toast:NgToastService, private router: Router, private route: ActivatedRoute) { }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"

  ngOnInit(): void {
    this.book = new Book('Othello', 'shakesphere','SVNC','1998-08-17','drama', 500 ,'othello book');//empty

    this.id = this.route.snapshot.params['id'];
    console.log(this.bookservice.ID); 
    this.bookservice.getBooks()
      .subscribe(data => {
        console.log(data)
        console.log(data[length]);
        //console.log(Object.keys(data).length);
        for (let i=0;i<10; i++){
          if (this.bookservice.ID==data[i].id) {
            console.log("if passed");
            this.book = new Book(data[i].title,data[i].author, data[i].publisher,data[i].date,data[i].category,data[i].price,data[i].content) ;

           }
        } 
      }, error => console.log(error)); 
  }

  updateBook() {
    this.bookservice.updateBook(this.bookservice.ID, this.book)
      .subscribe(data => {
        console.log(data);
        this.book = new Book('','','','','',0,'');

        this.toast.success({detail:"Success Message", summary:"Book updated Successfully", duration:3000})
      },
       (error)=>{   //error handler
        this.toast.error({detail:"Error Message", summary:"Something went wrong", duration:3000});
      });
  }

}