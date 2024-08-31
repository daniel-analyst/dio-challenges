import { Component } from '@angular/core';
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-menu-bar',
  standalone: true,
  templateUrl: './menu-bar.component.html',
  imports: [
    NgOptimizedImage
  ],
  styleUrls: ['./menu-bar.component.css']
})
export class MenuBarComponent{
}
