package java_review;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListPractice {
    public static void main(String[] args) {
        //create arraylist with values java, SDET, Test
        //iterate arraylist and print out separated by space:
        ArrayList<String> words = new ArrayList<>();
        words.add("java");
        words.add("SDET");
        words.add("Test");
        System.out.println(words);
        for (int i = 0; i < words.size(); i++) {
            System.out.print(words.get(i) + " ");
        }
        System.out.println();
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();

        ArrayList<String> list = new ArrayList<>(Arrays.asList("Google", "Apple", "SpaceX", "Amazon", "Meta"));
        System.out.println(formatArrayList(list));

        //Print arraylist in reverse order separated by space:
        for(int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        ArrayList<String> reversed = reverseArrayList(words);
        System.out.println("reversed = " + reversed);
        System.out.println(reverseArrayList(list));
    }

    /*
    Method accepts arraylist and returns String with values separated by space
     */
    public static String formatArrayList(ArrayList<String> list) {
        String result = "";
        for(String each : list) {
            result += each + " ";
        }
        return result;
    }

    /*
    reverseArrayList: accepts arraylist then returns reversed version
     */
    public static ArrayList<String> reverseArrayList(ArrayList<String> list) {
        ArrayList<String> reversed = new ArrayList<>();
        for(int i = list.size()-1; i >= 0; i--) {
            reversed.add(list.get(i));
        }
        return reversed;
    }

    /*
    fizzBuzzList(): returns Arraylist with fizzbuzz logic
     */
}
