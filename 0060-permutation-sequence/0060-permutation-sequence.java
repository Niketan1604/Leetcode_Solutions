class Solution {
    String res; // it will store the final result
    int k; // it will act as the counter
    void helper(StringBuilder s, int[] arr){
        if(s.length()==arr.length){
            k--;
            if(k==0){
                res = s.toString();
            }
            return;
        }

        for(int i = 0; i<arr.length; i++){
            if(arr[i]==0){
                s.append((char)i+1);
                arr[i] = 1;
                helper(s,  arr);
                arr[i] = 0;
                s.deleteCharAt(s.length()-1);
            }
        }
    }
    public String getPermutation(int n, int key) {
        res = "";
        k = key;
        int arr[] = new int[n];
        helper(new StringBuilder(),arr);    
        return res;
    }
}