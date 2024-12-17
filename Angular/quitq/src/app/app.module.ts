import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { SupplierLoginComponent } from './components/supplier/supplier-login/supplier-login.component';
import { SupplierDashboardComponent } from './components/supplier/supplier-dashboard/supplier-dashboard.component';
import { SupplierProfileComponent } from './components/supplier/supplier-profile/supplier-profile.component';
import { CustomerProfileComponent } from './components/customer/customer-profile/customer-profile.component';
import { ProductDetailsComponent } from './components/product/product-details/product-details.component';
import { ProductAddComponent } from './components/product/product-add/product-add.component';


import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './components/home/home.component';
import { CustomerAddComponent } from './components/customer/customer-add/customer-add.component';
import { SupplierAddComponent } from './components/supplier/supplier-add/supplier-add.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { SecurityComponent } from './components/security/security.component';
import { ProductUpdateComponent } from './components/product/product-update/product-update.component';
import { ProductDeleteComponent } from './components/product/product-delete/product-delete.component';
import { CartComponent } from './components/cart/cart/cart.component';
import { CustomerOrderComponent } from './components/customer/customer-order/customer-order.component';
import { SupplierOrderComponent } from './components/supplier/supplier-order/supplier-order.component';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminProfileComponent } from './components/admin/admin-profile/admin-profile.component';
import { AddInventoryComponent } from './components/inventory/add-inventory/add-inventory.component';
import { DeleteInventoryComponent } from './components/inventory/delete-inventory/delete-inventory.component';
import { DisplayInventoryComponent } from './components/inventory/display-inventory/display-inventory.component';
import { InventoryDashboardComponent } from './components/inventory/inventory-dashboard/inventory-dashboard.component';
import { UpdateInventoryComponent } from './components/inventory/update-inventory/update-inventory.component';
import { AddOrdersComponent } from './components/orders/add-orders/add-orders.component';
import { DeleteOrdersComponent } from './components/orders/delete-orders/delete-orders.component';
import { DisplayOrdersComponent } from './components/orders/display-orders/display-orders.component';
import { OrdersDashboardComponent } from './components/orders/orders-dashboard/orders-dashboard.component';
import { UpdateOrdersComponent } from './components/orders/update-orders/update-orders.component';
import { AddProductCategoryComponent } from './components/product-category/add-product-category/add-product-category.component';
import { DeleteProductCategoryComponent } from './components/product-category/delete-product-category/delete-product-category.component';
import { DisplayProductCategoryComponent } from './components/product-category/display-product-category/display-product-category.component';
import { ProductCategoryDashboardComponent } from './components/product-category/product-category-dashboard/product-category-dashboard.component';
import { UpdateProductCategoryComponent } from './components/product-category/update-product-category/update-product-category.component';
import { AddAdminComponent } from './components/admin/add-admin/add-admin.component';
import { AdminDisplayallComponent } from './components/admin/admin-displayall/admin-displayall.component';
import { PaymentComponent } from './components/payment/payment/payment.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerLoginComponent,
    SupplierLoginComponent,
    SupplierDashboardComponent,
    SupplierProfileComponent,
    CustomerProfileComponent,
    ProductDetailsComponent,
    ProductAddComponent,
    HomeComponent,
    CustomerAddComponent,
    SupplierAddComponent,
    NavbarComponent,
    SecurityComponent,
    ProductUpdateComponent,
    ProductDeleteComponent,
    CartComponent,
    CustomerOrderComponent,
    SupplierOrderComponent,
    AdminDashboardComponent,
    AdminLoginComponent,
    AdminProfileComponent,
    AddInventoryComponent,
    DeleteInventoryComponent,
    DisplayInventoryComponent,
    InventoryDashboardComponent,
    UpdateInventoryComponent,
    AddOrdersComponent,
    DeleteOrdersComponent,
    DisplayOrdersComponent,
    OrdersDashboardComponent,
    UpdateOrdersComponent,
    AddProductCategoryComponent,
    DeleteProductCategoryComponent,
    DisplayProductCategoryComponent,
    ProductCategoryDashboardComponent,
    UpdateProductCategoryComponent,
    AddAdminComponent,
    AdminDisplayallComponent,
    PaymentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
