class Solution {

    int ans = Integer.MAX_VALUE;
    HashMap<List<Integer>, Integer> memo = new HashMap<>();

    public void travel(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int num){

        if(memo.containsKey(needs) && memo.get(needs) <= num) return;

        memo.put(new ArrayList<>(needs), num);

        int a = num;
        for(int i=0; i<needs.size(); i++){
            a +=  needs.get(i)*price.get(i);
        }
        ans = Math.min(ans, a);
        
        boolean anyone = false;
        for(int i=0; i<special.size(); i++){
            boolean possible = true;

            for(int j=0; j<needs.size(); j++){
                int temp = needs.get(j) - special.get(i).get(j);
                needs.set(j, temp);
                if(temp<0) possible = false;
            }

            if(possible){
                travel(price, special, needs, num+special.get(i).get(price.size()));
                anyone = true;
            }

            for(int j=0; j<needs.size(); j++){
                int temp = needs.get(j) + special.get(i).get(j);
                needs.set(j, temp);
            }
        }

        if(!anyone){
            for(int i=0; i<needs.size(); i++){
                num +=  needs.get(i)*price.get(i);
            }
            ans = Math.min(ans, num);
        }
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        travel(price, special, needs, 0);
        return ans;
    }
}