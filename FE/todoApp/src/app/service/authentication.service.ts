import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username: string, password: string) {
    if ( username == "tienpm" && password == "123") {
      sessionStorage.setItem("username",username);
      return true;
    } else {
      return false;
    }
  }

  isAuthenticated() : boolean {
    let check = sessionStorage.getItem("username");
    if (check == null) {
      return false;
    } else {
      return true;
    }
  }

  logout() {
    sessionStorage.removeItem("username");
  }
}
