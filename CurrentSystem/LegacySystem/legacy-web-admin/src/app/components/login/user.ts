export class User {

  constructor(
    public email: string,
    public password: string,
    public rememberMe: boolean
  ) {  }

  toString() {
    return `email:${this.email} - password:${this.password} - rememberMe:${this.rememberMe}`;
  }
}
