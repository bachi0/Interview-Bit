public class Solution {
    public int solve(ArrayList<String> A) {
        int n = A.size();
        int m = A.get(0).length();
        int ans = 0;
        for(int j = 0; j < m; j++){
            ArrayList<Integer> First = new ArrayList<Integer>(Collections.nCopies(3, - 1));
            ArrayList<Integer> Last = new ArrayList<Integer>(Collections.nCopies(3, - 1));
            for(int i = 0; i < n; i++){
                if(A.get(i).charAt(j) == 'r' && First.get(0) == -1){
                    First.set(0, i);
                }
                if(A.get(i).charAt(j) == 'g' && First.get(1) == -1){
                    First.set(1, i);
                }
                if(A.get(i).charAt(j) == 'b' && First.get(2) == -1){
                    First.set(2, i);
                }
            }
            for(int i = n - 1; i >= 0; i--){
                if(A.get(i).charAt(j) == 'r' && Last.get(0) == -1){
                    Last.set(0, i);
                }
                if(A.get(i).charAt(j) == 'g' && Last.get(1) == -1){
                    Last.set(1, i);
                }
                if(A.get(i).charAt(j) == 'b' && Last.get(2) == -1){
                    Last.set(2, i);
                }
            }
            ArrayList<Integer> v1 = new ArrayList(Arrays.asList(0, 0, 1, 1, 2, 2));
            ArrayList<Integer> v2 = new ArrayList(Arrays.asList(1, 2, 0, 2, 0, 1));
            for(int i = 0; i < 6; i++){
                if(First.get(v1.get(i)) != -1 && Last.get(v2.get(i)) != - 1){
                    ans = Math.max(ans, height(A, j, First.get(v1.get(i)), Last.get(v2.get(i))));
                }
            }
        }
        return ans;
    }
    static int height(ArrayList<String> A, int col, int a, int b){
        int n = A.size();
        int m = A.get(0).length();
        int ans = 0;
        int base = Math.abs(a - b) + 1;
        int ht = (m - 1) - col + 1;
        for(int j = m - 1; j > col; j--){
            int flag = 0;
            for(int i = 0; i < n; i++){
                if(A.get(i).charAt(j) != A.get(a).charAt(col) && A.get(i).charAt(j) != A.get(b).charAt(col)){
                    ans = (int) Math.ceil((base * ht + 1) / 2);
                    flag = 1;
                    break;
                }
            }
            ht--;
            if(flag == 1){
                break;
            }
            
        }
        ht = col + 1;
        for(int j = 0; j < col; j++){
            int flag = 0;
            for(int i = 0; i < n; i++){
                if(A.get(i).charAt(j) != A.get(a).charAt(col) && A.get(i).charAt(j) != A.get(b).charAt(col)){
                    ans = (int) Math.max(ans, Math.ceil((base * ht + 1) / 2));
                    flag = 1;
                    break;
                }
            }
            ht--;
            if(flag == 1){
                break;
            }
        }
        return ans;
    }
}
