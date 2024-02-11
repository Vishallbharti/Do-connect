import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Answer } from '../model/answer';
import { AnswerBean } from '../model/answerBean';


@Injectable({
  providedIn: 'root'
})
export class AnswerService {
  url :string = "http://localhost:8080/"
  answerList:Answer[];
    
  constructor(private router: Router, private http : HttpClient) {
    this.answerList = [];
   }


   addAnswer(answer:AnswerBean):Observable<Message>
   {
    return this.http.post<Message>(this.url + 'insertAns',answer );
   }
  
}
