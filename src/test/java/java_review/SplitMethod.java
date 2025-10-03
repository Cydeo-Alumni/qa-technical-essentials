package java_review;

public class SplitMethod {
    public static void main(String[] args) {
        //declare sentence and print each word in separate lines
        String sentence = "Java technical fundamentals practice";
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        System.out.println("words count = " + words.length);
        
        //Declare string reversed ="", assign reversed sentence
        String reversed = "";
        for (int i = words.length-1; i >= 0; i--) {
            reversed += words[i] + " ";
        }
        System.out.println("reversed = " + reversed);

        System.out.println(reverseSentence("hello friends!"));
        System.out.println(reverseSentence("java is cool"));
    }

    /*
    reverseSentence: accepts String sentence and returns reversed sentence
     */
    public static String reverseSentence(String sentence) {
        String result = "";
        String[] words = sentence.split(" ");
        for(int i = words.length-1; i >= 0; i--) {
            result += words[i] + " ";
        }
        return result.trim();
    }
}
