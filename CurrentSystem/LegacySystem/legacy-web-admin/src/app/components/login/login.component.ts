import {Component, OnInit} from '@angular/core';
import {User} from "../../model/user";
import {AuthenticationService} from "../../service/authentication.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User("", "", true);

  constructor(private authenticationService: AuthenticationService) {
  }

  ngOnInit() {
    this.user.email = "oat@meal.com";
    this.user.password = "password";
  }

  login() {
    console.log(`login:  ${this.user}`);
    this.authenticationService.login(this.user);
  }

}
