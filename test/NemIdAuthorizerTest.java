import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class NemIdAuthorizerTest {
    //Arrange
    NemIdAuthorizer classUnderTest = new NemIdAuthorizer("Users/UserData.csv");

    public void testHasRepeatChars(){
        //Act
        boolean stringWith = classUnderTest.hasRepeatChars("awegriiwægæhwæelhAAAA238402");
        boolean stringWithout = classUnderTest.hasRepeatChars("adælsælgjdæ308y5oæklfsdknglæ");
        //Assert
        assertTrue(stringWith);
        assertFalse(stringWithout);
    }
}