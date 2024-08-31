import { Component, Input } from '@angular/core';
import {RouterLink} from "@angular/router";
import {BigCardType} from "./types/BigCardType";

@Component({
  selector: 'app-big-card',
  standalone: true,
  templateUrl: './big-card.component.html',
  imports: [
    RouterLink
  ],
  styleUrls: ['./big-card.component.css']
})
export class BigCardComponent {

  @Input()
  public data: BigCardType;

  constructor() {
    this.data = {} as BigCardType;
  }

}
