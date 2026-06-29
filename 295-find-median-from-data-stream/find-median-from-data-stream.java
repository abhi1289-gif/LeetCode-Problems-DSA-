class MedianFinder {

    PriorityQueue<Integer> minn = new PriorityQueue<>((a, b)-> a-b);
    PriorityQueue<Integer> maxx = new PriorityQueue<>((a, b)-> b-a);

    public MedianFinder() {
        minn.clear();
        maxx.clear();
    }
    
    public void addNum(int num) {
        if(maxx.size()==0 || num<=maxx.peek()){
            maxx.add(num);
        }
        else{
            minn.add(num);
        }

        if(maxx.size() - minn.size() > 1){
            minn.add(maxx.poll());
        }
        else if(minn.size() - maxx.size() > 0){
            maxx.add(minn.poll());
        }
    }
    
    public double findMedian() {
        if(maxx.size() == minn.size()){
            return (double)(maxx.peek()+minn.peek())/2.0;
        }

        return (double)maxx.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */