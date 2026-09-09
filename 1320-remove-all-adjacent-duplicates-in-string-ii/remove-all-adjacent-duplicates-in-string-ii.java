class Solution {
    static class Pair{
        char ch;
        int count;
        Pair(char ch,int count){
            this.ch=ch;
            this.count=count;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(c,1));
                continue;
            }
            if(st.peek().ch==c){
                if(st.peek().count<k-1){
                    Pair p=st.pop();
                    st.push(new Pair(c,p.count+1));
                    continue;
                }
                st.pop();
            }else{
                st.push(new Pair(c,1));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            Pair p=st.pop();
            while(p.count-- >0){
                sb.append(p.ch);
            }
        }
        return sb.reverse().toString();
    }
}