
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { WriteMessage } from '../model/writeMessage';
import { AdminService } from '../service/admin.service';
import { QuestionService } from '../service/question.service';
import { UserService } from '../service/user.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-write-message',
  templateUrl: './write-message.component.html',
  styleUrls: ['./write-message.component.css']
})
export class WriteMessageComponent implements OnInit {
  public queError: boolean = false;
  public queMessage: string = '';

  writeMsg:WriteMessage;
  click: boolean = false;
  currentUser: User
  question: any;
  constructor(private messageService: MessageService,private adminService: AdminService, private userService: UserService, public questionService: QuestionService, public router: Router, private route: ActivatedRoute) { 
    this.currentUser = new User();
    this.writeMsg = new WriteMessage();
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      console.log(params.get('id'));
      let id1: string = <string>params.get('id');
      this.questionService.getQuestionById(parseInt(id1)).subscribe((data) => this.question = data);
      this.questionService.getQuestionById(parseInt(id1)).subscribe((data) => console.log(data));
      this.adminService.getUserByEmail(<string>localStorage.getItem("email")).subscribe((data) => this.currentUser = data);
    });
  }

  onSubmit(): any {
   
    
    this.writeMsg.fromUserId = this.currentUser.id;
    this.writeMsg.toUserId = this.question.user_id;
    
    console.log(this.writeMsg);
    
    let that = this;
    this.messageService.senMessage(this.writeMsg)
      .subscribe({
        next(data: { description: any; }) {
          console.log(data.description);
          that.router.navigate(['userDashboard']);
       },
        error(data: { error: { description: string; }; }): any {
          that.queError = true;
          that.queMessage = data.error.description
          that.router.navigate(['/writeMessage']);
        }
      });
  }

}
