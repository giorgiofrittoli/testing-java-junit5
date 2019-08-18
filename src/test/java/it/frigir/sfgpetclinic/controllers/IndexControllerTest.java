package it.frigir.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view returned")
    @Test
    void index() {
        assertEquals("index", indexController.index(),"dsadsasda");
        assertEquals("index", indexController.index(),() -> "dsasdasdasda" + "sadsadsad");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertTrue("notimplemented".equals(indexController.oupsHandler()), () -> "this is some expensive "
                + "sdasadsda");
    }
}