class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> o = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        int sum = 0;

        for(int num: nums){
            int a = num%3;
            sum += num;

            if(a == 1) o.add(num);
            else if (a == 2) t.add(num);
        }

        Collections.sort(o);
        Collections.sort(t);
        
        int a = sum%3;

        if(a == 0) return sum;
        else if(a == 1){
            if(t.size() > 1 && o.size()>0){
                int m = Math.min(o.get(0), t.get(0)+t.get(1));
                sum -= m;
                return sum;
            }
            else if(t.size() > 1){
                sum -= (t.get(0)+t.get(1));
                return sum;
            }
            else if (o.size() > 0){
                sum -= o.get(0);
                return sum;
            }
            return 0;
        }
        else{
            if(t.size() > 0 && o.size()>1){
                int m = Math.min(t.get(0), o.get(0)+o.get(1));
                sum -= m;
                return sum;
            }
            else if(t.size() > 0){
                sum -= t.get(0);
                return sum;
            }
            else if(o.size()>1){
                sum -= (o.get(0)+o.get(1));
                return sum;
            }
            return 0;
        }
    }
}