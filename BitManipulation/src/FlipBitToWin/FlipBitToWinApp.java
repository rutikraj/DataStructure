package FlipBitToWin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlipBitToWinApp {
    public static void main(String []args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = scanner.nextInt();

        String str = getBinaryValue(num);
        System.out.println("Binary reprensentation " + str);
        int ct = longestSequence(num);
        System.out.println("Max len " + ct);
        ct = flipBit(num);
        System.out.println("Max len method2 = " + ct);
    }

    private static int flipBit(int num) {
        if(~num == 0)
            return Integer.BYTES * 8;
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;
        while (num != 0){
            if((num & 1) == 1){
                currentLength++;
            } else if ((num & 0) == 0) {
                previousLength = (num & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(maxLength, currentLength + previousLength + 1);
            num = num >>> 1;
        }
        return maxLength;
    }

    private static int longestSequence(int num) {
        if(~num == 0)
            return Integer.BYTES * 8;
        List<Integer> alternativeSeq = getAlternativeSequence(num);
        return findLongestSequence(alternativeSeq);
    }

    private static int findLongestSequence(List<Integer> alternativeSeq) {
        int maxSeq = 1;
        for(int i = 0; i < alternativeSeq.size(); i += 2){
            int oneSeqRight = i == 0 ? 0 : alternativeSeq.get(i-1);
            int oneSeqLeft = i+1 >= alternativeSeq.size() ? 0 : alternativeSeq.get(i+1);
            int zeroSeq = alternativeSeq.get(i);
            int thirdSeq = 0;
            if(zeroSeq == 1){
                thirdSeq = oneSeqLeft + oneSeqRight + 1;
            }
            else if(zeroSeq > 1){
                thirdSeq = Math.max(oneSeqRight, oneSeqLeft) + 1;
            }else{
                thirdSeq = Math.max(oneSeqRight, oneSeqLeft);
            }

            maxSeq = Math.max(maxSeq, thirdSeq);
        }
        return maxSeq;
    }

    private static List<Integer> getAlternativeSequence(int num) {
        List<Integer> lst = new ArrayList<>();
        int counter = 0;
        int searchFor = 0;
        for(int i = 0; i < Integer.BYTES * 8; i++){
            if((num & 1) != searchFor){
                lst.add(counter);
                searchFor = num & 1; //change 1 to 0 or 0 to 1
                counter = 0;
            }
            counter++;
            num = num >>> 1;
        }
        lst.add(counter);
        return lst;
    }

    private static String getBinaryValue(int num) {
        if(num == 0){
            return "";
        }
        String str = getBinaryValue(num/2);
        int rem = num % 2;
        return str + rem;
    }
}