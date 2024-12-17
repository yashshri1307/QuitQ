import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { supplier } from 'src/app/models/Supplier';
import { SupplierService } from 'src/app/services/supplier.service';
@Component({
  selector: 'app-supplier-add',
  templateUrl: './supplier-add.component.html',
  styleUrls: ['./supplier-add.component.css']
})
export class SupplierAddComponent {

  addform!:FormGroup;
    submitted=false;
    
    supplier:supplier[]=[];
    errorMessage!:string;
  
    showPasswordBox: boolean = false;
  
  
    rules = {
      uppercase: false,
      lowercase: false,
      specialChar: false,
      minLength: false,
    };
  
  constructor(private service:SupplierService,private formBuilder:FormBuilder,private router:Router){}
  
  ngOnInit(){
    this.addform=this.formBuilder.group({
      name:['',[Validators.required, Validators.pattern(/^[a-zA-Z ]+$/)]],
      email:['',[Validators.required, Validators.email]],
      password:['',[Validators.required, Validators.minLength(8)]],
      address:['',Validators.required],
      mobileNumber:['',[Validators.required,Validators.pattern(/^\d{10}$/)]],
      companyName:['',Validators.required]
    });
  
  }
  
  
  onPasswordInput(password: string): void {
    this.showPasswordBox = password.length > 0; 
    this.rules.uppercase = /[A-Z]/.test(password);
    this.rules.lowercase = /[a-z]/.test(password);
    this.rules.specialChar = /[\d\W]/.test(password);
    this.rules.minLength = password.length >= 8;
  }
  
  // When focus is lost
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
      this.service.addSupplier(this.addform.value).subscribe(
        (response)=>{
          alert('Supplier added successfully!');
           this.addform.reset();
            this.router.navigate(['/supplier-login']);
        },
         (error: HttpErrorResponse) => {
          if (error.status === 409) {
            
            this.errorMessage = error.error; 
          } else {
            
            this.errorMessage = 'An unexpected error occurred';
          }
        }
    );
    } else {
      alert('Form is invalid! Please fill all fields correctly.');
    }
  
    }
}
