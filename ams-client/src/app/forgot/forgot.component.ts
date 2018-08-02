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
    otpRadioValue: string='No';

    constructor(
        private formBuilder: FormBuilder,
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) { }

    ngOnInit() {
        this.forgotForm = this.formBuilder.group({
            username: ['', [Validators.required,Validators.pattern('[0-9]{7}')]],
            email: ['', [Validators.required,Validators.email]],
            otpradio: ['', Validators.required],
            otpValue: ['', Validators.pattern('[0-9]{6}')],
            newpassword: ['', Validators.pattern('^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$')],
            confirmpassword: ['', Validators.pattern('^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$')]
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
        this.userService.update(this.forgotForm.value)
            .pipe(first())
            .subscribe(
                data => {
                    this.alertService.success('Password sent to your Email Id', true);
                    // this.router.navigate(['/forgot']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }

    //event handler for the radio button's change event
    otpradioChangeHandler(event: any) {
    //update the ui
    this.otpRadioValue = event.target.value;
  }
}
