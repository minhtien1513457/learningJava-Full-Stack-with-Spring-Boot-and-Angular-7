import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { AuthenticationService } from '../service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;
  public errorLogin: boolean = false;
  constructor(
    private formBuilder: FormBuilder,
    private authenticationService: AuthenticationService,
    private router: Router
  ) { }

  ngOnInit() {
    this.formLogin = this.formBuilder.group({
      username: [""],
      password: [""]
    })

    this.formLogin.get("username").patchValue("tienpm")
  }

  onSubmit() {
    if (this.authenticationService.authenticate(this.formLogin.value.username, this.formLogin.value.password)) {
      this.errorLogin = false;
      this.router.navigate(["/welcome"]);
    } else {
      this.errorLogin = true;
    }  
  }

}
