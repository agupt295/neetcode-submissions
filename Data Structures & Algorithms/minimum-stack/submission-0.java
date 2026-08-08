class MinStack {
    List<Integer> list;
    Queue<Integer> minHeap;

    public MinStack() {
        list = new ArrayList<>();
        minHeap = new PriorityQueue<>();
    }
    
    public void push(int val) {
        list.add(val);
        minHeap.add(val);
    }
    
    public void pop() {
        minHeap.remove(this.top());
        list.remove(list.size()-1);
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return minHeap.peek();
    }
}
