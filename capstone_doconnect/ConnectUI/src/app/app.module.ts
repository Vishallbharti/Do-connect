import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';

import { UsersComponent } from './admins/users.component';
import { FormsModule } from '@angular/forms';
import { EditUserComponent } from './edit-user/edit-user.component';
import { UserFormComponent } from './user-form/user-form.component';
import { BUserComponent } from './b-user/b-user.component';
import { HomepageComponent } from './homepage/homepage.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserRegisterComponent } from './user-register/user-register.component';
import { QuestionComponent } from './question/question.component';
import { SingleQuestionComponent } from './single-question/single-question.component';
import { TypesComponent } from './types/types.component';
import { EditorModule } from '@tinymce/tinymce-angular';
import { HttpClientModule } from '@angular/common/http'; 
import { MypostComponent } from './mypost/mypost.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { PendingQuestionComponent } from './pending-question/pending-question.component';
import { ResponseComponent } from './response/response.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ViewPostComponent } from './view-post/view-post.component';
import { PendingAnswerComponent } from './pending-answer/pending-answer.component';
import { UserPendingAnswerComponent } from './user-pending-answer/user-pending-answer.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { WriteMessageComponent } from './write-message/write-message.component';
import { ReadMessageComponent } from './read-message/read-message.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FooterComponent,
    HeaderComponent,
  
    UsersComponent,
    EditUserComponent,
    UserFormComponent,
    BUserComponent,
    HomepageComponent,
    UserloginComponent,
    UserRegisterComponent,
    QuestionComponent,
    SingleQuestionComponent,
    TypesComponent,
 
    MypostComponent,
    UserDashboardComponent,
    AdminDashboardComponent,
    PendingQuestionComponent,
    ResponseComponent,
    ViewPostComponent,
    PendingAnswerComponent,
    UserPendingAnswerComponent,
    UserRegistrationComponent,
    WriteMessageComponent,
    ReadMessageComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    EditorModule,
    Ng2SearchPipeModule,
    HttpClientModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
