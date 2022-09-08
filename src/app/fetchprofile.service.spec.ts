import { TestBed } from '@angular/core/testing';

import { FetchprofileService } from './fetchprofile.service';

describe('FetchprofileService', () => {
  let service: FetchprofileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FetchprofileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
