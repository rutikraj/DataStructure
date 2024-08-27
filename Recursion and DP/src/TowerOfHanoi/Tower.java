package TowerOfHanoi;

import java.util.Stack;

public class Tower {

    private Stack<Integer> stack;
    public Tower(){
        stack = new Stack<>();
    }

    public void add(Integer ele){
        if(!stack.empty() && stack.peek() < ele){
            System.out.println("Unsupported");
        }else{
            stack.push(ele);
        }
    }

    public Integer pop(){
        return stack.pop();
    }

    public Stack<Integer> getStack(){
        return stack;
    }
}
