import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../model/admin';
import { AdminService } from '../service/admin.service';


@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  isError: boolean = false;
  errMessage: string = '';
  admin: Admin;
  constructor(private adminService: AdminService, private router: Router) {
    this.admin = new Admin('', '', '');
  }

  adminRegistration():any {

    let cuser = this.admin;
    let email1: string = cuser.email!;
    let that = this;
    this.adminService.addAdmin(this.admin)
      .subscribe({
        next(data) {
          localStorage.setItem('email', email1);
          that.router.navigate(['adminlogin']);
        },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['adminsignup']);
        }
      });

  }

  ngOnInit(): void {
  }

}
