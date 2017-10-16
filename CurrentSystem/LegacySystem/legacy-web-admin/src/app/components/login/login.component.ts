import { Component, OnInit } from '@angular/core';
import {User} from "./user";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User("test@test.com", "password", true);

  constructor() {
  }

  ngOnInit() {
    this.user.email = "test@test.com";
  }

}
