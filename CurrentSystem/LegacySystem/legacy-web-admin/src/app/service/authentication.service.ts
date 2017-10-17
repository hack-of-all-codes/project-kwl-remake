import { Injectable } from '@angular/core';
import {User} from "../model/user";

@Injectable()
export class AuthenticationService {

  constructor() { }

  login(user: User) {
    console.log(`login with email: ${user}`)
  }
}
