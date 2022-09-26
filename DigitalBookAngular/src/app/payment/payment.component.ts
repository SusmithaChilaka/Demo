import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgToastService } from 'ng-angular-popup';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.scss']
})
export class PaymentComponent implements OnInit {

  constructor(private toast:NgToastService, private route:Router) { }


  ngOnInit(): void {
  }

  payment(){
    this.toast.success({detail:"Success Message", summary:"Payment Successfull", duration:5000})
    this.route.navigateByUrl('/readerbooklist')
  }

}
