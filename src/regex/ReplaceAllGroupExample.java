package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceAllGroupExample {
    public static void main(String[] args) {
        String s1 = "Hello,    my  friend,        how is     your   Java  experience   ?";
        System.out.println(s1);

        s1 = s1.replaceAll(" {2,}", " ");
        System.out.println(s1);


        String creditCardsCredentials = "12345678904567211122765\n" +
                                        "56784532097567771020765\n" +
                                        "46589238757436450821676";

        // credit card number, expiration date and cvv
        // 1234 5678 0456 7211 11/22 (765)

        // reformat to print in format
        // 11/22 1234 5678 0456 7211 (765)


        // () indicate groups, starting from 1
        Pattern pattern = Pattern.compile("(\\d{4})(\\d{4})(\\d{4})(\\d{4})(\\d{2})(\\d{2})(\\d{3})");
        Matcher matcher = pattern.matcher(creditCardsCredentials);

        // $5 indicates 5th group
        String formattedString = matcher.replaceAll("$5/$6 $1 $2 $3 $4 ($7)");
        System.out.println(formattedString);

    }
}
