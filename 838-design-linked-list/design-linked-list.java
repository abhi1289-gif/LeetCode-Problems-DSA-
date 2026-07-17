class MyLinkedList {

    List<Integer> nums;

    public MyLinkedList() {
        nums = new ArrayList<>();
    }
    
    public int get(int index) {
        if(index >= nums.size()) return -1;
        return nums.get(index);
    }
    
    public void addAtHead(int val) {
        nums.add(0, val);
    }
    
    public void addAtTail(int val) {
        nums.add(val);
    }
    
    public void addAtIndex(int index, int val) {
        nums.add(index, val);
    }
    
    public void deleteAtIndex(int index) {
        if(index < nums.size() && index >= 0) nums.remove(index);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */