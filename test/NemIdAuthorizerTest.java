import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class NemIdAuthorizerTest {

    public void testHasRepeatChars(){
        //Arrange
        NemIdAuthorizer testHasRepeatChars = new NemIdAuthorizer("Users/UserData.csv");
        //Act
        boolean stringWith = testHasRepeatChars.hasRepeatChars("awegriiwægæhwæelhAAAA238402");
        boolean stringWithout = testHasRepeatChars.hasRepeatChars("adælsælgjdæ308y5oæklfsdknglæ");
        //Assert
        assertTrue(stringWith);
        assertFalse(stringWithout);
    }
}