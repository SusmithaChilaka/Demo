import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor() { }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";
  read:string="assets/img/read.JPG";
  about:string="assets/img/about.JPG";
  book1:string="assets/img/book-1.JPG";
  book2:string="assets/img/book-2.JPG";
  book3:string="assets/img/book-3.JPG";
  book4:string="assets/img/book-4.JPG";
  book5:string="assets/img/book-5.JPG";
  book6:string="assets/img/book-6.JPG";
  white:string="assets/img/white.JPG";
  ebook:string="assets/img/ebook.JPG";

  ngOnInit(): void {
  }

}
