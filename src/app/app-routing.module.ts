import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooklistComponent } from './booklist/booklist.component';
import { LoginComponent } from './login/login.component';
import { BookformComponent } from './bookform/bookform.component';
import { HomeComponent } from './home/home.component';


const routes: Routes= [
  { path: 'bookform', component:BookformComponent },
  { path: 'booklist', component:BooklistComponent},
  { path: 'home', component:HomeComponent},
  { path: 'login', component:LoginComponent},
  { path: '', redirectTo: 'login', pathMatch:'full'}

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
