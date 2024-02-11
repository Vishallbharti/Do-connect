import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
  isError: boolean = false;
  errMessage: string = '';
  user:User;
  constructor(private router : Router, public adminService : AdminService, private userService : UserService) {
    this.user = new User(0,'','',);
  }

  ngOnInit(): void {
  }

  onSubmit():any
  {
    console.log(this.user);
    let cuser = this.user;
    let email1: string = cuser.email!;
    let that = this;
    this.adminService.createUser(this.user)
      .subscribe({
        next(data: { description: any; }) {
          console.log('next call');
          console.log(data.description);
          that.router.navigate(['/adminpanel']);
       },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['addUser']);
        }
      });
  }

}
