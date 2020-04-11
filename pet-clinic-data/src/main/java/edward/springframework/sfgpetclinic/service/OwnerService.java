package edward.springframework.sfgpetclinic.service;

import edward.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner finById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
