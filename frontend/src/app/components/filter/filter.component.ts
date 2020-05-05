import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent implements OnInit {
  
  filterForm;

  constructor(private formBuilder: FormBuilder) {
  this.filterForm = this.formBuilder.group({
    priceFrom: 0,
    priceTo: 0,
    name: '',
    order: ''
  });
  }


  ngOnInit(): void {
  }

  onSubmit(customerData) {
  }

}
