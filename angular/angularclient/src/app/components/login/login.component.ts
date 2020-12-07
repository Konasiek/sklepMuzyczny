import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Role} from "../../roles/Role";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

    isInvalid: boolean;
    isLogout: boolean;
    submitted = false;
    model: any = {
        username: '',
        password: '',
        remembered: false
    };

    returnUrl: string = '/';

    constructor(private userService: UserService,
                private router: Router,
                private route: ActivatedRoute) {
    }

    ngOnInit() {
        let params = this.route.snapshot.queryParamMap;
        this.isLogout = params.has('logout');
        this.returnUrl = <string>params.get('returnUrl');
    }

    onSubmit() {
        console.log('kilknieto submmit')
        this.submitted = true;
        console.log('przekazuje model: ' + this.model.username + ' ' + this.model.password);
        this.userService.login(this.model).subscribe(
            user => {
                if (user) {
                    if (user.role != Role.USER) {

                        this.returnUrl = '/cart';
                    }

                    this.router.navigateByUrl(this.returnUrl);
                } else {
                    console.log('role sa pojebane')
                    console.log(Role.USER);
                    console.log(user.role);

                    console.log(user);
                    this.isLogout = false;
                    this.isInvalid = true;
                }
            }
        );
    }

    fillLoginFields(u: string, p: string) {
        this.model.username = u;
        this.model.password = p;
        this.onSubmit();
    }
}
