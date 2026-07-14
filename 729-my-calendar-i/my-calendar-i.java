class MyCalendar {

    List<int[]> nums;

    public MyCalendar() {
        nums = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        int i = 0;
        int j = nums.size()-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums.get(mid)[0] < startTime){
                i = mid+1;
            }
            else j = mid-1;
        }
        
        if(i > 0 && nums.get(i-1)[1] > startTime){
            return false;
        }
        
        if(i <nums.size() && nums.get(i)[0] < endTime){
            return false;
        }

        nums.add(i, new int[]{startTime, endTime});

        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */