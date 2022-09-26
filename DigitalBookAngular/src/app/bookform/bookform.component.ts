import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { NgToastService } from 'ng-angular-popup';
import { BookService } from '../book.service';
import Book from '../entity/book';

@Component({
  selector: 'app-bookform',
  templateUrl: './bookform.component.html',
  styleUrls: ['./bookform.component.scss']
})
export class BookformComponent implements OnInit{

  public createform:FormGroup
  book:Book= new Book('', '','','','', null ,'');

  constructor(public bookservice:BookService, private toast:NgToastService) {
    this.createform=new FormGroup({
      'title': new FormControl('',Validators.required),
      'author': new FormControl('',Validators.required),
      'publisher':new FormControl('',Validators.required),
      //'date':new FormControl('',Validators.required),
      'content':new FormControl('',Validators.required),
      'price':new FormControl('',Validators.required),
    })
   }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG"
  ngOnInit(): void {
   
  }

  save(){

    console.log ('clicked');
    const observable = this.bookservice.saveBook(this.book);
    observable.subscribe((response)=>{ //sucess handler
      console.log(response);
      this.book = new Book('','','','','',0,'');
      this.toast.success({detail:"Success Message", summary:"Book Created Successfully", duration:5000})
    },
    (error)=>{   //error handler
      this.toast.error({detail:"Error Message", summary:"Something went wrong",});
    }
    )
  }
}