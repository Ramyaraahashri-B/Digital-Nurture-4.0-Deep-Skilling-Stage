public class Main {

    public static double forecast(double value, double growthRate, int years) {
        if (years == 0) {
            return value;
        }
        return forecast(value * (1 + growthRate), growthRate, years - 1);
    }

    public static double forecastMemo(double value, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return value;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = forecastMemo(value * (1 + growthRate), growthRate, years - 1, memo);
        return memo[years];
    }

    public static void main(String[] args) {
        double initialValue = 1000;   
        double growthRate = 0.10;       
        int years = 5;

        double result = forecast(initialValue, growthRate, years);
        System.out.println("Future Value (recursive): ₹" + result);

        double[] memo = new double[years + 1];
        double resultMemo = forecastMemo(initialValue, growthRate, years, memo);
        System.out.println("Future Value (memoized): ₹" + resultMemo);
    }
}
