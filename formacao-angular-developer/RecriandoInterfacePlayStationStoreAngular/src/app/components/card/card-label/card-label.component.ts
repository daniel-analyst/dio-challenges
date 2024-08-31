import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-card-label',
  standalone: true,
  templateUrl: './card-label.component.html',
  styleUrls: ['./card-label.component.css']
})
export class CardLabelComponent{

	@Input()
	public gameLabel: string;

  constructor() {
    this.gameLabel = '';
  }

}
