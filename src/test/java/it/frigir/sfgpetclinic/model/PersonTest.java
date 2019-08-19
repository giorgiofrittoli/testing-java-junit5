package it.frigir.sfgpetclinic.model;

import it.frigir.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements ModelTest {

    @Test
    void groupedAssertion() {
        //give
        Person person = new Person(11L, "joe", "buck");
        assertAll("Test props set",
                () -> assertEquals("joe", person.getFirstName(), "first name failed"),
                () -> assertEquals("buck", person.getLastName(), "last name failed")
        );
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("my repeated test")
    void myReapetedTest() {

    }

    @DisplayName("my repeted test with di")
    @RepeatedTest(5)
    void myRepetedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition() + "-" + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("sadsda")
    @RepeatedTest(value = 2, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    void repetedWithPlaceholders() {

    }
}