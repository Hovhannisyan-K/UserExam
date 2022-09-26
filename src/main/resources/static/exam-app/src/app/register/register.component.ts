import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import {Router} from "@angular/router";
import {MatSnackBar} from "@angular/material/snack-bar";

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

  constructor(private authService: AuthService, private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.authService.register(this.form).subscribe(
      data => {
        console.log('reg response ', data)
        this.isSuccessful = true;
        this.isSignUpFailed = false;
        // this.snackBar.open(`Successfully registered as ${data.accountName}`)
        setTimeout(()=>{
          this.router.navigate(['/login']).then(() => window.location.reload())
        }, 2000)
      },
      err => {
        this.errorMessage = err.error.payload.message
        this.isSignUpFailed = true;
      }
    );
  }

}
