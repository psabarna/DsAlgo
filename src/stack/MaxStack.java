package stack;

import java.util.Stack;

/*
Given a Stack, keep track of the maximum value in it. The maximum value may be the top element of the stack,
but once a new element is pushed or an element is popped from the stack, the maximum element will be now
from the rest of the elements.

Sol: Use two stacks, one to keep original values and another to keep max values corresponding to each element, i.e upto that element
We can use a Pair Object instead of two stack aswell
Space: O(n), Time: O(1)
*/
public class MaxStack {
  private static Stack<Integer> mainStack = new Stack<>();
  private static Stack<Integer> maxStack = new Stack<>();
  static void push(int val){
    mainStack.push(val);
    maxStack.push(Math.max(val, maxStack.isEmpty()? Integer.MIN_VALUE:maxStack.peek()));
  }
  static int pop(){
    if(!mainStack.isEmpty()) {
      maxStack.pop();
      return mainStack.pop();
    }
    return -1;
  }
  static int getMax(){
    return maxStack.peek();
  }

  public static void main(String[] args) {

  }

}
