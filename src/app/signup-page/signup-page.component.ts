import { NgIf } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-signup-page',
  standalone: true,
  imports: [RouterLink, FormsModule, NgIf],
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.css'
})
export class SignupPageComponent {

  errorMessage: string | undefined;

  constructor(public http: HttpClient) { }

  signUpUser(user: { username: string, email: string, password: string }) {
    console.log(user);

    this.http.post("http://localhost:8080/register", user)
      .subscribe((res) => {
        //how to register user in frontend
      },
        (error) => {
          this.errorMessage = error.error.errorMessage
          console.log
         
        });

  }


}
