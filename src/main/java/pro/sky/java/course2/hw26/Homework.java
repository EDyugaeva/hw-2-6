package pro.sky.java.course2.hw26;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Homework {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 9, 2, 3, 4, 4, 5, 5, 6, 7, 4, 2));
        List<String> listOfWords = new ArrayList<>(List.of("Иван", "Иван", "Сергей", "Дмитрий"));

        System.out.println(getOddNumbers(nums));
        System.out.println(getOddNumbersSorted(nums));
        System.out.println(getUniqWords(listOfWords));
        System.out.println(findCountDoubledWords(listOfWords));

    }

    public static List<Integer> getOddNumbers(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 != 0) {
                result.add(nums.get(i));
            }
        }
        return result;
    }

    public static List<Integer> getOddNumbersSorted(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                result.add(nums.get(i));
            }
        }
        result.sort(Comparator.naturalOrder());
        for (int i = 0; i < result.size() - 1; i++) {
            if (result.get(i) == (result.get(i + 1))) {
                result.remove(result.get(i));
                i--;
            }
        }
        return result;

    }

    public static List<String> getUniqWords(List<String> words) {
        List<String> wordsCopy = new ArrayList<>(words);
        wordsCopy.sort(String::compareToIgnoreCase);
        for (int i = 0; i < wordsCopy.size() - 1; i++) {
            if (wordsCopy.get(i).equalsIgnoreCase(wordsCopy.get(i + 1))) {
                wordsCopy.remove(wordsCopy.get(i));
                i--;
            }
        }
        return wordsCopy;
    }

    public static int findCountDoubledWords(List<String> words) {
        List<String> result = getUniqWords(words);
        return words.size()-result.size();
    }


}









