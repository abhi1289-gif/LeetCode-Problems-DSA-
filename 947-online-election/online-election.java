class TopVotedCandidate {

    int leading[];
    int time[];

    public TopVotedCandidate(int[] persons, int[] times) {
        leading = new int[persons.length];
        HashMap<Integer, Integer> mapp = new HashMap<>();

        leading[0] = persons[0];
        mapp.put(persons[0], 1);

        int maxx = persons[0];

        for(int i=1; i<persons.length; i++){
            int num = persons[i];
            mapp.put(num, mapp.getOrDefault(num, 0)+1);

            if(mapp.get(maxx) <= mapp.get(num)){
                maxx = num;
            }

            leading[i] = maxx;
        }

        time = times;
    }
    
    public int q(int t) {
        int i = 0;
        int j = time.length-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(time[mid] > t){
                j = mid-1;
            }
            else{
                ans = mid;
                i = mid+1;
            }
        }

        return leading[ans];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */