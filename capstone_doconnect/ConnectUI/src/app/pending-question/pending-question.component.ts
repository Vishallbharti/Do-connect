import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-pending-question',
  templateUrl: './pending-question.component.html',
  styleUrls: ['./pending-question.component.css']
})
export class PendingQuestionComponent implements OnInit {
  isError: boolean = false;
  errMessage: string = '';
  queBeanList: any;
  public searchText = "";
  click: boolean = false;
  constructor(public questionService: QuestionService, public adminService: AdminService, private router:Router) { }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe((data) => this.queBeanList = data);
  }
  onButtonClick(event: MouseEvent) {
    (event.target as HTMLButtonElement).disabled = true;

  }
  selectUrl(){
    
  }

  approveQuestion(queId:number){
    let that = this;
    console.log(queId);
    this.adminService.approveQuestion(queId)
      .subscribe({
        next(data) {
          window.location.reload();
          that.router.navigate(['pendingQuestion']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['pendingQuestion']);
        }
      });
  }

  deleteQuestion(queId:number){
    let that = this;
    console.log(queId);
    this.adminService.deleteQuestion(queId)
      .subscribe({
        next(data) {
          window.location.reload();
          that.router.navigate(['pendingQuestion']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['pendingQuestion']);
        }
      });
  }
  


}
