import java.util.Scanner;

public class AnagramChecker {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter word 1: ");
        String word1 = scanner.nextLine().toLowerCase();
        System.out.print("Enter word 2: ");
        String word2 = scanner.nextLine().toLowerCase();
        String cleanedWord1 = word1.replaceAll("[^\\w]", "");
        String cleanedWord2 = word2.replaceAll("[^\\w]", "");
        if (cleanedWord1.length() != cleanedWord2.length()) {
            System.out.println("Not an anagram");
            return;
        }
        int[] letterCount = new int[26];
        for (char c : cleanedWord1.toCharArray()) {
            letterCount[c - 'a']++;
        }
        for (char c : cleanedWord2.toCharArray()) {
            letterCount[c - 'a']--;
        }
        for (int count : letterCount) {
            if (count != 0) {
                System.out.println("Not an anagram");
                return;
            }
        }
        System.out.println("It's an anagram!");
        scanner.close();
    }
}
