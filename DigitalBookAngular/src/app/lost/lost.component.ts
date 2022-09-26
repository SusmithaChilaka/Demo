import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lost',
  templateUrl: './lost.component.html',
  styleUrls: ['./lost.component.scss']
})
export class LostComponent implements OnInit {

  constructor() { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
  }

}
