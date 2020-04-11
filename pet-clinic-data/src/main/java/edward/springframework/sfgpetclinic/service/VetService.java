package edward.springframework.sfgpetclinic.service;

import edward.springframework.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet finById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
