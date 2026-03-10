package CollectionsFramework.List;

public class ComparableStringExample {
    public static void main(String[] args) {
        String str1 = "Apple";
        String str2 = "Banana";

        int result = str1.compareTo(str2);

        if (result < 0) {
            System.out.println(str1 + " comes before " + str2);
        } else if (result == 0) {
            System.out.println(str1 + " is equal to " + str2);
        } else {
            System.out.println(str1 + " comes after " + str2);
        }
    }
}