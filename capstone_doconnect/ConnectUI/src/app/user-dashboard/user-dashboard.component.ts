import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { QuestionBean } from '../model/questionBean';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { MessageService } from '../service/message.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  queBeanList: any;
  arrMsg:any;
  @Input()
  public searchText = "";
  click: boolean = false;
  currentUser: User;
  constructor(public questionService: QuestionService, private router: Router, public adminService : AdminService, private message : MessageService) { 
    this.currentUser = new User();
  }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe((data) => this.queBeanList = data);
    this.adminService.getUserByEmail(<string>localStorage.getItem("email")).subscribe((data) => this.currentUser = data);
    this.message.getMessage(<string>localStorage.getItem("email")).subscribe((data) => this.arrMsg = data);
  }

  onButtonClick(event: MouseEvent) {
    (event.target as HTMLButtonElement).disabled = true;

  }

  giveResponse(id: number) {
    this.router.navigate(['response', id]);
  }

  logout(){
    this.adminService.logout();
    this.router.navigate(['/homepage']);
  }

  sendMessage(id: number){
    this.router.navigate(['writeMessage', id]);
  }

}
