package temp;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtils {
    //We will use similar utils from Apache commons etc. later instead of the ones below.
    static String getSubString(String text, String start, String end) {
        int startLastIndex = text.indexOf(start) + start.length();
        String strBetween = text.substring(startLastIndex, text.indexOf(end));
        return strBetween;
    }

    @Test
    public void subStringTest(){
        String sub = getSubString("https://sfbay.craigslist.org/search/apa", "https://", ".craigslist");
        Assert.assertEquals(sub, "sfbay");
    }
}
