import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Question } from '../model/question';
import { QuestionBean } from '../model/questionBean';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {
  url :string = "http://localhost:8080/"
 
  quesList:Question[];
  constructor(private router: Router, private http : HttpClient ) {
    this.quesList = [];
   }


  addQuestion(formData: FormData):Observable<Message> {
    return this.http.post<Message>(this.url + 'insertQue', formData);
  }

  
  getQuestionById(id:number)
   {
     console.log(id);
    return this.http.get(this.url + 'question/' + id);
   }


   deleteQuestion(question:Question){
    for(var j=0;j<this.quesList.length;j++){
      if(this.quesList[j] === question){
        this.quesList.splice(j,1);
      }
    }
  }


  getAllQuestion(){
   return this.http.get(this.url + 'allQuestion');
  }

}
