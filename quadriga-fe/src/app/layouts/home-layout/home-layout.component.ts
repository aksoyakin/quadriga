import { Component } from '@angular/core';
import { NavbarComponent } from '../../components/home-page/navbar/navbar.component';
import { HomeComponent } from '../../components/home-page/home/home.component';
import { RideComponent } from '../../components/home-page/ride/ride.component';
import { ServicesComponent } from '../../components/home-page/services/services.component';
import { AboutComponent } from '../../components/home-page/about/about.component';
import { ReviewsComponent } from '../../components/home-page/reviews/reviews.component';
import { NewsletterComponent } from '../../components/home-page/newsletter/newsletter.component';
import { CopyrightComponent } from '../../components/home-page/copyright/copyright.component';

@Component({
  selector: 'app-home-layout',
  standalone: true,
  imports: [
    NavbarComponent,
    HomeComponent,
    RideComponent,
    ServicesComponent,
    AboutComponent,
    ReviewsComponent,
    NewsletterComponent,
    CopyrightComponent
  ],
  templateUrl: './home-layout.component.html',
  styleUrl: './home-layout.component.scss'
})
export class HomeLayoutComponent {

}
