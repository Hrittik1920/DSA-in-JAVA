public class _8_String_to_Integer_atoi {
    public static int myAtoi(String s) {
        s = s.trim();
        
        char curr;
        char sign = '#';
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++) {
            curr = s.charAt(i);
            if(i==0 && (curr == '-' || curr == '+')) {
                sign = curr;
                continue;
            }
            if(!Character.isDigit(curr)) {
                break;
            }
            sb.append(curr);
        }
        if(sb.length() == 0) {
            return 0;
        }
        int ans = 0;
        try{
            ans = Integer.parseInt(sb.toString());
        } catch(NumberFormatException e) {
            return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        return sign == '-' ? -1*ans : ans;
    }
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(myAtoi(s));
    }
}