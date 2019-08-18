package it.frigir.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {
        Owner owner = new Owner(11L, "joe", "buck");
        owner.setCity("ontario");
        owner.setTelephone("333333333");

        assertAll("Prop tests",
                () -> assertAll("Person prop"
                        , () -> assertEquals("joe", owner.getFirstName(), "first name failure")
                        , () -> assertEquals("buck", owner.getLastName(), "last name failure")
                ),
                () -> assertAll("Owner prop",
                        () -> assertEquals("ontario", owner.getCity(), "city failure"),
                        () -> assertEquals("333333333", owner.getTelephone(), "telephone failure")
                )
        );

    }

}