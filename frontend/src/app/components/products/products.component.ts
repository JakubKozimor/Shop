import { Component, OnInit } from '@angular/core';
import { ProductClientService } from 'src/app/services/product-client.service';
import { ActivatedRoute, Router, NavigationEnd, NavigationStart } from '@angular/router';
import { Product } from 'src/app/common/product';
import { Filter } from 'src/app/common/filter';
import { filter } from 'rxjs/operators';

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

  filter = new Filter();;

  constructor(private productClientService: ProductClientService,
    private route: ActivatedRoute,
    private router: Router) {
    router.events
      .pipe(filter(e => e instanceof NavigationEnd))
      .subscribe((e: NavigationEnd) => {
        if (e.url == '/products') {
          productClientService.actualCategory = 0;
        }
      });
  }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.listOfProducts()
    })

  }

  listOfProducts() {

    if (this.route.snapshot.url[0].path == 'filter') {
      this.getListWithFilters();
    } else {
      this.getListOfProductWithoutFilter();
    }


  }

  getListWithFilters() {
    this.filter.page = this.thePageNumber - 1;
    this.filter.size = this.thePageSize;

    if (this.previousCategoryId != this.currentCategoryId) {
      this.thePageNumber = 1;
    }else { 
      this.productClientService.getProductsWithFilters(this.filter).subscribe(this.processResult());
    }
  }

  getListOfProductWithoutFilter() {
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has('categoryId');
    if (hasCategoryId) {
      this.currentCategoryId = +this.route.snapshot.paramMap.get('categoryId');
      this.productClientService.getProductsByCategory(this.thePageNumber - 1,
        this.thePageSize,
        this.currentCategoryId).subscribe(this.processResult());
    } else {
      if (this.previousCategoryId != this.currentCategoryId) {
        this.thePageNumber = 1;
      }
      this.productClientService.getAllProducts(this.thePageNumber - 1,
        this.thePageSize).subscribe(this.processResult());
    }
  }

  processResult() {
    return data => {
      this.productList = data.content;
      this.thePageNumber = data.number + 1;
      this.thePageSize = data.size;
      this.theTotalElements = data.totalElements;
    }
  }
  updateProductsQuantity(pageSize: number) {
    this.thePageSize = pageSize;
    this.thePageNumber = 1;
    this.listOfProducts();
  }

  updateFilter(customerData: Filter) {
    this.filter = customerData;
    this.listOfProducts();
  }

}
