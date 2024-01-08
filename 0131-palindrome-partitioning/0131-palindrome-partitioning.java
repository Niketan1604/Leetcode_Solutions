class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(0,res,list,s);
        return res;
    }
    //pi = partition index;
    void helper(int pi, List<List<String>> res, List<String> list, String s){
        if(pi == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=pi; i<s.length(); i++){
            if(isPallindrome(s,pi,i)){
                list.add(s.substring(pi,i+1));
                helper(i+1,res,list,s);
                list.remove(list.size()-1);
            }
        }         

    }
    boolean isPallindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}