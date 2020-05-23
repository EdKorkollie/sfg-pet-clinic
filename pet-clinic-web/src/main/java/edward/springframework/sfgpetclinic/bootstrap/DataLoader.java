package edward.springframework.sfgpetclinic.bootstrap;

import edward.springframework.sfgpetclinic.model.Owner;
import edward.springframework.sfgpetclinic.model.Pet;
import edward.springframework.sfgpetclinic.model.PetType;
import edward.springframework.sfgpetclinic.model.Vet;
import edward.springframework.sfgpetclinic.service.OwnerService;
import edward.springframework.sfgpetclinic.service.PetTypeService;
import edward.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Fiona");
        owner1.setLastName("Weston");
        owner1.setAddress("234 Baker street");
        owner1.setCity("Philly");
        owner1.setTelephone("34545767");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner1);
        mikePet.setBirthdate(LocalDate.now());
        mikePet.setName("Small Dog");
        owner1.getPets().add(mikePet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Jai");
        owner2.setAddress("134 Baker street");
        owner2.setCity("State college");
        owner2.setTelephone("3454679876");

        Pet michalePet = new Pet();
        michalePet.setPetType(savedDogPetType);
        michalePet.setOwner(owner2);
        michalePet.setBirthdate(LocalDate.now());
        michalePet.setName("Small cat");
        owner2.getPets().add(michalePet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Edward");
        vet2.setLastName("Korkollie");

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
