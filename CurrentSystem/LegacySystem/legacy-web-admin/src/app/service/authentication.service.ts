import { Injectable } from '@angular/core';

@Injectable()
export class AuthenticationService {

  constructor() { }

  login(email: string, password: string) {
    console.log(`login with email: ${email} and password: ${password}`)
  }
}
