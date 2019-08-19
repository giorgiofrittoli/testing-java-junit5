package it.frigir.sfgpetclinic.model;

import it.frigir.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTest {

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

        assertThat(owner.getCity(),is("ontario"));

    }

    @DisplayName("value source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring","dsadsadsa"})
    void testValueSource(String val) {
        System.out.println(val);
    }
}