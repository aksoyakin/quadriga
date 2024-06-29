import { CommonModule } from '@angular/common';
import { Component, HostListener, Input, TemplateRef } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ButtonComponent } from '../button/button.component';

@Component({
  selector: 'app-navbar2',
  standalone: true,
  imports: [
    CommonModule,
    RouterModule,
    ButtonComponent
    
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})

export class NavbarComponent {

  isLoggedIn = false;
  isScrolled = false;

  @HostListener('window:scroll', [])
  onWindowScroll() {
    this.isScrolled = window.scrollY > 50;
  }

  login() {
    // Implement your login logic here
    console.log("Login clicked");
  }

  signup() {
    // Implement your signup logic here
    console.log("Sign Up clicked");
  }

  logout() {
    // Implement your logout logic here
    this.isLoggedIn = false;
  }

}
