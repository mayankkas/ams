import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';

import { AlertService, UserService } from '../_services';

@Component({templateUrl: 'forgot.component.html'})
export class ForgotComponent implements OnInit {
    forgotForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    ngOnInit() {
        this.forgotForm = this.formBuilder.group({
            username: ['', [Validators.required,Validators.pattern('[0-9]{7}')]],
            email: ['', [Validators.required,Validators.email]]
        });
    }

    // convenience getter for easy access to form fields
    get f() { return this.forgotForm.controls; }

    onSubmit() {
        this.submitted = true;

        // stop here if form is invalid
        if (this.forgotForm.invalid) {
            return;
        }

        this.loading = true;
        this.userService.register(this.forgotForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Password sent to your Email Id', true);
                    this.router.navigate(['/login']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
