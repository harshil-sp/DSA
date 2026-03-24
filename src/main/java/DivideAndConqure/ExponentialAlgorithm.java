package DivideAndConqure;

public class ExponentialAlgorithm {
    public static void main(String[] args) {
        System.out.println("2 raise to 10 is: " + exponential(2, 10));

    }

    public static int exponential(int multiplier, int exponent) {
        int answer = 1;

        while (exponent != 0) {
            if (exponent % 2 == 0) {
                multiplier *= multiplier;
                exponent /= 2;
            } else {
                answer *= multiplier;
                exponent -= 1;
            }
        }

        return answer;
    }
}
