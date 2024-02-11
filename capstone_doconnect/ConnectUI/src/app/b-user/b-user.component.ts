import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AdminService } from '../service/admin.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-b-user',
  templateUrl: './b-user.component.html',
  styleUrls: ['./b-user.component.css']
})
export class BUserComponent implements OnInit {
  public searchText="";
  users:User[];
  usrs:any; 
  user:User;
  isError: boolean = false;
  errMessage: string = '';

  constructor( public userService : UserService, public adminService : AdminService, private router : Router) { 
    this.users = userService.userList;
    this.user = new User(0,' ','');
  }

  ngOnInit(): void {
    this.adminService.getUsers().subscribe((data) => this.usrs = data);
    }

    
  delete(userId:number)
  {
    console.log(userId);
    // this.userService.deleteUser(user);

    let cuser = this.user;
    let id: any = cuser.id;
    let that = this;
    this.adminService.deleteUser(userId)
      .subscribe({
        next(data) {
          window.location.reload();
          that.router.navigate(['adminpanel']);
       },
        error(data: { error: { description: string; }; }): any {
          console.log('error call')
          console.log(data.error)
          that.isError = true;
          that.errMessage = data.error.description
          console.log(that.errMessage)
          
          that.router.navigate(['adminpanel']);
        }
      });
  }

  edit(user:User)
  {
    this.router.navigate(['editUser',user.id]);
    
  }

  

logout(){
  this.adminService.logout();
  this.router.navigate(['/homepage']);
}
  
}
