import java.util.ArrayList;
import java.util.List;

public class _6_Zizag_Conversion {
    public static String convert(String s, int numRows) {
    StringBuilder sb = new StringBuilder();
    List<Character>[] rows = new List[numRows];
    int k = 0;
    int direction = numRows == 1 ? 0 : -1;
    System.out.println(direction);

    for (int i = 0; i < numRows; ++i)
      rows[i] = new ArrayList<>();

    for (final char c : s.toCharArray()) {
      rows[k].add(c);
      if (k == 0 || k == numRows - 1)
        direction *= -1;
      k += direction;
    }

    for (List<Character> row : rows)
      for (final char c : row)
        sb.append(c);

    return sb.toString();
  }

    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        System.out.println(convert(str, 3));
        // char[][] ch = new char[2][];
        // System.out.println(ch[1][0]);
    }
}
