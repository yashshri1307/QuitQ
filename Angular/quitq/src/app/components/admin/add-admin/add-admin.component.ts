import { Component } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { Admin } from 'src/app/models/Admin';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-admin',
  templateUrl: './add-admin.component.html',
  styleUrls: ['./add-admin.component.css']
})
export class AddAdminComponent {
  addAdminForm: FormGroup;
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private adminService: AdminService, private fb: FormBuilder) {
    this.addAdminForm = this.fb.group({
      name: ['', [Validators.required, Validators.pattern('^[A-Z].*')]],
      email: ['', [Validators.required, Validators.email]],
      password: ['', [Validators.required, Validators.minLength(6)]],
      role: ['', [Validators.required]]
    });
  }

  addAdmin(): void {
    if (this.addAdminForm.valid) {
      const admin: Admin = this.addAdminForm.value;

      this.adminService.addAdmin(admin).subscribe({
        next: (response) => {
          this.successMessage = 'Admin added successfully!';
          this.errorMessage = '';
          this.addAdminForm.reset(); // Clear the form after successful submission
        },
        error: (err) => {
          this.errorMessage = 'Failed to add admin. Please try again.';
          this.successMessage = '';
          console.error(err);
        }
      });
    } else {
      this.errorMessage = 'Please fill in all required fields correctly.';
    }
  }
}
