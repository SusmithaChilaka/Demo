import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import Book from './entity/book';
import { User } from './entity/user';

const API_URL = "http://localhost:8088/books/"
@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(public client:HttpClient) { } 
  saveBook(book : Book){
   return  this.client.post(API_URL,book)
  }

  getBooks(){
    return this.client.get(API_URL)
  }

  deleteBook(id: number) {
    return this.client.delete(API_URL + id);
  }

}
