import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const PRODUCTS_SERVICE = 'http://localhost:8007/api';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  constructor(private http: HttpClient) {}

  public productsList() {
    return this.http.get(PRODUCTS_SERVICE + '/products');
  }
  public getProduct(id: number) {
    return this.http.get(PRODUCTS_SERVICE + '/products/' + id);
  }
}
