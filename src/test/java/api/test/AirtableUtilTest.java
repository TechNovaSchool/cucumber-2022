package api.test;

import org.testng.annotations.Test;
import utilities.APIUtil;

public class AirtableUtilTest {

    @Test
    public void testGetMethod() {
        String resource = "/Table%201";
        APIUtil.hitGET(resource);
    }
}
