package stackWithMin.model;

public class NodeWithMin {

    public int value;
    public int min;

    public NodeWithMin(int value, int min) {
        this.value = value;
        this.min = min;
    }

    @Override
    public String toString() {
        return "NodeWithMin{" +
                "value=" + value +
                '}';
    }
}
