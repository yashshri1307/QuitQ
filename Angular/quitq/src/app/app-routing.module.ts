import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { SupplierDashboardComponent } from './components/supplier/supplier-dashboard/supplier-dashboard.component';
import { HomeComponent } from './components/home/home.component';
import { SupplierLoginComponent } from './components/supplier/supplier-login/supplier-login.component';
import { SupplierAddComponent } from './components/supplier/supplier-add/supplier-add.component';
import { CustomerAddComponent } from './components/customer/customer-add/customer-add.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { CustomerProfileComponent } from './components/customer/customer-profile/customer-profile.component';
import { SupplierProfileComponent } from './components/supplier/supplier-profile/supplier-profile.component';
import { ProductAddComponent } from './components/product/product-add/product-add.component';
import { ProductDetailsComponent } from './components/product/product-details/product-details.component';
import { ProductDeleteComponent } from './components/product/product-delete/product-delete.component';
import { ProductUpdateComponent } from './components/product/product-update/product-update.component';
import { CartComponent } from './components/cart/cart/cart.component';
import { CustomerOrderComponent } from './components/customer/customer-order/customer-order.component';
import { ProductCategoryDashboardComponent } from './components/product-category/product-category-dashboard/product-category-dashboard.component';
import { UpdateProductCategoryComponent } from './components/product-category/update-product-category/update-product-category.component';
import { DisplayProductCategoryComponent } from './components/product-category/display-product-category/display-product-category.component';
import { DeleteProductCategoryComponent } from './components/product-category/delete-product-category/delete-product-category.component';
import { AddProductCategoryComponent } from './components/product-category/add-product-category/add-product-category.component';
import { OrdersDashboardComponent } from './components/orders/orders-dashboard/orders-dashboard.component';
import { DisplayOrdersComponent } from './components/orders/display-orders/display-orders.component';
import { DeleteOrdersComponent } from './components/orders/delete-orders/delete-orders.component';
import { UpdateOrdersComponent } from './components/orders/update-orders/update-orders.component';
import { AddOrdersComponent } from './components/orders/add-orders/add-orders.component';
import { InventoryDashboardComponent } from './components/inventory/inventory-dashboard/inventory-dashboard.component';
import { DeleteInventoryComponent } from './components/inventory/delete-inventory/delete-inventory.component';
import { UpdateInventoryComponent } from './components/inventory/update-inventory/update-inventory.component';
import { DisplayInventoryComponent } from './components/inventory/display-inventory/display-inventory.component';
import { AddInventoryComponent } from './components/inventory/add-inventory/add-inventory.component';
import { AdminProfileComponent } from './components/admin/admin-profile/admin-profile.component';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';

const routes: Routes = [
  { path: 'home', component:HomeComponent},
  // Route for customer login with the navbar as the parent
  {
    path: 'customer-login', component:NavbarComponent,
    children: [ { path:'', component:CustomerLoginComponent  } ]
  },
  { path:  'supplier-login',component:NavbarComponent,
    children:[ {path:'',component:SupplierLoginComponent}]
  },
  { path:  'customeradd',component:NavbarComponent,
    children:[ {path:'',component:CustomerAddComponent}]
  },
  { path:  'supplieradd',component:NavbarComponent,
    children:[ {path:'',component:SupplierAddComponent}]
  },
  { path:  'customer-profile',component:NavbarComponent,
    children:[ {path:'',component:CustomerProfileComponent}]
  },
  { path:  'supplier-profile',component:NavbarComponent,
    children:[ {path:'',component:SupplierProfileComponent}]
  },
  { path:  'customer-order',component:NavbarComponent,
    children:[ {path:'',component:CustomerOrderComponent}]
  },
  { path:  'supplier-dashboard',component:NavbarComponent,
    children:[ {path:'',component:SupplierDashboardComponent}]
  },
  { path:  'product-add',component:NavbarComponent,
    children:[ {path:'',component:ProductAddComponent}]
  },
  { path:  'product-update',component:NavbarComponent,
    children:[ {path:'',component:ProductUpdateComponent}]
  },
  { path:  'product-details',component:NavbarComponent,
    children:[ {path:'',component:ProductDetailsComponent}]
  },
  { path:  'product-delete',component:NavbarComponent,
    children:[ {path:'',component:ProductDeleteComponent}]
  },
  { path:  'cart',component:NavbarComponent,
    children:[ {path:'',component:CartComponent}]
  },
  { path:  'admin-login',component:NavbarComponent,
    children:[ {path:'',component:AdminLoginComponent}]
  },

  { path:  'admin-dashboard',component:NavbarComponent,
    children:[ {path:'',component:AdminDashboardComponent}]
  },

  { path:  'admin-profile',component:NavbarComponent,
    children:[ {path:'',component:AdminProfileComponent}]
  },
  {
    path: 'add-inventory', component:NavbarComponent,
    children: [ { path:'', component:AddInventoryComponent  } ]
  },

  {
    path: 'display-inventory', component:NavbarComponent,
    children: [ { path:'', component:DisplayInventoryComponent  } ]
  },

  {
    path: 'update-inventory', component:NavbarComponent,
    children: [ { path:'', component:UpdateInventoryComponent  } ]
  },

  {
    path: 'delete-inventory', component:NavbarComponent,
    children: [ { path:'', component:DeleteInventoryComponent  } ]
  },

  { path: 'inventory-dashboard', component:InventoryDashboardComponent },


  {
    path: 'add-orders', component:NavbarComponent,
    children: [ { path:'', component:AddOrdersComponent  } ]
  },
  {
    path: 'update-orders', component:NavbarComponent,
    children: [ { path:'', component:UpdateOrdersComponent  } ]
  },
  {
    path: 'delete-orders', component:NavbarComponent,
    children: [ { path:'', component:DeleteOrdersComponent  } ]
  },
  {
    path: 'display-orders', component:NavbarComponent,
    children: [ { path:'', component:DisplayOrdersComponent  } ]
  },



  { path: 'orders-dashboard', component:OrdersDashboardComponent },








  {
    path: 'add-product-category', component:NavbarComponent,
    children: [ { path:'', component:AddProductCategoryComponent  } ]
  },


  {
    path: 'delete-product-category', component:NavbarComponent,
    children: [ { path:'', component:DeleteProductCategoryComponent  } ]
  },

  {
    path: 'display-product-category', component:NavbarComponent,
    children: [ { path:'', component:DisplayProductCategoryComponent  } ]
  },

  {
    path: 'update-product-category', component:NavbarComponent,
    children: [ { path:'', component:UpdateProductCategoryComponent  } ]
  },


  { path: 'product-category-dashboard', component:ProductCategoryDashboardComponent },
  


  { path: '', redirectTo: '/home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
