import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
 
@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor{

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let user = "tienpm";
    let pass = "123";
    let basicAuth = 'Basic ' + btoa(user+ ':' +pass);

    req = req.clone({
      setHeaders: {
        Authorization : basicAuth
      }
    }) 

    return next.handle(req)
  }
}
