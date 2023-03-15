package leetcode.leetcode0121;

public class Solution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int len = prices.length, max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if(price - min > max){
                max = price - min;
            }
        }
        return max;
    }
}
