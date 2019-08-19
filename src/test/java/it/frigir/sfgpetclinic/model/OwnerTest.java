package it.frigir.sfgpetclinic.model;

import it.frigir.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

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

        assertThat(owner.getCity(), is("ontario"));

    }

    @DisplayName("value source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring", "dsadsadsa"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("enum source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumSource(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("csv source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "FL,1,1",
            "OH,2,2",
            "MI,3,3"
    })
    void testCsvSource(String stateName, String val1, String val2) {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    @DisplayName("csv file source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
    void testCsvFileSource(String stateName, String val1, String val2) {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    @DisplayName("method source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testMethodeSource(String stateName, int val1, int val2) {
        System.out.println(stateName + " " + val1 + " " + val2);
    }

    static Stream<Arguments> getArgs() {
        return Stream.of(Arguments.arguments("FL", 1, 1),
                Arguments.of("OH", 1, 1),
                Arguments.arguments("MI", 6, 7)
        );
    }
}