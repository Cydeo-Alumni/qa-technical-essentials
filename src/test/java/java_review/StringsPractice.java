package java_review;

public class StringsPractice {
    public static void main(String[] args) {
        //1) declare a string with some value and print each character
        //separated by space : "hello" -> "h e l l o"
        //2)Write a method printEach/addSpace that's string and prints/or returns
        String str = "hello";
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
        printEach("Java");
        System.out.println(addSpace("Apples"));

        //Print each character in reverse
        str = "zoom";
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
        //custom method returns reverseString
        System.out.println(reverseString("computer"));

        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome("gptg"));
    }

    public static void printEach(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    public static String addSpace(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) + " ";
        }

        return result;
    }

    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length()-1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }

    /*
     method isPalindrome that checks if a string is palindrome
     then return true or false. "ajava"
     We will iterate string from left and right in same loop
     */
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length()-1;

        while(left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
