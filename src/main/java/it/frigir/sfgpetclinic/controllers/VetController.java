package it.frigir.sfgpetclinic.controllers;

import it.frigir.sfgpetclinic.fauxspring.Model;
import it.frigir.sfgpetclinic.services.VetService;

public class VetController {

    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }

    public String listVets(Model model){

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
