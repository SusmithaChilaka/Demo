import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookformComponent } from './bookform/bookform.component';
import {HttpClientModule} from "@angular/common/http";
import { RouterModule, Routes } from '@angular/router';
import { BooklistComponent } from './booklist/booklist.component';
import { LoginComponent } from './login/login.component';

import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { NgToastModule } from 'ng-angular-popup';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgxSliderModule } from '@angular-slider/ngx-slider';
import {MatSortModule} from '@angular/material/sort';
import { UpdateformComponent } from './updateform/updateform.component';
import { ReaderhomeComponent } from './readerhome/readerhome.component';
import { ReaderbooklistComponent } from './readerbooklist/readerbooklist.component';
import { PaymentComponent } from './payment/payment.component';
import { AboutComponent } from './about/about.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { UserlistComponent } from './userlist/userlist.component';
import { AdminbooklistComponent } from './adminbooklist/adminbooklist.component';
import { StoneComponent } from './stone/stone.component';
import { HobbitComponent } from './hobbit/hobbit.component';
import { NightComponent } from './night/night.component';
import { LostComponent } from './lost/lost.component';
import { GirlComponent } from './girl/girl.component';
import { SearchbookComponent } from './searchbook/searchbook.component';
import { ContactComponent } from './contact/contact.component';
import { ConfirmationPopoverModule} from 'angular-confirmation-popover';
import { MatDialogModule} from '@angular/material/dialog'
import {Ng2OrderModule} from 'ng2-order-pipe';

const routes: Routes= [
  { path: 'bookform', component:BookformComponent },
  { path: 'booklist', component:BooklistComponent},
  { path: 'home', component:HomeComponent},
  { path: 'register', component:RegisterComponent},
  { path: 'updateform', component:UpdateformComponent},
  { path: 'readerhome', component:ReaderhomeComponent},
  { path: 'readerbooklist', component:ReaderbooklistComponent},
  { path: 'payment', component:PaymentComponent},
  { path: 'about', component:AboutComponent},
  { path: 'adminhome', component:AdminhomeComponent},
  { path: 'userlist', component:UserlistComponent},
  { path: 'adminbooklist', component:AdminbooklistComponent},
  { path: 'stone', component:StoneComponent},
  { path: 'hobbit', component:HobbitComponent},
  { path: 'night', component:NightComponent},
  { path: 'lost', component:LostComponent},
  { path: 'girl', component:GirlComponent},
  { path: 'searchbook', component:SearchbookComponent},
  { path: 'contact', component:ContactComponent},


]

@NgModule({
  declarations: [
    AppComponent,
    BookformComponent,
    BooklistComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    UpdateformComponent,
    ReaderhomeComponent,
    ReaderbooklistComponent,
    PaymentComponent,
    AboutComponent,
    AdminhomeComponent,
    UserlistComponent,
    AdminbooklistComponent,
    StoneComponent,
    HobbitComponent,
    NightComponent,
    LostComponent,
    GirlComponent,
    SearchbookComponent,
    ContactComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, HttpClientModule,  RouterModule.forRoot(routes), NgToastModule, ReactiveFormsModule,
    MatDatepickerModule,MatInputModule,  MatNativeDateModule, BrowserAnimationsModule, NgxSliderModule, MatSortModule, MatDialogModule,  
    Ng2OrderModule, 
    ConfirmationPopoverModule.forRoot({
       confirmButtonType:'danger'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
