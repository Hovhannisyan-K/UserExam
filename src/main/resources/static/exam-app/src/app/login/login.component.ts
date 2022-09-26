import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { TokenStorageService } from '../service/token-storage.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService, private router: Router) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(): void {
    this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);
        this.tokenStorage.saveUser(data);
        localStorage.setItem('username',this.form.username)
        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.router.navigate(['/user'])
      },
      () => {
        this.errorMessage = 'wrong username or password';
        this.isLoginFailed = true;
      }
    );
  }

}
