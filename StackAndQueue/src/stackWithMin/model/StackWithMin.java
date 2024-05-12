package stackWithMin.model;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin> {

    public void push(int value){
        int minValue = min(value);
        NodeWithMin node = new NodeWithMin(value, minValue);
        super.push(node);

    }

    public int min(int value) {
        if(this.empty()){
            return value;
        }else{
            return peek().min < value ? peek().min : value;
        }
    }

}
