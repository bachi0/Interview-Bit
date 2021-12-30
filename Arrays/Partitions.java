public class Solution {
    public int solve(int A, ArrayList<Integer> B) {
        int sum = 0;
        for(int i = 0; i < A; i++){
            sum += B.get(i);
        }
        if(sum % 3 != 0){
            return 0;
        }
        ArrayList<Integer> pos = new ArrayList<Integer>(Collections.nCopies(A, 0));
        int temp = 0;
        int partition = sum / 3;
        for(int i = A - 1; i >= 0; i--){
            temp += B.get(i);
            if( temp == partition){
                pos.set(i, 1);
            }
        }
        temp = 0;
        int count = 0;
        for(int i = 0; i < A; i++){
            temp += B.get(i);
            if(temp == partition){
                for(int j = i + 2; j < A; j++){
                    if(pos.get(j) == 1){
                        count += 1;
                    }
                }
            }
        }
        return count;

    }
}
