package test.Authenticator;

import junit.framework.TestCase;
import Authenticator.Authenticator;

public class AuthenticatorTest extends TestCase {

    String[][] dataProvider =
            {
                    {
                            "",
                            "e6b0a3b1865219dccbd1bd4558438ddf"
                    },
                    {
                            "1234567890",
                            "5e277080ee8a51e0b3820354f30b7a6a"
                    },
                    {
                            "1a2b3c4d5e6f",
                            "d2c642efca872e3d9c597468fed2ed31"
                    },
                    {
                            "thisisclearlythebiggestpasswordihaveeverseenwithoutanynumbers",
                            "26b1fb2b0ea71923b5ffbd36fbf6c686"
                    },
                    {
                            "i!love@special#symbols$very^much*",
                            "99f6cfcf5be7e8ae82cce5ac61739746"
                    }
            };

    public void testGetMd5Hash() {
        for (String[] testcase : dataProvider) {
            String expected = testcase[1];
            String actual = Authenticator.getMd5Hash(testcase[0]);

            assertEquals(expected, actual);
        }
    }

}
