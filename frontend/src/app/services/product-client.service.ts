import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductClientService {

  private baseUrl = 'http://localhost:8080/products';


  constructor(private httpClient: HttpClient) { }

  public getAllProducts(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`${this.baseUrl}/allProducts`);
  }

  public getProductsByCategory(theCategoryId: number): Observable<Product[]> {
    return this.httpClient.get<Product[]>(`http://localhost:8080/products/productsByCategory?categoryId=${theCategoryId}`);
  }
}

export interface Product {
  productId: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
  categoryId: number;
}
