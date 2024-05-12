package animalShelter.model;

public abstract class Animal {
    private int order;
    private String name;

    public Animal(String name){
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOlderThanAnimal(Animal animal){
        return this.order < animal.getOrder();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "order=" + order +
                ", name='" + name + '\'' +
                '}';
    }
}
