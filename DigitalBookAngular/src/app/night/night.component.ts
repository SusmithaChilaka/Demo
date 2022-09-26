import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-night',
  templateUrl: './night.component.html',
  styleUrls: ['./night.component.scss']
})
export class NightComponent implements OnInit {

  constructor() { }
  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
  }

}
