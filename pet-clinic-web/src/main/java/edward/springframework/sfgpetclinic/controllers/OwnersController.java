package edward.springframework.sfgpetclinic.controllers;

import edward.springframework.sfgpetclinic.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnersController {

    private final OwnerService ownerService;

    public OwnersController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listOfOwners(Model model) {

        model.addAttribute("owners", ownerService.findAll());
        return "Owners/index";
    }

    @RequestMapping("/find")
    public String findOWners() {
        return "notimplemented";
    }
}
