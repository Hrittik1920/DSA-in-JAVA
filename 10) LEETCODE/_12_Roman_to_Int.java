public class _12_Roman_to_Int {
    public static int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (ch[i] == 'M') {
                res = res + 1000;
            } else if (ch[i] == 'D') {
                res = res + 500;
            } else if (ch[i] == 'C') {
                if (i + 1 == n) {
                    res = res + 100;
                } else if (ch[i + 1] == 'D' || ch[i + 1] == 'M') {
                    res = res - 100;
                } else {
                    res = res + 100;
                }
            } else if (ch[i] == 'L') {
                res = res + 50;
            } else if (ch[i] == 'X') {
                if (i + 1 == n) {
                    res = res + 10;
                } else if (ch[i + 1] == 'L' || ch[i + 1] == 'C') {
                    res = res - 10;
                } else {
                    res = res + 10;
                }
            } else if (ch[i] == 'V') {
                res = res + 5;
            } else if (ch[i] == 'I') {
                if (i + 1 == n) {
                    res = res + 1;
                } else if (ch[i + 1] == 'V' || ch[i + 1] == 'X') {
                    res = res - 1;
                } else {
                    res = res + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }
    // public static int romanToInt(String s) {
    // String[] rom = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
    // char curr,curr2;
    // int ans = 0;
    // for(int i=0;i<s.length();i++) {
    // curr = s.charAt(i);
    // if(curr == 'M') {
    // ans+=1000;
    // } else if(curr == 'D') {
    // ans+=500;
    // } else if(curr == 'L') {
    // ans+=50;
    // } else if(curr == 'V') {
    // ans+=5;
    // } else if(curr == 'C') {
    // try {
    // curr2 = s.charAt(++i);
    // } catch(IndexOutOfBoundsException e) {
    // ans+=100;
    // break;
    // }
    // if(curr2 == 'M') {
    // ans+=900;
    // } else if(curr2 == 'D') {
    // ans+=400;
    // } else {
    // i--;
    // ans+=100;
    // }
    // } else if(curr == 'X') {
    // try {
    // curr2 = s.charAt(++i);
    // } catch(IndexOutOfBoundsException e) {
    // ans+=10;
    // break;
    // }
    // if(curr2 == 'C') {
    // ans+=90;
    // } else if(curr2 == 'L') {
    // ans+=40;
    // } else {
    // i--;
    // ans+=10;
    // }
    // }else if(curr == 'I') {
    // try {
    // curr2 = s.charAt(++i);
    // } catch(IndexOutOfBoundsException e) {
    // ans+=1;
    // break;
    // }
    // if(curr2 == 'X') {
    // ans+=9;
    // } else if(curr2 == 'V') {
    // ans+=4;
    // } else {
    // i--;
    // ans+=1;
    // }
    // }
    // }
    // return ans;
    // }
}
