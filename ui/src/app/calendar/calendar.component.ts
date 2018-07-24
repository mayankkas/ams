import { Component, Injectable, OnInit } from '@angular/core';
import { NgbDateStruct, NgbDateAdapter, NgbDateNativeAdapter } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, FormBuilder, Validators } from '../../../node_modules/@angular/forms';
import { Router } from '../../../node_modules/@angular/router';
import { UserService, AlertService } from '../_services';

// const now = new Date();

@Component({
  selector: 'ams-calendar',
  templateUrl: './calendar.component.html',
  // NOTE: For this example we are only providing current component, but probably
  // NOTE: you will want to provide your main App Module
  providers: [{ provide: NgbDateAdapter, useClass: NgbDateNativeAdapter }],
  styles: [`
    .custom-day {
      text-align: center;
      padding: 0.185rem 0.25rem;
      border-radius: 0.25rem;
      display: inline-block;
      width: 2rem;
    }
    .custom-day:hover, .custom-day.focused {
      background-color: #e6e6e6;
    }
    .weekend {
      background-color: #f0ad4e;
      border-radius: 1rem;
      color: white;
    }
    .hidden {
      display: none;
    }
  `]

})
export class CalendarComponent implements OnInit {
  // model: NgbDateStruct;
  date: { year: number, month: number };
  amsForm: FormGroup;
  calModel: Date = new Date();
  // model2: Date;
  loading = false;
  submitted = false;
  billdays: number = this.calModel.getMonth();
  overtimeHours: number = 0;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
    private alertService: AlertService) {
  }

  get today() {
    return new Date();
  }
  selectToday() {
    this.calModel = new Date();
  }

  ngOnInit() {
    // this.loadAllUsers();
    this.amsForm = this.formBuilder.group({
      // billdays: ['', [Validators.required,Validators.pattern('[0-9]*')]],
      leaveradio: ['', Validators.required],
      overtimeradio: ['', Validators.required],
      leavedays: ['', Validators.pattern('[0-9]*')],
      overtime: ['', Validators.pattern('[0-9]*')]
    });
  }
  datechange(newValue: Date) {
    console.log("changed Date:" + newValue)
    this.billdays = (this.date.month + 20);
  }
  overtimechange(newValue: number) {
    this.overtimeHours = Number(newValue);
  }
  get f() { return this.amsForm.controls; }
  onSubmit() {
    // console.log("Varify your clarity hours before submitting it."
    // +"\nLeave days:"+(this.amsForm.controls.leavedays.value)
    // +"\nOvertime hours:"+this.amsForm.controls.overtimeHours.value
    // +"\nTotal clarity hours:"+(this.amsForm.controls.overtimeHours.value+this.amsForm.controls.leavedays.value));

    if (confirm("Varify your clarity hours before submitting it."
      +"\nClarity Month: " + this.calModel.getMonth()+"."+this.calModel.getFullYear()
      + "\nLeave days: " + (this.amsForm.controls.leavedays.value)
      + "\nOvertime hours: " + this.amsForm.controls.overtime.value
      + "\nTotal clarity hours: " + (this.amsForm.controls.overtime.value + (this.billdays - this.amsForm.controls.leavedays.value) * 8)
    )) {
      console.log("Implement functionality here");
    }
  }
}