package it.frigir.sfgpetclinic.model;

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
}