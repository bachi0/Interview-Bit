public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int res = 0;
        for(int i = 0; i < B; i++)
        {
            res += A.get(i);
        }
        int sum = res;
        for(int i = 0; i < B; i++)
        {
            sum -= A.get(B - 1 - i);
            sum += A.get(A.size() - 1 - i);
            res = Math.max(res, sum);
        }
        return res;
    }
}
