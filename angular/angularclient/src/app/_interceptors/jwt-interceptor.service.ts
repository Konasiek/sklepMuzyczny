import {Injectable} from '@angular/core';
import {UserService} from "../services/user.service";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class JwtInterceptor implements HttpInterceptor {


    constructor(private userService: UserService) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        console.log('am in intercepter');
        const currentUser = this.userService.currentUserValue;
        console.log('currentUser in intercepter: ' + currentUser);
        if (currentUser && currentUser.token) {
            request = request.clone({
                setHeaders: {

                    Authorization: `${currentUser.type} ${currentUser.token}`,
                    'Content-Type': 'application/json',
                    'Access-Control-Allow-Origin': 'http://localhost:8080',
                    'Access-Control-Allow-Headers': 'Content-Type, X-Requested-With',
                }
            });
        }
        return next.handle(request);
    }
}

// app.use(function(req, res, next) {
//     res.header("Access-Control-Allow-Origin", "YOUR-DOMAIN.TLD"); // update to match the domain you will make the request from
//     res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//     next();
// });
