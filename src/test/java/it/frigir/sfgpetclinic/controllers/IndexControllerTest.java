package it.frigir.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test proper view returned")
    @Test
    void index() {
        assertEquals("index", indexController.index(), "dsadsasda");
        assertEquals("index", indexController.index(), () -> "dsasdasdasda" + "sadsadsad");
    }

    @Test
    @DisplayName("Test exception")
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> indexController.oupsHandler());
    }

    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(200), () -> Thread.sleep(100));
    }

    @Test
    void testTimeoutPrempt() {
        assertTimeout(Duration.ofMillis(200), () -> Thread.sleep(100));
        System.out.println("sadsadsda");
    }

    @Test
    void testAssumptionTrueIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    void testAssumptionTrueisFalse() {
        assumeTrue("GURU".equalsIgnoreCase("GURU2"));
    }
}