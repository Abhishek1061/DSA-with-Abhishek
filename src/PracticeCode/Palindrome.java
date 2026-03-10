package PracticeCode;

public class Palindrome {
    public static void main(String[] args) {
        String str =  "Madam";
        System.out.println(isPalindromeString(str)
                ? str + " Is palindrome"
                : str + " Is not palindrome"
        );
    }

    public static boolean isPalindrome(String str){
        str =  str.replaceAll("\\s+","").toLowerCase();
        int left  = 0;
        int right =  str.length() -1;
        while (right > left ){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isPalindromeString(String str){
        if(str == null) return false;

        str = str.toLowerCase();
        String reversedStr =  new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
}
