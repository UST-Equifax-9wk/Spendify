import { TestBed } from '@angular/core/testing';

import { DistributorServiceService } from './distributor-service.service';

describe('DistributorServiceService', () => {
  let service: DistributorServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DistributorServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
