package it.frigir.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void groupedAssertion() {
        //give
        Person person = new Person(11L, "joe", "buck");
        assertAll("Test props set",
                () -> assertEquals("joe", person.getFirstName(), "first name failed"),
                () -> assertEquals("buck", person.getLastName(), "last name failed")
        );
    }

    @Test
    @RepeatedTest(value = 10, name = "{displayname} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("my repeated test")
    void myReapetedTest() {

    }
}