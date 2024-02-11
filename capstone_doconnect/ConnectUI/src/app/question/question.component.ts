import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Question } from '../model/question';
import { QuestionBean } from '../model/questionBean';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css']
})
export class QuestionComponent implements OnInit {
  public searchText="";

  question: Question;
  user:User;
  public queError: boolean = false;
  public queMessage: string = '';
  questionbean:QuestionBean;
  click: boolean = false;
  selectedFile: any;

  constructor(private userService: UserService,public questionService: QuestionService, public router: Router, public adminService : AdminService) {
    this.question = new Question(0, 0, '', '');
    this.questionbean = new QuestionBean();
    this.user = new User();
    
  }

  ngOnInit(): void {
    this.adminService.getUserByEmail(<string>localStorage.getItem('email')).subscribe((data)=>this.user = data);
    
  }

  onFileSelected(event:any) {
    console.log("In select event function")
    if (event.target.files.length > 0) {
    const file = event.target.files[0];
    this.selectedFile = file;
    console.log(this.selectedFile);
    }
}
  onButtonClick(event: MouseEvent) {
    (event.target as HTMLButtonElement).disabled = true;

  }

  onSubmit(): any {
   
    console.log(this.question);
    this.questionbean.user_id = this.user.id;
    this.questionbean.que_id = this.question.qid;
    this.questionbean.topic = this.question.title;
    this.questionbean.description = this.question.desc;
    const formData: FormData = new FormData();
    formData.append('file', this.selectedFile);
    formData.append('question', new Blob([JSON
      .stringify(this.questionbean)], {
      type: 'application/json'
    }));
    let that = this;
    this.questionService.addQuestion(formData)
      .subscribe({
        next(data: { description: any; }) {
          that.router.navigate(['mypost']);
       },
        error(data: { error: { description: string; }; }): any {
          that.queError = true;
          that.queMessage = data.error.description
          that.router.navigate(['/question']);
        }
      });
  }

  logout(){
    this.adminService.logout();
    this.router.navigate(['/homepage']);
  }
  

}
