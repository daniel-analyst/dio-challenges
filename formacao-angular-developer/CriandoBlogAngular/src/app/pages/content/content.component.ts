import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, RouterLink} from '@angular/router';
import {dataFake} from '../../data/dataFake'
import {DataFakeType} from "../../types/DataFakeType";
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-content',
  standalone: true,
  templateUrl: './content.component.html',
  imports: [
    NgOptimizedImage,
    RouterLink
  ],
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  public photoCover: string;
  public contentTitle: string;
  public contentDescription: string;
  private id: number | null;

  constructor(private activatedRoute: ActivatedRoute) {
    this.photoCover = '';
    this.contentTitle = '';
    this.contentDescription = '';
    this.id = null;
  }

  public ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe( (value: ParamMap): number | null =>
     this.id = value.get('id') ? parseInt(<string>value.get('id')) : null
    )

    this.setValuesToComponent(this.id)
  }

  private setValuesToComponent(id: number | null): void {
    const result: DataFakeType = dataFake.filter((article: DataFakeType): boolean => article.id == id)[0];

    this.contentTitle = result.title
    this.contentDescription = result.description
    this.photoCover = result.photoCover
  }

}
