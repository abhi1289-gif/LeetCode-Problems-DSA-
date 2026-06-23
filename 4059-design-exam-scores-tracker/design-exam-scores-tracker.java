class ExamTracker {

    List<Integer> tim;
    List<Long> pre;

    public ExamTracker() {
        tim = new ArrayList<>();
        pre = new ArrayList<>();
    }
    
    public void record(int time, int score) {
        tim.add(time);
        if(pre.size() > 0) pre.add(pre.get(pre.size()-1)+(long)score);
        else pre.add((long)score);
    }

    public long justless(int n){
        int i = 0;
        int j = tim.size()-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(tim.get(mid) > n){
                j = mid-1;
            }
            else{
                ans = mid;
                i = mid+1;
            }
        }

        if(ans != -1 && tim.get(ans) == n) ans -= 1;

        return (ans == -1)? 0: pre.get(ans);
    }

    public long lessOrEqual(int n){
        int i = 0;
        int j = tim.size()-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(tim.get(mid) == n){
                ans = mid;
                break;
            }
            else if(tim.get(mid) < n){
                ans = mid;
                i = mid+1;
            }
            else{
                j = mid-1;
            }

        }

        return (ans == -1)? 0: pre.get(ans);
    }
    
    public long totalScore(int startTime, int endTime) {
        long prev = justless(startTime);
        long next = lessOrEqual(endTime);

        return next - prev;
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */