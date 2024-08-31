import { Component } from '@angular/core';
import {CardComponent} from "../../components/card/card.component";
import {GameType} from "./types/GameType";

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  imports: [
    CardComponent
  ],
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  public games: Array<GameType>;

  constructor() {
    this.games = Array(
      {
        cardGame: {
          gameCover: 'bt-1.jpg',
          gameLabel: 'DIGITAL'
        },
        cardPricing: {
          gamePrice: 'R$ 129,99',
          gameType: 'DIGITAL | PS4',
        }
      },
      {
        cardGame: {
          gameCover: 'bt-4.jpg',
          gameLabel: 'EXCLUSIVE'
        },
        cardPricing: {
          gamePrice: 'R$ 269,99',
          gameType: 'DISC | PS5',
        }
      },
      {
        cardGame: {
          gameCover: 'ac-cover.jpg',
          gameLabel: 'BEST OF YEAR'
        },
        cardPricing: {
          gamePrice: 'R$ 369,99',
          gameType: 'DIGITAL | PS5',
        }
      },
      {
        cardGame: {
          gameCover: 'bt-hardline.jpg',
          gameLabel: 'NEW'
        },
        cardPricing: {
          gamePrice: 'R$ 369,99',
          gameType: 'DIGITAL | PS3 PS4 PS5',
        }
      }
    );
  }

}
