class MinStack {

    private Stack<Integer> myStack;
    private Stack<Integer> myStack2;

    public MinStack() {

        myStack = new Stack<>();
        myStack2 = new Stack<>();
    }
    //if stack is empty don't allow pop, top, getMin
    public void push(int val) {
        myStack.push(val);
        if (myStack2.isEmpty()) {
            myStack2.push(val);
        } else {
            myStack2.push(Math.min(val, myStack2.peek()));
        }
    }
    
    public void pop() {
        if((!myStack.isEmpty()) && (!myStack2.isEmpty())) {
            myStack.pop();
            myStack2.pop();
        }
    }
    
    public int top() {
        int myTop = 0;
        if (!myStack.isEmpty()) {
            myTop = myStack.peek();
        }
        return myTop;
    }
    
    public int getMin() {
        return myStack2.peek();
    }

    /*
    brute force: check for minimum element as we add to the stack?
    
    Two stacks: one for maintaining elements, one for getting minimum
    Stack1: add 1
    Stack2: add min(1, stack2.currentTopElement)
    */
}
