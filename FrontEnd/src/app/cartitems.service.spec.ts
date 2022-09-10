import { TestBed } from '@angular/core/testing';

import { CartItemsService } from './cartItems.service';

describe('CartItemsService', () => {
  let service: CartItemsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CartItemsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
