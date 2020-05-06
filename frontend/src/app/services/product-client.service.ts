import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Product } from '../common/product';
import { Filter } from '../common/filter';

@Injectable({
  providedIn: 'root'
})
export class ProductClientService {

  private BASE_URL = 'http://localhost:8080/products';
  private URL_FOR_POST_FILTER = 'http://localhost:8080/filter/getProducts';

  actualCategory: number;

  constructor(private httpClient: HttpClient) { }

  public getAllProducts(thePage: number,
    thePageSize: number): Observable<GetResponseProduct> {
    return this.httpClient.get<GetResponseProduct>(`${this.BASE_URL}/allProducts?page=${thePage}&size=${thePageSize}`);
  }

  public getProductsByCategory(thePage: number,
    thePageSize: number,
    theCategoryId: number): Observable<GetResponseProduct> {
    this.actualCategory = theCategoryId;
    return this.httpClient.get<GetResponseProduct>(`${this.BASE_URL}/productsByCategory?page=${thePage}&size=${thePageSize}&categoryId=${theCategoryId}`);
  }

  public getProductsWithFilters(filter: Filter): Observable<GetResponseProduct> {
    filter.categoryId = this.actualCategory;
    if (filter.name == undefined) {
      filter.name = "";
      filter.priceFrom = 0;
      filter.priceTo = 0;
      filter.name = "";
      filter.order = "";
      filter.categoryId = 0;
    }
    console.log(filter);
    return this.httpClient.post<GetResponseProduct>(this.URL_FOR_POST_FILTER, filter).pipe();
  }
}

export interface GetResponseProduct {
  content: Product[];
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}

