import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url :string = "http://localhost:8080/"
  
  userList: User[];
  username:any;
  constructor(private router: Router, private http : HttpClient) {
    this.userList = [];
  }

  getUserList():any {
    return this.userList;
    
  }

 

  addUser(user: User):  Observable<Message> {
    return this.http.post<Message>(this.url + 'register', user);
  }

  isLoggedIn() {
    this.username = localStorage.getItem('email');
    return !!localStorage.getItem('email');

  }


  checkLogin(user: User):  Observable<Message> {
    return this.http.post<Message>(this.url + 'login', user);
  }

  logout() {
    localStorage.removeItem('email');
    this.router.navigate(['']);
  }

  deleteUser(user:User){
    for(var j=0;j<this.userList.length;j++){
      if(this.userList[j] === user){
        this.userList.splice(j,1);
      }
    }
  }

  editUser(user:User){
    for(var j=0;j<this.userList.length;j++){
      if(this.userList[j].id===user.id){
        this.userList[j].name = user.name;
        this.userList[j].email=user.email;
        this.userList[j].password=user.password;
      }
    }
  }
}
