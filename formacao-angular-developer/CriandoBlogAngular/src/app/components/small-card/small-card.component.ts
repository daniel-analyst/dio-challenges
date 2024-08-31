import { Component, Input } from '@angular/core';
import {SmallCardType} from "./types/SmallCardType";
import {NgOptimizedImage} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-small-card',
  standalone: true,
  templateUrl: './small-card.component.html',
  imports: [
    NgOptimizedImage,
    RouterLink
  ],
  styleUrls: ['./small-card.component.css']
})
export class SmallCardComponent {

  @Input()
  public data: SmallCardType;

  constructor() {
    this.data = {} as SmallCardType;
  }

}
