class Solution {
    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long pairSum(long[] prefixGcd) {
        long sum = 0;

        int l = 0;
        int h = prefixGcd.length - 1;

        while (l < h) {
            sum += gcd(prefixGcd[l], prefixGcd[h]);
            l++;
            h--;
        }

        return sum;
    }

    public long gcdSum(int[] nums) {
        int n = nums.length;

        long[] prefixGcd = new long[n];
        long prefixMax = nums[0];

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            prefixGcd[i] = gcd(nums[i], prefixMax);
        }

        Arrays.sort(prefixGcd);
        return pairSum(prefixGcd);
    }
}