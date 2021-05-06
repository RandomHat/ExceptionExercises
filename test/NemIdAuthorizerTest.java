import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class NemIdAuthorizerTest {

    public static void main(String[] args) throws FileNotFoundException {

        NemIdAuthorizer testHasRepeatChars = new NemIdAuthorizer("Users/UserData.csv");

        assertEquals(true, testHasRepeatChars.hasRepeatChars("awegriiwægæhwæelhAAAA238402"));

        assertEquals(false, testHasRepeatChars.hasRepeatChars("adælsælgjdæ308y5oæklfsdknglæ"));
    }
}