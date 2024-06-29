import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NavbarComponent } from './shared/components/navbar/navbar.component';
import { FooterComponent } from './shared/components/footer/footer.component';
import { CarCategoryMenuComponent } from './shared/components/car-category-menu/car-category-menu.component';
import { CarsCardComponent } from './shared/components/cars-card/cars-card.component';
import { HomeLayoutComponent } from './layouts/home-layout/home-layout.component';
import { PanelComponent } from './components/admin-page/panel/panel.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    HomeLayoutComponent,
    PanelComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Quadriga'
}
