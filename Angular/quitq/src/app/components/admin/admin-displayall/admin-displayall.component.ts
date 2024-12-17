import { Component } from '@angular/core';
import { Admin } from 'src/app/models/Admin';
import { AdminService } from 'src/app/services/admin.service';

@Component({
  selector: 'app-admin-displayall',
  templateUrl: './admin-displayall.component.html',
  styleUrls: ['./admin-displayall.component.css']
})
export class AdminDisplayallComponent {

  admin:any[]=[];

  ngOnInit() {
    this.getadmins();
  }

  constructor(private adminService:AdminService){}

  getadmins(){
    this.adminService.getAll().subscribe(
      (response) => {
        
        this.admin = response.map((admin: any) => ({
          ...admin,
        }));
      },
      (error) => {
        console.error('Error fetching Admins:', error);
      }
    )
  }

  deleteAdmin(adminId: number) {
    this.adminService.deleteAdmin(adminId).subscribe(
      () => {
        console.log(`Admin with ID ${adminId} deleted successfully.`);
        // Refresh product list after deletion
        this.admin = this.admin.filter(admin => admin.adminId !== adminId);
        this.getadmins();
      },
      (error: any) => {
        console.error(`Error deleting product with ID ${adminId}:`, error);
      }
    );
  }

  

}
