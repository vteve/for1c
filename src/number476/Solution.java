package number476;

public class Solution {
    public int findComplement(int num) {
        StringBuilder binaryNum = new StringBuilder(Integer.toBinaryString(num));
        for (int i = 0; i < binaryNum.length(); i++) {
            if (binaryNum.charAt(i) == '0') {
                binaryNum.setCharAt(i, '1');
            } else {
                binaryNum.setCharAt(i, '0');
            }
        }
        return Integer.parseInt(binaryNum.toString(), 2);
    }
}

////
//second solution
class Solution2 {
    public int findComplement(int num) {
        int n = (int) (Math.pow(2, digits(num)) - 1); //calling digits(num) func (int)(2 ^ 3) = 8 - 1 = 7
        return n - num;                              //7 - 5 = 2
    }

    public static int digits(int n) {
        int c = 0;                  //c = 0
        while (n > 0)                //5 > 0, 2 > 0, 1 > 0
        {
            n = n / 2;              //n = 5/2 = 2, 2)2/2 = 1, 3)1/2 = 0
            c++;                    //c = 1, 2, 3
        }
        return c;                   //return 3
    }
}