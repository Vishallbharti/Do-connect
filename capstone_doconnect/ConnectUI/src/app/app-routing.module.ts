import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AuthGuard } from './authenticate/auth.guard';
import { BUserComponent } from './b-user/b-user.component';
import { EditUserComponent } from './edit-user/edit-user.component';
import { HomepageComponent } from './homepage/homepage.component';
import { LoginComponent } from './login/login.component';
import { MypostComponent } from './mypost/mypost.component';
import { PendingAnswerComponent } from './pending-answer/pending-answer.component';
import { PendingQuestionComponent } from './pending-question/pending-question.component';
import { QuestionComponent } from './question/question.component';
import { ReadMessageComponent } from './read-message/read-message.component';
import { RegisterComponent } from './register/register.component';
import { ResponseComponent } from './response/response.component';
import { SingleQuestionComponent } from './single-question/single-question.component';
import { TypesComponent } from './types/types.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UserFormComponent } from './user-form/user-form.component';
import { UserPendingAnswerComponent } from './user-pending-answer/user-pending-answer.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

import { UserloginComponent } from './userlogin/userlogin.component';
import { WriteMessageComponent } from './write-message/write-message.component';


const routes: Routes = [
  {path: '', redirectTo: 'homepage', pathMatch:'full'},
  {path: 'adminlogin', component:LoginComponent, },
  {path:'pendingQuestion',component:PendingQuestionComponent,canActivate: [AuthGuard]},
  {path:'response/:qid',component:ResponseComponent,canActivate: [AuthGuard]},
  {path: 'adminsignup', component:RegisterComponent },
  {path: 'adminpanel/addUser', component:UserFormComponent,canActivate: [AuthGuard] },
  {path: 'editUser/:id', component:EditUserComponent,canActivate: [AuthGuard] },
  {path:'question',component:QuestionComponent,canActivate: [AuthGuard]},
  {path: 'homepage',component:HomepageComponent},
  {path:'userLogin',component:UserloginComponent},
  {path: 'userRegister',component:UserRegistrationComponent},
  {path:'adminpanel/usersignup',component:UserRegisterComponent,canActivate: [AuthGuard]},
  {path:'sques',component:SingleQuestionComponent,canActivate: [AuthGuard]},
  {path:'types',component:TypesComponent,canActivate: [AuthGuard]},
  {path:'adminDashboard',component:AdminDashboardComponent,canActivate: [AuthGuard]},
  {path:'userDashboard',component:UserDashboardComponent},
  {path:'mypost',component:MypostComponent,canActivate: [AuthGuard]},
  {path: 'adminpanel', component:BUserComponent,canActivate: [AuthGuard] },
  {path:'pendingAnswer',component:PendingAnswerComponent,canActivate: [AuthGuard]},
  {path:'userPendingAnswer',component:UserPendingAnswerComponent,canActivate: [AuthGuard]},
  {path:'writeMessage/:id',component:WriteMessageComponent,canActivate: [AuthGuard]},
  {path:'readMessage',component:ReadMessageComponent,canActivate: [AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
