package edward.springframework.sfgpetclinic.bootstrap;

import edward.springframework.sfgpetclinic.model.*;
import edward.springframework.sfgpetclinic.service.OwnerService;
import edward.springframework.sfgpetclinic.service.PetTypeService;
import edward.springframework.sfgpetclinic.service.SpecialtiesService;
import edward.springframework.sfgpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtiesService specialtiesService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtiesService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();
        if (count ==0) {
            loadDate();
        }
        loadDate();
    }

    private void loadDate() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

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
        michalePet.setPetType(savedCatPetType);
        michalePet.setOwner(owner2);
        michalePet.setBirthdate(LocalDate.now());
        michalePet.setName("Small cat");
        owner2.getPets().add(michalePet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Edward");
        vet2.setLastName("Korkollie");
        vet2.getSpecialties().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets.....");
    }
}
