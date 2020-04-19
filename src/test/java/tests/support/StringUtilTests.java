package tests.support;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.StringUtils;

public class StringUtilTests {
    @Test
    public void subStringTest(){
        String sub = StringUtils.getSubString("https://sfbay.craigslist.org/search/apa", "https://", ".craigslist");
        Assert.assertEquals(sub, "sfbay");
    }
}
