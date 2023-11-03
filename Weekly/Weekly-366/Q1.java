class Q1 {
    public int differenceOfSums(int n, int m) {
        int ans = 0;
        // Iterate through 1 to n
        for (int i = 1; i <= n; i++) {
            // Your code here
            if (i % m == 0) {
                ans -= i;
            } else {
                ans += i;
            }
        }

        return ans;
    }
}
