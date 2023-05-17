import java.util.*;

public class CombiningDigits {

private static Map<Character, String> buttonMap = new HashMap<Character,
  String>() {{
  put('2', "abc");
  put('3', "def");
  put('4', "ghi");
  put('5', "jkl");
  put('6', "mno");
  put('7', "pqrs");
  put('8', "tuv");
  put('9', "wxyz");
}};

public static List<String> outp = new ArrayList<String>();

public static class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}

public static void backtrack(String combination, String followingNum) {
        if (followingNum.length() != 0) {
            //char n = followingNum.charAt(0);
            if (!buttonMap.containsKey(followingNum.charAt(0))) {
                throw new InvalidInputException("Invalid digit: " + followingNum.charAt(0));
            }
            String num = followingNum.substring(0, 1);
            String letters = buttonMap.get(num.charAt(0));
            for (int i = 0; i < letters.length(); i++) {
                String letter = buttonMap.get(num.charAt(0)).substring(i, i + 1);
                backtrack(combination + letter, followingNum.substring(1));
                }
        }else{
            outp.add(combination);
    }
}

public static void bubbleSort(List<String> outp){
        for (int i = 0; i < outp.size() - 1; i++) {
            for (int j = 0; j < outp.size() - i - 1; j++) {
                if (outp.get(j).compareTo(outp.get(j + 1)) > 0) {
                String temp = outp.get(j);
                outp.set(j, outp.get(j + 1));
                outp.set(j + 1, temp);
                }
            }
        }
    }
    
public static List<String> letterCombinations(String num) {
        if (num.length() != 0){
            backtrack("", num);}
            bubbleSort(outp);
        
        return outp;
    }

public static void main(String[] args) {
      
        System.out.print("digits = ");
        Scanner myObj = new Scanner(System.in);
        String nums = myObj.nextLine();
        
        System.out.println(letterCombinations(nums));
    }

};



