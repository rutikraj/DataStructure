package QueueViaStacks.model;

import java.util.Stack;

public class MyQueue<T> {
    Stack<T> stkNewest, stkOldest;

    public MyQueue(){
        stkNewest = new Stack<>();
        stkOldest = new Stack<>();
    }

    public void add(T data){
        stkNewest.push(data);
    }

    public T peek(){
        shiftStk();
        return stkOldest.peek();
    }

    public T remove(){
        shiftStk();
        return stkOldest.pop();
    }

    private void shiftStk() {
        if(stkOldest.empty()){
            while(!stkNewest.empty()) {
                T data = stkNewest.pop();
                stkOldest.push(data);
            }
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "stkNewest=" + stkNewest +
                ", stkOldest=" + stkOldest +
                '}';
    }
}
