import java.util.ArrayList;
import java.util.List;

public class _17_Letter_Combination_Phone_Number {
    String[]keyboard = {
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return new ArrayList<>();
        }
        for(int i=0;i<digits.length();i++) {

        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        String digits = "23";
    }
}