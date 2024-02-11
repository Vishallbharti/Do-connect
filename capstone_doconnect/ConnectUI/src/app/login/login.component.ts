import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/admin';
import { AdminService } from '../service/admin.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isError: boolean = false;
  errMessage: string = '';
  admin: Admin;

  constructor(public adminService: AdminService, private router: Router) {
    this.admin = { 'email': '', 'password': '' };

  }

  ngOnInit(): void {
  }

  login() {
    let cuser = this.admin;
    let email1: string = cuser.email!;
    let that = this;
    this.adminService.checkLogin(this.admin)
      .subscribe({
        next(data) {
          console.log('next call');
          console.log(data.description === 'success');

          localStorage.setItem('email', email1);
          that.router.navigate(['adminDashboard']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['login']);
        }
      });
  }

}
