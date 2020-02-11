import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public formLogin: FormGroup;

  constructor(
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.formLogin = this.formBuilder.group({
      username: [""],
      password: [""]
    })

    this.formLogin.get("username").patchValue("tienpm1")
  }

  onSubmit() {
    console.log(this.formLogin.value.username)
  }

}
