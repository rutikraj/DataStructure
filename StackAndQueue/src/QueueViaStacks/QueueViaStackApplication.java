package QueueViaStacks;

import QueueViaStacks.model.MyQueue;

import java.util.Scanner;

public class QueueViaStackApplication {

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter below choice \n 1) Push() \n 2) Pop() \n 3)Exit");
            int choice = scanner.nextInt();
            if (choice == 3)
                break;
            switch (choice) {
                case 1:
                    System.out.println("Enter the element to be inserted");
                    int value = scanner.nextInt();
                    myQueue.add(value);
                    break;
                case 2:
                    int temp = myQueue.remove();
                    System.out.println("Poped element is : " + temp);
                    break;
                default:
                    break;
            }
            System.out.println("Queue is : " + myQueue);
        }
        System.out.println("Queue is : " + myQueue);
        System.out.println("peek element is  : " + myQueue.peek());
    }


}
