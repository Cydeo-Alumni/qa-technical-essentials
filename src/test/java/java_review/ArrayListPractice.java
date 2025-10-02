package java_review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println(fizzBuzzList());

        List<Double> prices = new ArrayList<>(Arrays.asList(10.3, 5.7, 9.0));
        System.out.println("Total : $" + calculateTotalOrder(prices));
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
    public static ArrayList<String> fizzBuzzList() {
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(i+"");
            }
        }
        return result;
    }

    /*
    calculateTotalOrder: accepts list of prices and return total
     */
    public static double calculateTotalOrder(List<Double> prices) {
        double total = 0;
        for (double price : prices) {
            total += price;
        }
        return total;
    }
}
