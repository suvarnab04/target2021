package microsoftOA;

public class MinDeletionCost {
    public int minCost(String s, int[] cost) {
        char[] ch = s.toCharArray();
        int sum =0;
        for(int i=1;i< ch.length;i++){
            char prev = ch[i-1];
            char curr = ch[i];
            char next = (i+1) < ch.length ? ch[i+1] : '\0';
            if(prev==curr && curr == next){
                sum += cost[i];
                i=i+1;
            }else if(prev==curr){
                if(cost[i-1] < cost[i]){
                    sum+= cost[i-1];
                }else{
                    sum+= cost[i];
                }
            }
        }
        return sum;
    }
    public int min2(String s, int[] cost)
    {
        int result = 0;
        int left = 0;
        int right = 0;
        while(right < s.length()){
            int alph_cost = cost[right];
            int accum = cost[right];
            while(right+1 < s.length() && s.charAt(right) == s.charAt(right+1)){
                alph_cost  = Math.max(cost[++right], alph_cost);
                accum += cost[right];
            }
            if(right!=left){
                result += (accum - alph_cost);
            }
            right++;
            left = right;
        }
        return result;
    }
}
