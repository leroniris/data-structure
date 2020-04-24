package sort;

/**
 * @author Leron
 * @version 1.0.0
 * @create 2020/3/30 16:47
 */
public class Main{
    public static int subString(int k, String str) {
        int length = str.length();
        int sum = 0;
        if(k > length) {
            return 0;
        }
        for(int i = 0; i < length; i++) {
            for(int j = i; j <= length; j++) {
                String subStr = str.substring(i,j);
                int count = 0;
                for(int h = 0; h < subStr.length(); h++) {
                    if(subStr.charAt(h) == '1') {
                        count++;
                    }
                }
                if(count == k) {
                    sum++;
                }
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(Main.subString(1, "1010"));
    }
}