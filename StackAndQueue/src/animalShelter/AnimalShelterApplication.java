package animalShelter;

import animalShelter.impl.AnimalQueue;
import animalShelter.model.Animal;
import animalShelter.model.Cat;
import animalShelter.model.Dog;

import java.util.Scanner;

//3.6
public class AnimalShelterApplication {

    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        AnimalQueue animalQueue = new AnimalQueue();
        while (true) {
            System.out.println("Enter below choice \n 1) enqueueCat() \n 2)enqueueDog \n 3) dequeueAny() \n " +
                    "4)dequeueCat \n 5)dequeueDog \n 6)Exit");
            int choice = scanner.nextInt();

            if (choice == 6)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    scanner.nextLine();
                    String value = scanner.nextLine();
                    Cat cat = new Cat(value);
                    animalQueue.enqueue(cat);
                    break;
                case 2:
                    System.out.println("Enter the element to be inserted");
                    scanner.nextLine();
                    String dogValue = scanner.nextLine();
                    Dog dog = new Dog(dogValue);
                    animalQueue.enqueue(dog);
                    break;
                case 3:
                    animalQueue.dequeueAny();
                    break;
                case 4:
                    animalQueue.dequeCat();
                    break;
                case 5:
                    animalQueue.dequeDog();
                    break;
                default:
                    break;
            }

            System.out.println("Animal queue is " + animalQueue);
        }
        System.out.println("Final Animal Queue : " + animalQueue);
    }
}
