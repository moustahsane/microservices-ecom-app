import { APP_INITIALIZER, NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './ui/products/products.component';
import { CosutomersComponent } from './ui/cosutomers/cosutomers.component';
import { initializeKeycloak } from 'src/config/keycloack.config';
import { KeycloakAngularModule, KeycloakService } from 'keycloak-angular';
import { OrdersComponent } from './ui/orders/orders.component';
import { OrderDetailsComponent } from './ui/order-details/order-details.component';

@NgModule({
  declarations: [AppComponent, ProductsComponent, CosutomersComponent, OrdersComponent, OrderDetailsComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    KeycloakAngularModule,
  ],
  providers: [
    {
      provide: APP_INITIALIZER,
      useFactory: initializeKeycloak,
      multi: true,
      deps: [KeycloakService],
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
