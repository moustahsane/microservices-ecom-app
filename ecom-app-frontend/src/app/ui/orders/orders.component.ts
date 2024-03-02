import { Component } from '@angular/core';
import { OrdersService } from 'src/app/http/orders.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss'],
})
export class OrdersComponent {

  orders$ = this.ordersService.getAllOrders();

  constructor(private ordersService: OrdersService) {}
}
