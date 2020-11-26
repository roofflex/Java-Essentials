package regex;

import java.util.regex.Pattern;

public class Regex3 {
    public static void main(String[] args) {
        String regex = "((25[0-5]|2[0-4]\\d|[01]?\\d?\\d)(\\.)){3}" +
                        "(25[0-5]|2[0-4]\\d|[01]?\\d?\\d)";

        // regex pattern:

        // 250-255 or 200-249 or 0-199  x3 times,
        // 250-255 or 200-249 or 0-199 last one

        String ip1 = "255.38.192.99"; // ip OK
        String ip2 = "182.262.91.05"; // ip NOT ok

        System.out.println(ip1 + " is OK?   -   " + Pattern.matches(regex, ip1));
    }
}
