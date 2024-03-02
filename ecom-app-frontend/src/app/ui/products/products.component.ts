import { Component } from '@angular/core';
import { tap } from 'rxjs';
import { ProductsService } from 'src/app/http/products.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent {
  products: any[] = [];
  constructor(private productService: ProductsService) {}
  ngOnInit() {
    this.productService
      .productsList()
      .pipe(
        tap((res: any) => {
          this.products = res;
        })
      )
      .subscribe();
  }
}
