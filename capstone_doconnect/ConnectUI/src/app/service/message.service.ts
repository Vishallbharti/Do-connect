import { HttpClient } from '@angular/common/http';
import { Message } from '@angular/compiler/src/i18n/i18n_ast';
import { Injectable } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import{ WriteMessage} from '../model/writeMessage'

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  url :string = "http://localhost:8080/"
  constructor(public router: Router, private route: ActivatedRoute,private http : HttpClient) { }

  public senMessage(message:WriteMessage):Observable<Message>{
    return this.http.post<Message>(this.url + 'insertMessage', message);
  }

  public getMessage(email:string){
    return this.http.get(this.url + 'userMsg/'+email);
  }
}
