package stackWithMin;

import stackWithMin.model.StackWithMin2;

import java.util.Scanner;

public class StackWithMinApplication2 {

    public static void main(String []args){
        StackWithMin2 stk = new StackWithMin2();
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Enter below choice \n 1) Push() \n 2) Pop() \n 3)Exit");
            int choice = scanner.nextInt();
            if(choice == 3)
                break;
            switch (choice){
                case 1 : System.out.println("Enter the element to be inserted");
                         int value = scanner.nextInt();
                         stk.push(value);
                         break;
                case 2:
                        int temp = stk.pop();
                        System.out.println("Poped element is : "+ temp);
                        break;
                default: break;
            }
            System.out.println("Stack is : "+ stk);
        }
        System.out.println("Stack is : "+ stk);
        System.out.println("Min element is  : "  +stk.getMinValue());
    }
}
