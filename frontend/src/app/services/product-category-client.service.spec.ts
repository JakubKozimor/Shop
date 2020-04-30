import { TestBed } from '@angular/core/testing';

import { ProductCategoryClientService } from './product-category-client.service';

describe('ProductCategoryClientService', () => {
  let service: ProductCategoryClientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProductCategoryClientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
