import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  isError: boolean = false;
  errMessage: string = '';
  user!: User;

  constructor(public userService : UserService,private router: Router){
        this.user = { 'email': '', 'password': '' };
    
  }
    
  
    ngOnInit(): void {
    }
    
    login() {
      let cuser = this.user;
      let email1: string = cuser.email!;
      let that = this;
      this.userService.checkLogin(this.user)
        .subscribe({
          next(data: { description: string; }) {
            console.log('next call');
            localStorage.setItem('email', email1);
            that.router.navigate(['userDashboard'])
          },
          error(data: { error: { description: string; }; }): any {
            console.log('error call')
            console.log(data.error)
            that.isError = true;
            that.errMessage = data.error.description
            console.log(that.errMessage)
            that.router.navigate(['userlogin']);
          }
        });
    }
    

}
