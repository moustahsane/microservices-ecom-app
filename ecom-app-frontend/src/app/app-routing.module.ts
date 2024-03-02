import { ProductsComponent } from './ui/products/products.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CosutomersComponent } from './ui/cosutomers/cosutomers.component';
import { AuthGuardService } from './auth/auth-guard.service';
import { OrdersComponent } from './ui/orders/orders.component';
import { OrderDetailsComponent } from './ui/order-details/order-details.component';

const routes: Routes = [
  {
    path: 'products',
    component: ProductsComponent,
    canActivate: [AuthGuardService],
    data: { roles: [] },
  },
  {
    path: 'customers',
    component: CosutomersComponent,
  },
  {
    path: 'orders',
    component: OrdersComponent,
  },
  {
    path: 'order-details/:orderId',
    component: OrderDetailsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
