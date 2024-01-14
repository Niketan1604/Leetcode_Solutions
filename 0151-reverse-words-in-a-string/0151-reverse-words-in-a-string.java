class Solution {
    public String reverseWords(String s) {
        String[] str = s.trim().split("\\s+");
        StringBuilder op = new StringBuilder();
        for(int i = str.length -1; i > 0; i--) {
            op.append(str[i] + " ");
        }
        op.append(str[0]);
        return op.toString();
    }
}