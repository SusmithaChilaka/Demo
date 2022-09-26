import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {

  constructor(private toast:NgToastService, private route:Router) { }

  ngOnInit(): void {
  }

  contact(){
    this.toast.success({detail:"Success Message", summary:"Message sent successfully", duration:5000})
    this.route.navigateByUrl('/readerhome')
  }

}
