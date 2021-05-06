import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class NemIdAuthorizerTest {
    //Arrange
    NemIdAuthorizer classUnderTest = new NemIdAuthorizer("Users/UserData.csv");


    @Test
    void hasNumbers() {
    }

    @Test
    void hasIllegalChars() {
    }

    @Test
    void hasRepeatChars(){
        //Act
        boolean stringWith = classUnderTest.hasRepeatChars("awegriiwægæhwæelhAAAA238402");
        boolean stringWithout = classUnderTest.hasRepeatChars("adælsælgjdæ308y5oæklfsdknglæ");
        //Assert
        assertTrue(stringWith);
        assertFalse(stringWithout);
    }

    @Test
    void isValidPassword() {
    }

    @Test
    void hasLetters() {
    }

    @Test
    void hasIllegalBlank() {
    }

    @Test
    void containsCpr() {
    }

    @Test
    void isValidPin() {
    }

    @Test
    void hasSequenceFromCpr() {
    }

    @Test
    void isANumberSeries() {
    }
}