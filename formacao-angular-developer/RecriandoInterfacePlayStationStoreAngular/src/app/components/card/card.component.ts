import { Component, Input } from '@angular/core';
import {CardLabelComponent} from "./card-label/card-label.component";
import {CardPricingComponent} from "./card-pricing/card-pricing.component";
import {CardPricingType} from "./card-pricing/types/CardPricingType";
import {CardGameType} from "./types/CardGameType";

@Component({
  selector: 'app-card',
  standalone: true,
  templateUrl: './card.component.html',
  imports: [
    CardLabelComponent,
    CardPricingComponent
  ],
  styleUrls: ['./card.component.css']
})
export class CardComponent {

	@Input()
	public dataGame: CardGameType

	@Input()
	public dataCardPricing: CardPricingType;

  constructor() {
    this.dataCardPricing = {
      gameType: 'XPTO | PS4',
      gamePrice: 'R$ 399,90'
    };
    this.dataGame = {} as CardGameType;
  }

}
