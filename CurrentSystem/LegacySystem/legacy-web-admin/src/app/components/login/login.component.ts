import { Component, OnInit } from '@angular/core';
import {User} from "./user";
import {AuthenticationService} from "../../service/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User("test@test.com", "password", true);

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.user.email = "test@test.com";
  }

  login() {
    console.log(`login:  + ${this.user}`);
    this.authenticationService.login(this.user.email, this.user.password);
  }

}
