import {Injectable} from '@angular/core';
import {User} from "../model/user";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient) {
  }

  login(user: User) {
    console.log(`login with email: ${user}`);

    let encodedAuth = btoa(`${user.email}:${user.password}`);
    let headers = new HttpHeaders()
      .set("Authorization", `Basic ${encodedAuth}`)
      .set("Content-Type", "application/json")
    ;

    console.log("headers: " + headers);

    this.http.get(`http://localhost:17081/auth/user`
      , {headers: headers}
    ).subscribe(data => {
      console.log(`got: ${data}`)
    });
  }
}
