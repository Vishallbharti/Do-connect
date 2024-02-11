import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/admin';
import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  url: string = "http://localhost:8081/admin/"
  username: any;
  constructor(private router: Router, private http: HttpClient) {
   
  }


  // this function is used for creating new admin
  addAdmin(user: Admin): Observable<Message> {
    return this.http.post<Message>(this.url + 'adminRegister', user);
  }

  // this function is used for checking user logged in or not
  isLoggedIn() {
    this.username = localStorage.getItem('email');
    return !!localStorage.getItem('email');

  }

  // this function is used for admin login
  checkLogin(user: Admin): Observable<Message> {
    return this.http.post<Message>(this.url + 'login', user);
  }

  // this function is used for creating new user by admin
  createUser(user: User): Observable<Message> {
    return this.http.post<Message>(this.url + 'createUser', user);
  }

  // this function is used for getting user by user id
  getUserById(id: number) {
    return this.http.get(this.url + 'user/' + id);
  }

  getUserByEmail(email: string) {
    return this.http.get(this.url + 'getUserByEmail/' + email);
  }

  // this is used for getting all users details
  getUsers() {
    return this.http.get(this.url + 'allUsers');
  }

  // this function is used for updating a user 
  editUser(user: User): Observable<Message> {
    return this.http.put<Message>(this.url + 'editUser', user);
  }

  // this functiom is used for deleting a user by user id
  deleteUser(id: number): Observable<Message> {
    return this.http.delete<Message>(this.url + 'deleteUser/' + id);
  }

  // this functiona is used for approving a question by user
  approveQuestion(id:number): Observable<Message>{
    return this.http.get<Message>(this.url + 'approveQue/' + id);
  }
  // this function is used for user logout
  logout() {
    localStorage.removeItem('email');
   
  }

  deleteQuestion(id:number): Observable<Message>{
    return this.http.delete<Message>(this.url + 'deleteQue/' + id);
  }


  // This function is used for aprroving answer
  approveAns(id:number): Observable<Message>{
    return this.http.get<Message>(this.url + 'approveAns/' + id);
  }


  // this function is used for deleting answer
  deleteAns(id:number): Observable<Message>{
    return this.http.delete<Message>(this.url + 'deleteAns/' + id);
  }

}
