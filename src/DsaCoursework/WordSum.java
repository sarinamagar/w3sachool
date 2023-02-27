package DsaCoursework;
import java.util.*;
/**You are given an array of different words and target words. Each character of a word represents a different digit ranging from
 * 0 to 9, and no two character are linked to same digit. If the sum of the numbers represented by each word on the array equals
 * the sum the number represented by the targeted word, return true; otherwise, return false. Note: Provided list of words and
 * targeted word is in the form of equation
 Input: words = ["SIX","SEVEN","SEVEN"], result = "TWENTY" Output: true
 Explanation:
 s=6
 I=5
 X=0,
 E=8,
 V=7,
 N=2,
 T=1,
 W=3,
 Y=4
 SIX +SEVEN + SEVEN = TWENTY 650 + 68782 + 68782 = 138214**/

public class WordSum {

    /**The method requires two inputs: a string called "result" and an array of strings called "words." The method tests
     *  whether the value of the string "result" equals the sum of the values of each word in the array, where each letter
     *  in the words and result stands for a distinct digit from 0 to 9. The private static final field "LETTER TO DIGIT,"
     *  which is a HashMap that maps each letter to its matching digit, defines the mapping between the letters and the digits.**/
    private static final Map<Character, Integer> LETTER_TO_DIGIT = new HashMap<Character, Integer>() {{
        put('S', 6);
        put('I', 5);
        put('X', 0);
        put('E', 8);
        put('V', 7);
        put('N', 2);
        put('T', 1);
        put('W', 3);
        put('Y', 4);
    }};
    /**The "isSumEqual" method calculates the running sum by iterating through each word in the array, computing its value by
     *  searching up each letter's value in the "LETTER TO DIGIT" map, and then adding it to the running sum. It then looks up
     *  the value of each character in the "LETTER TO DIGIT" map to convert the string "result" to an array of integers named "digits."**/

    public static boolean isSumEqual(String[] words, String result) {
        // Compute the sum of the numbers represented by each word in the array
        int sum = 0;
        for (String word : words) {
            int value = 0;
            for (char c : word.toCharArray()) {
                value = value * 10 + LETTER_TO_DIGIT.get(c);
            }
            sum += value;
        }
        int target = 0;
        int[] digits = new int[result.length()];
        for (int i = 0; i < result.length(); i++) {
            digits[i] = LETTER_TO_DIGIT.get(result.charAt(i));
        }
        /**The "permute" method, which employs backtracking to generate all possible combinations of the digits, is then used to
         *  generate all possible permutations of the digits in the "digits" array. The process then loops through each permutation,
         *  turns it into an integer, and compares it to the sum that was previously calculated. It returns true if it discovers a
         *  permutation that equals the sum. Otherwise, false is returned.**/
        List<List<Integer>> permutations = permute(digits);
        for (List<Integer> perm : permutations) {
            int num = 0;
            for (int digit : perm) {
                num = num * 10 + digit;
            }
            if (num == sum) {
                return true;
            }
        }

        return false;
    }

    /**A list of all possible permutations of an array of integers called "nums" is returned by the "permute" method. By testing
     * every potential value for each location in the permutation and retracing if a value does not work, it employs a helper
     * method called "backtrack" to iteratively produce all possible combinations of the numbers.**/
    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    /**The "backtrack" method requires the "nums" array, the "used" boolean array, which records which values have already been
     *  used in the permutation, the "perm" list, which shows the permutation that is currently being created, and the "result" list,
     *  which compiles all possible permutations.f the size of the current permutation is equal to the length of the "nums" array,
     *  it adds the current permutation to the "result" list. Otherwise, it iterates through each value in the "nums" array,
     *  tries it in the current position of the permutation if it has not been used before, and recursively calls itself with the
     *  updated permutation and used arrays. If the value does not work, it backtracks by removing the value from the current
     *  permutation and marking it as unused. **/
    private static void backtrack(int[] nums, boolean[] used, List<Integer> perm, List<List<Integer>> result) {
        if (perm.size() == nums.length) {
            result.add(new ArrayList<>(perm));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm.add(nums[i]);
                    backtrack(nums, used, perm, result);
                    perm.remove(perm.size() - 1);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] words = {"SIX", "SEVEN", "SEVEN"};
        String result = "TWENTY";
        boolean res = isSumEqual(words, result);
        System.out.println(res);
    }
}
