package animalShelter.impl;

import animalShelter.model.Animal;
import animalShelter.model.Cat;
import animalShelter.model.Dog;

import java.util.LinkedList;

public class AnimalQueue {
    LinkedList<Cat> catList = new LinkedList<>();
    LinkedList<Dog> dogList = new LinkedList<>();
    private static int order = 0;

    public void enqueue(Animal animal){
        animal.setOrder(order);
        order++;
        if(animal instanceof Cat)
            catList.addLast((Cat) animal);
        else if(animal instanceof Dog)
            dogList.addLast((Dog) animal);
    }

    public Animal dequeueAny(){
        if(catList.isEmpty())
            return dequeDog();
        if(dogList.isEmpty())
            return dequeCat();
        if(catList.peek().isOlderThanAnimal(dogList.peek()))
            return dequeCat();
        else
            return dequeDog();
    }

    public Dog dequeDog(){
        return dogList.pollFirst();
    }

    public Cat dequeCat(){
        return catList.pollFirst();
    }

    @Override
    public String toString() {
        return "AnimalQueue{" +
                "catList=" + catList +
                ", dogList=" + dogList +
                '}';
    }
}
