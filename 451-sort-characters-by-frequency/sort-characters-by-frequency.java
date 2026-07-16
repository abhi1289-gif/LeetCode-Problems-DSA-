class Solution {

    public class Pair{
        char ch;
        int num;

        Pair(char ch, int num){
            this.ch = ch;
            this.num = num;
        }
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> mapp = new HashMap<>();

        for(char ch: s.toCharArray()){
            mapp.put(ch, mapp.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((b, a)->a.num-b.num);

        for(char key: mapp.keySet()){
            pq.add(new Pair(key, mapp.get(key)));
        }

        StringBuilder ans = new StringBuilder();

        while(pq.size() > 0){
            Pair curr = pq.poll();
            int a = curr.num;
            while(a > 0){
                a--;
                ans.append(curr.ch);
            }
        }

        return ans.toString();
    }
}