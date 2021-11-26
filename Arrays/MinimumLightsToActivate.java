public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int left, right, count = 0, i = 0, j, pos = 0;
        boolean found = false;
        while(i < A.size()){
            j = Math.min(i + B - 1, A.size() - 1);
            found = false;
            while(j >= (i - B + 1) && j > 0 && j < A.size()){
                if(A.get(j) == 1){
                    found = true;
                    pos = j;
                    count += 1;
                    i = pos + B;
                    break;
                }
                j -= 1;
            }
            if (!found){
                return -1;
            }
        }
        return count;
    }
}