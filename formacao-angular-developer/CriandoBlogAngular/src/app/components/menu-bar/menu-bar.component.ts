import { Component } from '@angular/core';

@Component({
  selector: 'app-menu-bar',
  standalone: true,
  templateUrl: './menu-bar.component.html',
  styleUrl: './menu-bar.component.css',
})
export class MenuBarComponent {

  public linkedin: string;
  public github: string;
  public instagram: string;

  constructor() {
    this.linkedin = 'https://www.linkedin.com/in/danielsilvamarcelino/';
    this.github = 'https://github.com/daniel-analyst';
    this.instagram = 'https://www.instagram.com/programmerhacker/';
  }

}
