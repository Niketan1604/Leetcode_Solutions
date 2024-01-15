class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> res = new ArrayList<>(2);
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> list1 = new HashSet<>();
        HashSet<Integer> winner = new HashSet<>();
        for(int[] match : matches){
            winner.add(match[0]);
            if(!list1.contains(match[1])){
                if(map.containsKey(match[1])){
                    map.remove(match[1]);
                    list1.add(match[1]);
                }
                else{
                    map.put(match[1],1);
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i : winner){
            if(!list1.contains(i) && !map.containsKey(i)) ans.add(i); 
        }
        Collections.sort(ans);
        
        res.add(new ArrayList<>(ans));
        ans.clear();
        ans.addAll(map.keySet());
        Collections.sort(ans);
        res.add(new ArrayList<>(ans));

        return res;

    }
}