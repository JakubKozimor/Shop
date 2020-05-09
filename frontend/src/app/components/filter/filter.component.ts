import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ProductsComponent } from '../products/products.component';
import { Filter } from 'src/app/common/filter';
import { Router } from '@angular/router';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  
  filterForm;
  filter: Filter;
  constructor(private routes: Router,
    private formBuilder: FormBuilder,
    private productComponent: ProductsComponent) {
  this.filterForm = this.formBuilder.group({
    priceFrom: undefined,
    priceTo: undefined,
    name: '',
    order: "brak sortowania"
  });
  }


  ngOnInit(): void {
  }

  onSubmit(customerData) {
    this.filter = customerData;
    this.productComponent.updateFilter(this.filter);
  }

}
