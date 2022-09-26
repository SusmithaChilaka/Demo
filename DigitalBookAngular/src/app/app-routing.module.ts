import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooklistComponent } from './booklist/booklist.component';
import { LoginComponent } from './login/login.component';
import { BookformComponent } from './bookform/bookform.component';
import { HomeComponent } from './home/home.component';
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



const routes: Routes= [
  { path: 'bookform', component:BookformComponent },
  { path: 'booklist', component:BooklistComponent},
  { path: 'home', component:HomeComponent},
  { path: 'login', component:LoginComponent},
  { path: '', redirectTo: 'login', pathMatch:'full'},
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
