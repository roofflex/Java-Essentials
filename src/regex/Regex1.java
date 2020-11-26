package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
    public static void main(String[] args) {

        // [] indicate 1 symbol from inner range
        // [C-F] allows C or D or E or F
//        String s1 = "ABDOP";
//        Pattern pattern1 = Pattern.compile("AB[C-F]OP");
//        Matcher matcher = pattern1.matcher(s1);


        // abc and any 1 symbol NOT from e-j or 2-8
//        String s1 = "abcd abcf abc7 abc1 abcr";
//        Pattern pattern1 = Pattern.compile("abc[^e-j2-8]");
//        Matcher matcher = pattern1.matcher(s1);


        // . is for any 1 symbol
//        String s1 = "abcd abcf abc7 abc1 abcr";
//        Pattern pattern1 = Pattern.compile("abc.");
//        Matcher matcher = pattern1.matcher(s1);


        // ^ indicates start of string, $ - end of string
//        String s1 = "abcd abcf abc7abc1abcr";
//        Pattern pattern1 = Pattern.compile("^abc");
//        Matcher matcher = pattern1.matcher(s1);
//
//        String s1 = "abcd abcf abc7abc1abcr";
//        Pattern pattern1 = Pattern.compile("abc$");
//        Matcher matcher = pattern1.matcher(s1);

        // \d indicates 1 digit
        // \D indicates 1 symbol that is NOT a digit
//        String s1 = "abcd abcf abc7 abc1 abcr";
//        Pattern pattern1 = Pattern.compile("\\d");
//        Matcher matcher = pattern1.matcher(s1);


        // \w indicates 1 symbol a-z or A-Z or _
        // \W indicates opposite of \w
//        String s1 = "abcd abcf abc7 abc1 abcr";
//        Pattern pattern1 = Pattern.compile("\\w");
//        Matcher matcher = pattern1.matcher(s1);

        // number of symbols:
        // ?    -   indicates 0/1
        // *    -   indicates any
        // +    -   indicates 1+
        // {n}  -   indicates n times
        // {n, m}   -   indicates from n to m times
        // {n,} -   indicates n+ times

//        String s1 = "abcd ab&*cf a!@bc7 % abc1 ++++abcr";
//        Pattern pattern1 = Pattern.compile("\\W+");
//        Matcher matcher = pattern1.matcher(s1);

        String s1 = "house car tiny match ball ear";
        Pattern pattern1 = Pattern.compile("\\w{4}");
        Matcher matcher = pattern1.matcher(s1);

        while (matcher.find()){
            System.out.println("Position: " + matcher.start() + "    " + matcher.group());
        }
    }
}
