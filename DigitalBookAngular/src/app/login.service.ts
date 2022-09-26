import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './entity/user';

const API_URL = "http://localhost:8088/books"
@Injectable({
  providedIn: 'root'
})

export class LoginService {
  
  book:User= new User( );
  role:string;
  constructor(public client:HttpClient) { }

  userLogin(user:User):Observable<object>{
    console.log(user)
    return this.client.post(API_URL+'/login',user);

  }

  register(user : User){
    return  this.client.post(API_URL+'/register',user)
   }
   deleteUser(id: number) {
    return this.client.delete(API_URL +'/user/'+ id);
  }
}
