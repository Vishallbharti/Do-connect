import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-user-register',
  templateUrl: './user-register.component.html',
  styleUrls: ['./user-register.component.css']
})
export class UserRegisterComponent implements OnInit {

  user !: User;
  isError: boolean = false;
  errMessage: string = '';

  constructor(private userService: UserService, private router: Router) {
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
          that.router.navigate(['/adminpanel']);
       },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['usersignup']);
        }
      });
  }

  ngOnInit(): void {
  }

}
