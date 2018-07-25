import { Component, OnInit } from '@angular/core';
import { first } from 'rxjs/operators';

import { User } from '../_models';
import { UserService, AlertService } from '../_services';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { Router } from '../../../node_modules/@angular/router';

@Component({templateUrl: 'home.component.html'})
export class HomeComponent implements OnInit {
    currentUser: User;
    // users: User[] = [];
    amsForm: FormGroup;
    loading = false;
    submitted = false;

    constructor(private formBuilder: FormBuilder,
        private router: Router,
        private userService: UserService,
        private alertService: AlertService) {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }

    ngOnInit() {
        // this.loadAllUsers();
        this.amsForm = this.formBuilder.group({
            billdays: ['', [Validators.required,Validators.pattern('[0-9]*')]]
        });
    }
    get f() { return this.amsForm.controls; }

    // deleteUser(id: number) {
    //     this.userService.delete(id).pipe(first()).subscribe(() => { 
    //         this.loadAllUsers() 
    //     });
    // }

    // private loadAllUsers() {
    //     this.userService.getAll().pipe(first()).subscribe(users => { 
    //         this.users = users; 
    //     });
    // }
}