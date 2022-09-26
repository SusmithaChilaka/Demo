import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-hobbit',
  templateUrl: './hobbit.component.html',
  styleUrls: ['./hobbit.component.scss']
})
export class HobbitComponent implements OnInit {

  constructor() { }

  myimage:string="assets/img/digitalbookimage.JPG";
  sky:string="assets/img/sky.JPG";

  ngOnInit(): void {
  }

}
