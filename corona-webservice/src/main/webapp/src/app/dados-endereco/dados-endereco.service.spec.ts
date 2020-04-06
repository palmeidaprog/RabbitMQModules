import { TestBed } from '@angular/core/testing';

import { DadosEnderecoService } from './dados-endereco.service';

describe('DadosEnderecoService', () => {
  let service: DadosEnderecoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DadosEnderecoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
