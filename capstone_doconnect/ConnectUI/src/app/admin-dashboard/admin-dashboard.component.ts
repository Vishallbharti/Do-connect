import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  queBeanList:any;
  public searchText="";
  click : boolean = false;
  constructor(public questionService: QuestionService, private router : Router, public adminService : AdminService) { }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe((data) => this.queBeanList = data);
  
  }
  onButtonClick(event : MouseEvent){
    (event.target as HTMLButtonElement).disabled = true;

}

giveResponse(question: Question) {

  console.log(question);
  this.router.navigate(['response', question.qid]);


}
logout(){
  this.adminService.logout();
  this.router.navigate(['/homepage']);
}

}
