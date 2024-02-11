import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-pending-answer',
  templateUrl: './pending-answer.component.html',
  styleUrls: ['./pending-answer.component.css']
})
export class PendingAnswerComponent implements OnInit {

  isError: boolean = false;
  errMessage: string = '';
  queBeanList: any;
  currentUser:User;
  public searchText = "";
  click: boolean = false;
  constructor(public questionService: QuestionService, public adminService: AdminService, private router:Router) {
    this.currentUser = new User();
   }

  ngOnInit(): void {
    this.questionService.getAllQuestion().subscribe((data) => this.queBeanList = data);
    this.adminService.getUserByEmail(<string>localStorage.getItem("email")).subscribe((data)=>this.currentUser = data);
  }
  onButtonClick(event: MouseEvent) {
    (event.target as HTMLButtonElement).disabled = true;

  }
 

  approveAnswer(queId:number){
    let that = this;
    console.log(queId);
    this.adminService.approveAns(queId)
      .subscribe({
        next(data) {
          window.location.reload();
          that.router.navigate(['pendingAnswer']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['pendingAnswer']);
        }
      });
  }

  deleteAnswer(queId:number){
    let that = this;
    console.log(queId);
    this.adminService.deleteAns(queId)
      .subscribe({
        next(data) {
          window.location.reload();
          that.router.navigate(['pendingAnswer']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['pendingAnswer']);
        }
      });
  }
  
logout(){
  this.adminService.logout();
  this.router.navigate(['/homepage']);
}

}
