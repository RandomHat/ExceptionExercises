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
        String stringWithBeginning = "hhhhqæuæowiqbgæqb43";
        String stringWithMiddle = "awegriiwægæhwæelhAAAA238402";
        String stringWithEnd = "aæjfbæaeubhoih32grjkawebfæk0000";

        String stringWithout = "adælsælgjdæ308y5oæklfsdknglæ";
        //Assert
        assertTrue(classUnderTest.hasRepeatChars(stringWithBeginning));
        assertTrue(classUnderTest.hasRepeatChars(stringWithMiddle));
        assertTrue(classUnderTest.hasRepeatChars(stringWithEnd));

        assertFalse(classUnderTest.hasRepeatChars(stringWithout));
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
        var cpr = "1122334444";
        assertTrue(classUnderTest.containsCpr(cpr, cpr + "somethingElse"));
        assertTrue(classUnderTest.containsCpr(cpr, "somethingElse" + cpr));
        assertTrue(classUnderTest.containsCpr(cpr, "something" + cpr + "else"));
        assertFalse(classUnderTest.containsCpr(cpr, "somethingElse"));
        assertFalse(classUnderTest.containsCpr(cpr, cpr.substring(0, 6)));
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