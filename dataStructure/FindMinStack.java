import java.util.Stack;
import java.util.Arrays;

public class FindMinStack {
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   
        minStack.pop();
        minStack.top();      
        minStack.getMin();
    }
}