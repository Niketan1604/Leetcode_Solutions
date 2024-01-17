class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i].equals("+")){
                int temp = st.pop();
                st.push(st.pop() + temp);
            } 
            else if(tokens[i].equals("/")){
                int temp = st.pop();
                st.push(st.pop() / temp);
            }
            else if(tokens[i].equals("*")){
                int temp = st.pop();
                st.push(st.pop() * temp);
            }
            else if(tokens[i].equals("-")){
                int temp = st.pop();
                st.push(st.pop() - temp);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            } 
        }
        return st.pop();
    }
}