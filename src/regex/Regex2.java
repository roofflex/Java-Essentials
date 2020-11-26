package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex2 {
    public static void main(String[] args) {

        String string = "Ivanov Vasiliy, Russia, Krasnodar, Lenina Street, 48, Flat 92," +
                        "email: vasyaI83@gmail.com, Postcode: CF70, Phone number: +79886534102" +
                        "Mariya Krasavina, Russia, Sochi, Admiralteyskaya Street, 22, Flat 61," +
                        "email: krasavinam@mail.ru, Postcode: HJ03, Phone number: +79990234256";


        // Searching for building and flat numbers(assume that they consist of 2 digits)
        // \b indicates border of a word/number, \d indicates 1 digit 0-9, {2} indicates two repetitions of range \d
//        Pattern pattern = Pattern.compile("\\b\\d{2}\\b");

        // Searching for phone numbers:
//        Pattern pattern = Pattern.compile("\\+\\d{10}");


        // Searching for emails:
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");

        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){
            System.out.println(matcher.group());
        }



    }
}
