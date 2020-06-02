package edward.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person{

    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(name = "vet_specialties", joinColumns = @JoinColumn(name = "vet_id"),
     inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}

/**
 * @ManyToMany(fetch = FetchType.EAGER ) // means by default anything that's a many relationship is lazily initialized. when set to eager
 * that means JPA is going to try to load everything all at once.
 * By Lazy initilization, which is default, it doesnt load until it is asked for so you will get back of that entity the specialties would be null
 * if we did not do this.
 *
 */