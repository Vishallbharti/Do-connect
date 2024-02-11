import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';
import { MessageService } from '../service/message.service';

@Component({
  selector: 'app-read-message',
  templateUrl: './read-message.component.html',
  styleUrls: ['./read-message.component.css']
})
export class ReadMessageComponent implements OnInit {
  @Input()
  public searchText = "";
  arrMsg: any;
  constructor(public adminService: AdminService, private router: Router, private message: MessageService) { }

  ngOnInit(): void {
    this.message.getMessage(<string>localStorage.getItem("email")).subscribe((data) => this.arrMsg = data);
  }

  logout() {
    this.adminService.logout();
    this.router.navigate(['/homepage']);
  }

  sendMessage(fromUserid:number, toUserId:number){
      console.log(fromUserid + " " + toUserId);
  }
}
