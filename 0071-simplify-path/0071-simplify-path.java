class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String s[] = path.split("/");
        
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length; i++){
            if(s[i].equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else if(s[i].equals(".") || s[i].length()==0){
                continue;
            }
            else{
                st.push(s[i]);
            }

        }
        // System.out.println(Arrays.toString(s));
        if(st.isEmpty()) return "/";
        while(!st.isEmpty()){
            res.insert(0, "/" + st.pop());
        }
        return res.toString();
    }
}