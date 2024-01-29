import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-login-page',
  standalone: true,
  imports: [RouterLink, FormsModule, NgIf],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css'
})
  export class LoginPageComponent {


  errorsMessage: string | undefined;

    constructor(public http: HttpClient) {}

    logInUser(user: { username: string, password: string }) {
      console.log(user);
      this.http.post("http://localhost:8080/login", user)
        .subscribe((res) => {
          //how to handel log in 
        },
          (error) => {
            this.errorsMessage = error.error.errorMessage;
            console.log(this.errorsMessage);
          }


        );

    }




  

}
