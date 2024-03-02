import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const ORDERS_URL = 'http://localhost:8008/api';

@Injectable({
  providedIn: 'root',
})
export class OrdersService {
  constructor(private http: HttpClient) {}

  getAllOrders() {
    return this.http.get<Array<any>>(ORDERS_URL + '/orders');
  }
  getOrderDetails(orderId: string) {
    return this.http.get<any>(ORDERS_URL + `/orders/${orderId}`);
  }
}
