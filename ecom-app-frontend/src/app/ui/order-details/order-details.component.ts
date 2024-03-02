import { Component } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { OrdersService } from 'src/app/http/orders.service';

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.scss'],
})
export class OrderDetailsComponent {
  orderId!: string;
  orderDetails: any;
  constructor(
    private route: ActivatedRoute,
    private orderService: OrdersService
  ) {
    this.orderId = this.route.snapshot.params['orderId'];
  }
  ngOnInit() {
    this.orderService.getOrderDetails(this.orderId).subscribe({
      next: (order: any) => {
        this.orderDetails = order;
      },
    });
  }

  getTotal(orderDetails: any) {
    let total: number = 0;
    for (let pi of orderDetails.productItems) {
      total = total + pi.price * pi.quantity;
    }
    return total;
  }
}
