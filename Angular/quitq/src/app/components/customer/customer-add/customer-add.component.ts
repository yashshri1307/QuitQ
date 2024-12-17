import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { customer } from 'src/app/models/Customer';
import { CustomerService } from 'src/app/services/customer.service';
@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent {

  addform!:FormGroup;
  submitted=false;
  
  customer:customer[]=[];
  errorMessage!:string;

  showPasswordBox: boolean = false;


  rules = {
    uppercase: false,
    lowercase: false,
    specialChar: false,
    minLength: false,
  };

constructor(private service:CustomerService,private formBuilder:FormBuilder,private router:Router){}

ngOnInit(){
  this.addform=this.formBuilder.group({
    name:['',[Validators.required, Validators.pattern(/^[a-zA-Z ]+$/)]],
    email:['',[Validators.required, Validators.email]],
    password:['',[Validators.required, Validators.minLength(8)]],
    address:['',Validators.required],
    mobileNumber:['',[Validators.required,Validators.pattern(/^\d{10}$/)]]
  });

}


onPasswordInput(password: string): void {
  this.showPasswordBox = password.length > 0; 
  this.rules.uppercase = /[A-Z]/.test(password);
  this.rules.lowercase = /[a-z]/.test(password);
  this.rules.specialChar = /[\d\W]/.test(password);
  this.rules.minLength = password.length >= 8;
}

onPasswordBlur(password: string): void {
  if (password.length === 0) {
    this.showPasswordBox = false; 
  }
}
get f(){
  return this.addform.controls;
}

add(){
  if(this.addform.valid)
  {
    this.service.addCustomer(this.addform.value).subscribe(
      (response)=>{
        alert('Customer added successfully!');
         this.addform.reset();
          this.router.navigate(['/customer-login']);
      },
       (error: HttpErrorResponse) => {
        if (error.status === 409) {
          // Display backend error message
          this.errorMessage = error.error; 
        } else {
          // Default unexpected error
          this.errorMessage = 'An unexpected error occurred';
        }
      }
  );
  } else {
    alert('Form is invalid! Please fill all fields correctly.');
  }

  }
}

