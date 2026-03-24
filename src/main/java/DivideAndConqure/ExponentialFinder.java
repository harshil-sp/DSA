package DivideAndConqure;

import Helper.InterfaceMaker;

import java.io.BufferedReader;
import java.io.IOException;

public class ExponentialFinder {
    public static void main(String[] args) throws IOException {
        InterfaceMaker ifm = new InterfaceMaker("DivideAndConqure//Inputs");
        BufferedReader scanner = new BufferedReader(ifm.getFile("Exponential.txt"));

        int T = Integer.parseInt(scanner.readLine());
        while (T > 0) {
            String[] input = scanner.readLine().split(" ");
            int B = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            System.out.println("B : "+B+" E : "+E);

            int ans = 1;
            while (E > 0) {
                if(E%2 != 0) {
                    ans *= B;
                    E --;
                }

                if(E > 0) {
                    B *= B;
                    E /= 2;
                }
            }

            System.out.println(ans+" "+Math.pow((double)B,(double) E));

            T --;
        }
    }
}
