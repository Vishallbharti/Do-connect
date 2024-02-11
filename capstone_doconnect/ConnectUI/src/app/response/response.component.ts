import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Answer } from '../model/answer';
import { AnswerBean } from '../model/answerBean';
import { Question } from '../model/question';
import { QuestionBean } from '../model/questionBean';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { AnswerService } from '../service/answer.service';
import { QuestionService } from '../service/question.service';

@Component({
  selector: 'app-response',
  templateUrl: './response.component.html',
  styleUrls: ['./response.component.css']
})
export class ResponseComponent implements OnInit {
  public ansMessage: string = '';
  public isError: boolean = false;
  click: boolean = false;
  answer: AnswerBean;
  currentUser: User
  question: any;
  constructor(private adminService: AdminService, private answerService: AnswerService, public questionService: QuestionService, public router: Router, private route: ActivatedRoute) {
    this.question = new QuestionBean();
    this.answer = new AnswerBean(this.question);
    this.currentUser = new User();
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      let id1: string = <string>params.get('qid');
      this.questionService.getQuestionById(parseInt(id1)).subscribe((data) => this.question = data);
      this.adminService.getUserByEmail(<string>localStorage.getItem("email")).subscribe((data) => this.currentUser = data);
    });

  }

  onSubmit() {
   
    this.answer.question.que_id = this.question.que_id;
    this.answer.user_id = this.currentUser.id;
    let that = this;
    this.answerService.addAnswer(this.answer)
      .subscribe({
        next(data: { description: any; }) {
          console.log('next call');
          console.log(data.description);
          that.router.navigate(['/userPendingAnswer']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.ansMessage = data.error.description
          console.log(that.ansMessage)
          that.router.navigate(['/response', that.question.que_id]);
        }
      });

  }
  onButtonClick(event: MouseEvent) {
    (event.target as HTMLButtonElement).disabled = true;

  }



}
