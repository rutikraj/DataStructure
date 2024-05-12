package sort;

import java.util.Scanner;
import java.util.Stack;

public class SortStackApplication {

    public static void main(String []args){
        Stack<Integer> stack = new Stack<>();
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
                    stack.push(value);
                    break;
                case 2:
                    int temp = stack.pop();
                    System.out.println("Poped element is : " + temp);
                    break;
                default:
                    break;
            }
            System.out.println("Stack is : " + stack);
        }
        sorted(stack);
        System.out.println("Stack is : " + stack);
    }

    private static void sorted(Stack<Integer> stack) {
        Stack<Integer> temp =  new Stack<>();

        while(!stack.empty()){
            Integer value = stack.pop();
            while(!temp.empty() && temp.peek() > value){
                stack.push(temp.pop());
            }
            temp.push(value);
        }

        while(!temp.empty()){
            stack.push(temp.pop());
        }
    }
}
