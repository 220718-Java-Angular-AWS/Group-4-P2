import { TestBed } from '@angular/core/testing';

import { TryloginService } from './trylogin.service';

describe('TryloginService', () => {
  let service: TryloginService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TryloginService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
