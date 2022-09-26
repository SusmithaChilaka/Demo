import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-stone',
  templateUrl: './stone.component.html',
  styleUrls: ['./stone.component.scss']
})
export class StoneComponent implements OnInit {

  constructor() { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
  }

}
