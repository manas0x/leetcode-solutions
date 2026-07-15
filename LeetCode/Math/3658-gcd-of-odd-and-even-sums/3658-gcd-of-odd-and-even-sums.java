class Solution {
    int gcd(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 1;
        int sumEven = 2;
    
        int count = 1;
        int lastOdd = 1;
        int lastEven = 2;
        while(count < n){
            count++;
            lastOdd+=2;
            lastEven+=2;
            sumOdd += lastOdd;
            sumEven += lastEven;
        }
        return gcd(sumOdd , sumEven);
    }

}