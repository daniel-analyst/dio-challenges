import { Component, Input } from '@angular/core';
import {CardPricingType} from "./types/CardPricingType";

@Component({
  selector: 'app-card-pricing',
  standalone: true,
  templateUrl: './card-pricing.component.html',
  styleUrls: ['./card-pricing.component.css']
})
export class CardPricingComponent {

	@Input()
	public data: CardPricingType;

  constructor() {
    this.data = {
      gamePrice: 'R$ 399,90',
      gameType: 'Digital PS4'
    };
  }

}
