import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryClientService {

  constructor(private httpClient: HttpClient) { }

  public getAllCategory(): Observable<ProductCategory[]>{
    return this.httpClient.get<ProductCategory[]>('http://localhost:8080/productCategory/allCategory');
  }
}

export interface ProductCategory {
  categoryId: number;
  name: string;
}
