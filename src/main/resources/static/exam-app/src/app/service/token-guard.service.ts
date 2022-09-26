import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router} from '@angular/router';
import {AuthService} from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TokenGuardService implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {
  }

  canActivate(route: ActivatedRouteSnapshot): boolean {
    const token = sessionStorage.getItem('auth-user')
    const data = JSON.parse(token);
    if (data.token !== null) {
      return true
    } else {
      this.router.navigate(['/login'])
    }
  }
}
