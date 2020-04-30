import { Component, OnInit } from '@angular/core';
import { ProductClientService, Product } from 'src/app/services/product-client.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productList: Product[];
  currentCategoryId: number;

  constructor(private productClientService: ProductClientService,
              private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listOfProducts()
    })
    
  }

  listOfProducts(){
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('categoryId');
    console.log(this.route.snapshot.paramMap);
    if(hasCategoryId){
      this.currentCategoryId = +this.route.snapshot.paramMap.get('categoryId');
      this.productClientService.getProductsByCategory(this.currentCategoryId).subscribe(
        value => this.productList = value);
    }else{
      this.productClientService.getAllProducts().subscribe(
        value => this.productList = value);
    }
    
  }

}
