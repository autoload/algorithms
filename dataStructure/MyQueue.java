import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack;
    Stack<Integer> outStack;


    /** Initialize your data structure here. */
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.add(x);

    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 从 popStack 取出元素
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!inStack.isEmpty()) {
            outStack.add(inStack.pop());
        }
        return outStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        // 从 popStack 取出元素
        if (!outStack.isEmpty()) {
            return outStack.peek();
        }
        // 走到这里是因为 popStack 为空，此时需要将 pushStack 里的所有元素依次放入 popStack
        while (!inStack.isEmpty()) {
            outStack.add(inStack.pop());
        }
        return outStack.peek();

    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.empty() && outStack.empty();
    }
}