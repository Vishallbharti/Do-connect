import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-edit-user',
  templateUrl: './edit-user.component.html',
  styleUrls: ['./edit-user.component.css']
})
export class EditUserComponent implements OnInit {
  isError: boolean = false;
  errMessage: string = '';
  user:User;
  constructor(private route : ActivatedRoute, private router : Router, private userService : UserService, public adminService : AdminService) {
    this.user = new User(0,' ','');
   }

  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      console.log(params.get('id'));
      let id1:string = <string>params.get('id');
      this.adminService.getUserById(parseInt(id1)).subscribe((data) =>  this.user = data);
    });
  }

  onSubmit() {
    let cuser = this.user;
    let email1: string = cuser.email!;
    let that = this;
    this.adminService.editUser(this.user)
      .subscribe({
        next(data: { description: any; }) {
          console.log('next call');
          console.log(data.description);
          that.router.navigate(['adminpanel']);
       },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          that.router.navigate(['editUser']);
        }
      });
  }

}
