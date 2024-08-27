package TowerOfHanoi;

public class TowerOfHanoiApp {

    public static void main(String []args){
        Tower[] towers = new Tower[3];
        for(int i = 0; i < 3; i++){
            towers[i] = new Tower();
        }

        for(int i = 5; i > 0; i--){
            towers[0].add(i);
        }
        System.out.println("Before moving plates : ");
        for(int i = 0; i < 3; i++) {
            System.out.println("Tower: " + i);
            printStack(towers[i]);
        }

        System.out.println("After moving plates : ");
        moveDisks(towers[0].getStack().size(), towers[0], towers[1], towers[2]);
        for(int i = 0; i < 3; i++) {
            System.out.println("Tower: " + i);
            printStack(towers[i]);
        }
    }

    private static void moveDisks(int n, Tower source, Tower temp, Tower dest) {
        if(n > 0){
            moveDisks(n-1, source, dest, temp);
            moveTop(source, dest);
            moveDisks(n-1, temp, source, dest);

        }
    }

    private static void moveTop(Tower source, Tower dest) {
        if(!source.getStack().empty()){
            int element = source.pop();
            dest.add(element);
        }
    }

    private static void printStack(Tower tower) {
        for(int i = tower.getStack().size()-1 ; i >= 0; i--){
            System.out.println(tower.getStack().get(i));
        }
    }
}
