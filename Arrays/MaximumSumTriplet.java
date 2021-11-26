public class Solution {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int maxSuffArr[] = new int[n + 1];
        maxSuffArr[n] = 0;
        for(int i = n - 1; i >= 0; --i)
            maxSuffArr[i] = Math.max(maxSuffArr[i + 1], A.get(i));
    
        int ans = 0;
        TreeSet<Integer> lowValue = new TreeSet<Integer>();
        lowValue.add(Integer.MIN_VALUE);
        for(int i = 0; i < n - 1; ++i)
        {
            if (maxSuffArr[i + 1] > A.get(i))
            {
                ans = Math.max(ans, lowValue.lower(A.get(i)) + A.get(i) + maxSuffArr[i + 1]);
                lowValue.add(A.get(i));
            }
        }
        return ans;
    }
}