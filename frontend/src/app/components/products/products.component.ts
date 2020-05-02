import { Component, OnInit } from '@angular/core';
import { ProductClientService } from 'src/app/services/product-client.service';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productList: Product[];
  currentCategoryId: number = 1;
  previousCategoryId: number = 1;

  thePageNumber: number = 1;
  thePageSize: number = 8;
  theTotalElements: number = 0;
 


  constructor(private productClientService: ProductClientService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listOfProducts()
    })

  }

  listOfProducts() {
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('categoryId');
    console.log(this.route.snapshot.paramMap);
    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get('categoryId');
      this.productClientService.getProductsByCategory(this.thePageNumber - 1,
                                                      this.thePageSize,
                                                      this.currentCategoryId).subscribe(this.processResult());
    } else {
      if(this.previousCategoryId != this.currentCategoryId){
        this.thePageNumber = 1;
      }
      this.productClientService.getAllProducts(this.thePageNumber - 1,
                                               this.thePageSize).subscribe(this.processResult());
    }

  }

  processResult(){
    return data => {
      this.productList = data.content;
      this.thePageNumber = data.number + 1;
      this.thePageSize = data.size;
      this.theTotalElements = data.totalElements;
    }
  }
  updateProductsQuantity(pageSize: number){
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listOfProducts();
  }

}
