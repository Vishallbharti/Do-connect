import { Component, Input, OnInit, QueryList } from '@angular/core';
import { Answer } from '../model/answer';
import { Question } from '../model/question';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  queBeanList:any;
  @Input()
  public searchText="";
  isDisabled=false;
  question: Question[]=[];

 
  
  constructor(public questionService : QuestionService,public userService:UserService ) {
    //  console.log(questionService.getAllQuestion());
   }
  
   

  ngOnInit(): void {

    if(this.userService.isLoggedIn()){
      this.isDisabled=true;
    }
    let that = this;
    this.questionService.getAllQuestion().subscribe((data)=>this.queBeanList = data);
    
  }

  

}
