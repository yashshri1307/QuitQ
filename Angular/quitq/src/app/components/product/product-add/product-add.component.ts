import { HttpErrorResponse } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { product } from 'src/app/models/Product';
import { supplier } from 'src/app/models/Supplier';
import { AuthService } from 'src/app/services/auth.service';
import { CustomerService } from 'src/app/services/customer.service';
import { ProductService } from 'src/app/services/product.service';
import { SupplierService } from 'src/app/services/supplier.service';
@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent {

  addform!:FormGroup;
    submitted=false;
    
    product!:product;
    errorMessage!:string;

    supplier!:supplier;

    constructor(private supplierservice:SupplierService,private service:ProductService,private formBuilder:FormBuilder,private router:Router,private authservice:AuthService){}

    ngOnInit(){
      this.addform=this.formBuilder.group({
        name:['',Validators.required],
        description:['',Validators.required],
        price:['',Validators.required],
        stock:['',Validators.required],
        imageUrl:['',Validators.required]
      });
    }

    get f(){
      return this.addform.controls;
    }
   
add() {
  if (this.addform.valid) {
    this.product = this.addform.value;

    this.supplierservice.getSupplierByEmail(this.authservice.getLoggedInEmail()).subscribe(
      (response: supplier) => {
        this.supplier = response; 
        console.log('Supplier details:', this.supplier);

        
        this.product.supplierId = this.supplier.supplierId;

       
        console.log("Updated product with supplierId:", this.product);

        // Add the product
        this.service.addProduct(this.product).subscribe(
          (response) => {
            alert('Product added successfully!');
            this.addform.reset();
            this.router.navigate(['/product-details']);
          },
          (error: HttpErrorResponse) => {
            if (error.status === 409) {
              this.errorMessage = error.error; 
            } else {
              this.errorMessage = 'An unexpected error occurred';
            }
          }
        );
      },
      (error) => {
        console.error('Failed to fetch supplier:', error);
      }
    );
  } else {
    alert('Form is invalid! Please fill all fields correctly.');
  }
}
}
