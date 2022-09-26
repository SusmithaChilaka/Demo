import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  constructor() { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
  }

}
