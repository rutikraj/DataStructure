package model;

import java.util.Stack;

public class StackWithMin2 extends Stack<Integer> {

    private Stack<Integer> min;

    public StackWithMin2(){
        min = new Stack<>();
    }

    public void push(int value){
        if(value <= getMinValue()){
            min.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int val = super.pop();
        if(val == getMinValue()) {
            min.pop();
        }
        return val;
    }

    public Integer getMinValue(){
        if(min.empty())
            return Integer.MAX_VALUE;
        return min.peek();
    }
}
