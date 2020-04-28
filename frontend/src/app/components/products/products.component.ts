import { Component, OnInit } from '@angular/core';
import { ProductClientService, Product } from 'src/app/services/product-client.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productList: Product[];

  constructor(private productClientService: ProductClientService) { }

  ngOnInit(): void {
    this.productClientService.getAllProducts().subscribe(value => this.productList = value);
  }

}
