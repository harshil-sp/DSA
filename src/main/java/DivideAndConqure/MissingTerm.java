package DivideAndConqure;

import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MissingTerm {
    private static void finder(int[] arr, int start, int end, int diff, List<Integer> ls) {
//        System.out.println("start : "+start+" end : "+end);
        if(end-start == 1) {
            if(arr[end]-arr[start] == diff) {
                return;
            }
//            System.out.println("Adding...");
            int curDiff = arr[end]-arr[start];
            for(int i=diff; i<curDiff; i+=diff) {
//                System.out.println(arr[start]+i);
                ls.add(arr[start]+i);
            }
        }

        int middle = (start+end)/2;
        if(middle != start && middle != end) {
            finder(arr, start, middle, diff, ls);
            finder(arr, middle, end, diff, ls);
        }
    }

    public static void main(String[] args) throws IOException {
        InterfaceMaker Interface = new InterfaceMaker("DivideAndConqure//Inputs");
        BufferedReader scanner = new BufferedReader(Interface.getFile("MissingTerm.txt"));
        int TotalTestCases = Integer.parseInt(scanner.readLine());

        while (TotalTestCases > 0) {

            // taking input for this test case...
            int difference = Integer.parseInt(scanner.readLine());
            String[] input = scanner.readLine().split(" ");
            int[] main_inputs = new int[input.length];
            for(int i=0; i<input.length; i++) {
                main_inputs[i] = Integer.parseInt(input[i]);
            }
            // all inputs have been taken and converted to required format...

            // actual solutions starts...
            List<Integer> missingTermList = new ArrayList<>();
            finder(main_inputs, 0, main_inputs.length-1, difference, missingTermList);
            System.out.println("Missing terms are : "+missingTermList);

            TotalTestCases -= 1;
        }
    }
}
