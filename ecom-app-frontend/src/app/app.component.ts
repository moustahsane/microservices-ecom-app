import { Component } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'ecom-app-frontend';
  profile!: KeycloakProfile;
  constructor(private kcs: KeycloakService) {}
  ngOnInit() {
    this.kcs.loadUserProfile().then((prf) => {
      this.profile = prf;
      console.log(prf);

    });
  }
  async handleLogin() {
    await this.kcs.login({ redirectUri: location.origin });
  }
  async handleLogout() {
    await this.kcs.logout(location.origin);
  }
}
