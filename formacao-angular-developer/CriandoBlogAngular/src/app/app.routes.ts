import { Routes } from '@angular/router';
import {HomeComponent} from "./pages/home/home.component";
import {ContentComponent} from "./pages/content/content.component";

export const routes: Routes = [
  {
    path:'',
    title: 'Home',
    component: HomeComponent
  },
  {
    path:'content/:id',
    title: 'Conteudo',
    component:ContentComponent
  }
];
