import { TestBed } from '@angular/core/testing';

import { CurrentDistributorService } from './current-distributor.service';

describe('CurrentDistributorService', () => {
  let service: CurrentDistributorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentDistributorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
