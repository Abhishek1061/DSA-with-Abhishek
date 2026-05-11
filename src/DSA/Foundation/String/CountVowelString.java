package DSA.Foundation.String;

public class CountVowelString {
    public static void main(String[] args ){
        String str =  "Abhishek Kadam";
        System.out.println(countVowel(str));
    }

    public static String countVowel(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                    ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
        }
        return "Total number of vowels in the string is: " + count;
    }
}
