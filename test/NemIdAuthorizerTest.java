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
        // Act

        // testing boundary
        String lengthBeyondMax= "1234567890123456789012345678901234567890a";
        String lengthMax= "1234567890123456789012345678901234567890";

        String lengthBelowMin = "123a";
        String lengthMin = "12345a";

        // Assert
        assertFalse(classUnderTest.isValidPassword(lengthBeyondMax));
        assertTrue(classUnderTest.isValidPassword(lengthMax));

        assertFalse(classUnderTest.isValidPassword(lengthBelowMin));
        assertTrue(classUnderTest.isValidPassword(lengthMin));
    }

    @Test
    void hasLetters() {
        // Act

        String onlyLetters = "kaksdnglandsglan";
        String lettersAndNumbers = "t367268rt18r";
        String onlyNumbers = "12345175038176";

        //Assert
        assertTrue(classUnderTest.hasLetters(onlyLetters));
        assertTrue(classUnderTest.hasLetters(lettersAndNumbers));
        assertTrue(classUnderTest.hasLetters(onlyNumbers));
    }

    @Test
    void hasIllegalBlank() {
        var start = " kgjaoghargusa";
        var middle = "ofghagh hgoadihfa123";
        var end = "goairhg123 ";
        var none = "ghidargharkkkk334455";
        assertTrue(classUnderTest.hasIllegalBlank(start));
        assertFalse(classUnderTest.hasIllegalBlank(middle));
        assertTrue(classUnderTest.hasIllegalBlank(end));
        assertFalse(classUnderTest.hasIllegalBlank(none));
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
        // Act
        String tooManyChars = "iiiii";
        String shouldWork = "1234";
        String tooFewChars = "1s3";
        String withWhitespaces = "1 2 3 4";
        String withUncomonSymbols = "#¤%&";

        //Assert
        assertFalse(classUnderTest.isValidPin(tooManyChars));
        assertTrue(classUnderTest.isValidPin(shouldWork));
        assertFalse(classUnderTest.isValidPin(tooFewChars));
        assertFalse(classUnderTest.isValidPin(withWhitespaces));
        assertTrue(classUnderTest.isValidPin(withUncomonSymbols));
    }

    @Test
    void hasSequenceFromCpr() {
    }

    @Test
    void isANumberSeries() {
    }
}