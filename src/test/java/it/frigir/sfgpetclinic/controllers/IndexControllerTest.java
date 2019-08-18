package it.frigir.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

@Tag("controller")
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

        assertThat(indexController.index()).isEqualTo("index");
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

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnMac(){

    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testOnLinux(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testOnJava8(){

    }

    @Test
    @EnabledOnJre(JRE.JAVA_12)
    void testOnJava12(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER",matches = "frigir")
    void testOnUserFrigir(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER",matches = "gg")
    void testOnUserGG(){

    }
}