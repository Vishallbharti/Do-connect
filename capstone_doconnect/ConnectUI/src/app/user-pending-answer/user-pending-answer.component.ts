import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-user-pending-answer',
  templateUrl: './user-pending-answer.component.html',
  styleUrls: ['./user-pending-answer.component.css']
})
export class UserPendingAnswerComponent implements OnInit {

  queBeanList:any;
  click: boolean=false;
  currentUser:User;
  @Input()
  public searchText="";

  constructor(public questionService:QuestionService, public adminService : AdminService, private router : Router) { 
    this.currentUser = new User();
  }

  ngOnInit(): void {
    this.adminService.getUserByEmail(<string>localStorage.getItem("email")).subscribe((data)=>this.currentUser = data);
    this.questionService.getAllQuestion().subscribe((data)=>this.queBeanList = data);
    this.questionService.getAllQuestion().subscribe((data)=>console.log(data));

  }
  

  onButtonClick(event : MouseEvent){
    (event.target as HTMLButtonElement).disabled = true;

}
logout(){
  this.adminService.logout();
  this.router.navigate(['/homepage']);
}

}
