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


const routes: Routes= [
  { path: 'bookform', component:BookformComponent },
  { path: 'booklist', component:BooklistComponent},
  { path: 'home', component:HomeComponent},
  { path: 'register', component:RegisterComponent},

]

@NgModule({
  declarations: [
    AppComponent,
    BookformComponent,
    BooklistComponent,
    LoginComponent,
    HomeComponent,
    RegisterComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule, HttpClientModule,  RouterModule.forRoot(routes), NgToastModule, ReactiveFormsModule,
    MatDatepickerModule,MatInputModule,  MatNativeDateModule, BrowserAnimationsModule, NgxSliderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
