package utils;

public class StringUtils {
    //We will use similar utils from Apache commons etc. later instead of the ones below.
    public static String getSubString(String text, String start, String end) {
        int startLastIndex = text.indexOf(start) + start.length();
        String strBetween = text.substring(startLastIndex, text.indexOf(end));
        return strBetween;
    }

}
