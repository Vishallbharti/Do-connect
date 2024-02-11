import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user !: User;
  isError: boolean = false;
  errMessage: string = '';

  constructor(private userService: UserService, private router: Router,private adminService:AdminService) {
    this.user = new User( 0, '', '','');
   }

  userRegistration() {
    let cuser = this.user;
    let email1: string = cuser.email!;
    let that = this;
    this.userService.addUser(this.user)
      .subscribe({
        next(data: { description: any; }) {
          console.log('next call');
          console.log(data.description);
          that.router.navigate(['userLogin']);
       },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['userRegister']);
        }
      });
  }

  ngOnInit(): void {
  }


}
