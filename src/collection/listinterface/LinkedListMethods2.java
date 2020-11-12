package collection.listinterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMethods2 {

    public static void main(String[] args) {
        String test = "madam";
        LinkedList<Character> linkedList = new LinkedList<>();
        for (char ch : test.toCharArray()){
            linkedList.add(ch);
        }

        ListIterator<Character> iterator = linkedList.listIterator();
        ListIterator<Character> reverseIterator = linkedList.listIterator(linkedList.size()); //set index to the last index to iterate from the end

        boolean isPalindrome = true;

        // go through the word from both ends and compare characters
        while (iterator.hasNext() && reverseIterator.hasPrevious()){
            if (iterator.next() != reverseIterator.previous()){
                isPalindrome = false;
                break;
            }
        }

        System.out.println(isPalindrome ? "Is a palindrome" : "Not a palindrome");
    }
}
