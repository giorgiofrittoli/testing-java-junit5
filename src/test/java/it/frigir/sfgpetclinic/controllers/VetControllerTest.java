package it.frigir.sfgpetclinic.controllers;

import it.frigir.sfgpetclinic.fauxspring.Model;
import it.frigir.sfgpetclinic.fauxspring.ModelImpl;
import it.frigir.sfgpetclinic.model.Vet;
import it.frigir.sfgpetclinic.services.VetService;
import it.frigir.sfgpetclinic.services.map.SpecialityMapService;
import it.frigir.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {

    VetController vetController;
    VetService vetService;

    @BeforeEach
    void setUp() {
        vetService = new VetMapService(new SpecialityMapService());
        vetService.save(new Vet(12L, "joe", "buck", new HashSet<>()));
        vetService.save(new Vet(13L, "jesse", "buck", new HashSet<>()));
        vetController = new VetController(vetService);
    }

    @Test
    void listVets() {
        Model model = new ModelImpl();
        HashSet<Vet> vets = new HashSet<>();
        vets.addAll(Arrays.asList(
                new Vet(12L, "joe", "buck", new HashSet<>()),
                new Vet(13L, "jesse", "buck", new HashSet<>())
        ));
        model.addAttribute("vets", vets);
        assertEquals("vets/index", vetController.listVets(model));
        assertEquals(vetService.findAll(), model.getAttribute("vets"));
    }
}