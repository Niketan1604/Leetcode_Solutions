class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new ArrayList<>();
        List path= new ArrayList<>();
        int arr[]=new int[n];
        for(int i =1;i<=n;i++)
            arr[i-1]=i;
            solve(arr,ans,path,0,n,k);
        return ans;
    }
    public void solve(int arr[],List<List<Integer>>ans,List<Integer>path,int index,int n,int k){
        if(path.size()==k){
            ans.add(new ArrayList(path));   
            return;
        }
        if(index==n)
        return;
        //include
        path.add(arr[index]);
        solve(arr,ans,path,index+1,n,k);
        path.remove(path.size()-1);

        //exclude
        solve(arr,ans,path,index+1,n,k);
    }
}