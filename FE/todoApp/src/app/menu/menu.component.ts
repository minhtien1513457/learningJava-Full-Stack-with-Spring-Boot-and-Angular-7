import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  public isLogin: boolean;
  constructor(
    private authenticationService: AuthenticationService
  ) { }

  ngOnInit() {
    if (this.authenticationService.isAuthenticated()) {
      this.isLogin = true;
    } else {
      this.isLogin = false;
    }
  }

}
