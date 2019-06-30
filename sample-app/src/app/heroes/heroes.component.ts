// tslint:disable-next-line:no-trailing-whitespace
import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../hero';
import { testVariable } from '../mock-heroes';
import { HEROES } from '../mock-heroes';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  @Input('test') oneWayBindingVariable: string;
  oneway = 'A Variable with one way Binding';
  testVar = testVariable;
  heroList: Hero[] = HEROES;

  hero: Hero = {
    id: 1,
    name: 'Amol'
  };
  // tslint:disable-next-line:no-trailing-whitespace

  selectedHero: Hero;
  isHeroSelected = false;
  twoWayBindingVariable = 'Two way binding variable';
  constructor() { }

  ngOnInit() {
  }
  // tslint:disable-next-line:no-trailing-whitespace

  onSelect(hero: Hero) {
    this.selectedHero = hero;
    this.isHeroSelected = true;
  }

}
