import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { Product } from '../common/product';
import { Filter } from '../common/filter';

@Injectable({
  providedIn: 'root'
})
export class ProductClientService {

  private baseUrl = 'http://localhost:8080/products';


  constructor(private httpClient: HttpClient) { }

  public getAllProducts(thePage: number,
    thePageSize: number): Observable<GetResponseProduct> {
    return this.httpClient.get<GetResponseProduct>(`${this.baseUrl}/allProducts?page=${thePage}&size=${thePageSize}`);
  }

  public getProductsByCategory(thePage: number,
    thePageSize: number,
    theCategoryId: number): Observable<GetResponseProduct> {
    return this.httpClient.get<GetResponseProduct>(`${this.baseUrl}/productsByCategory?page=${thePage}&size=${thePageSize}&categoryId=${theCategoryId}`);
  }

}

export interface GetResponseProduct {
  content: Product[];
  size: number;
  totalElements: number;
  totalPages: number;
  number: number;
}

