import { Component } from '@angular/core';
import {BigCardComponent} from "../../components/big-card/big-card.component";
import {MenuTitleComponent} from "../../components/menu-title/menu-title.component";
import {SmallCardComponent} from "../../components/small-card/small-card.component";
import {SmallCardType} from "../../components/small-card/types/SmallCardType";
import {BigCardType} from "../../components/big-card/types/BigCardType";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  standalone: true,
  imports: [
    BigCardComponent,
    MenuTitleComponent,
    SmallCardComponent
  ],
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  public dataSmallCard: Array<SmallCardType>;
  public dataBigCard: BigCardType;

  constructor() {
    this.dataSmallCard = Array(
      {
        id: 2,
        cardTitle: 'Nova Série anunciada no Disney +',
        photoCover: 'https://disneyplusbrasil.com.br/wp-content/uploads/2021/07/Series-Marvel-Disney-Plus-1024x576.jpg'
      },
      {
        id: 3,
        cardTitle: 'Novo filme do pantera negra lançado em breve',
        photoCover: 'https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/35720ACD323F927C3A83D809D0F460BD3651740DA519BCC184B6F042057EA14D/scale?width=1200&aspectRatio=1.78&format=jpeg'
      },
      {
        id: 4,
        cardTitle: 'Novo filme dos X-men está em pós produção, afirma diretor',
        photoCover: 'https://midias.correiobraziliense.com.br/_midias/jpg/2022/07/22/675x450/1_xmen-26096415.jpeg?20220722171339?20220722171339'
      }
    );

    this.dataBigCard = {
      id: 1,
      cardDescription: 'Marvel Anuncia novo homem de ferro',
      cardTitle: 'NOVO HOMEM DE FERRO EM 3D',
      photoCover: 'https://prod-ripcut-delivery.disney-plus.net/v1/variant/disney/7F51FA9F6CBD9F0C9B1394B1CC0A6A842D07091318674E234CD33CBF7C28CDC3/scale?width=1200&aspectRatio=1.78&format=jpeg'
    };
  }

}
