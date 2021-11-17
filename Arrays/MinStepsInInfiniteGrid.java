public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int count = 0, dx, dy;
        for(int i = 1; i < A.size(); i++){
            dx = Math.abs(A.get(i - 1) - A.get(i));
            dy = Math.abs(B.get(i - 1) - B.get(i));
            count += Math.max(dx, dy);
        }
        return count;
    }
}
