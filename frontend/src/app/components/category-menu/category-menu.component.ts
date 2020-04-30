import { Component, OnInit } from '@angular/core';
import { ProductCategory, ProductCategoryClientService } from 'src/app/services/product-category-client.service';

@Component({
  selector: 'app-category-menu',
  templateUrl: './category-menu.component.html',
  styleUrls: ['./category-menu.component.css']
})
export class CategoryMenuComponent implements OnInit {

  productCategories: ProductCategory[];

  constructor(private productCategoryClientService: ProductCategoryClientService) { }

  ngOnInit(): void {
    this.listOfCategory();
  }
  listOfCategory(){
    this.productCategoryClientService.getAllCategory().subscribe(
      value => this.productCategories = value);
  }


}
