import {Component, OnInit} from '@angular/core';
import {AuthService} from '../service/auth.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  form: any = {};
  isSuccessful = false;
  isSignUpFailed = false;
  errorMessage = '';

  constructor(private authService: AuthService, private router: Router) {
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.authService.register(this.form).subscribe(
      data => {
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        setTimeout(() => {
          this.router.navigate(['/login']).then(() => window.location.reload())
        }, 2200)
      },
      err => {
        this.errorMessage = err.error.payload.message
        this.isSignUpFailed = true;
      }
    );
  }

}
