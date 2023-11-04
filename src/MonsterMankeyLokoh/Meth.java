package MonsterMankeyLokoh;

public class Meth {
    public static final float PI = 3.1415926535F;
    public Meth(){}
    public static int Sum(int ...numbers) {
        int sum = 0;
        for(int n : numbers) {
            sum += n;
        }
        return sum;
    }
    public static double Sum(double ...numbers) {
        double sum = 0;
        for(double n : numbers) {
            sum += n;
        }
        return sum;
    }
    public static float Sum(float ...numbers) {
        float sum = 0;
        for(float n : numbers) {
            sum += n;
        }
        return sum;
    }

    public static int Sub(int ...numbers) {
        int sub = numbers[0];
        for(int n : numbers) {
            if(n == numbers[0]) continue;
            sub -= n;
        }
        return sub;
    }
    public static double Sub(double ...numbers) {
        double sub = numbers[0];
        for(double n : numbers) {
            if(n == numbers[0]) continue;
            sub -= n;
        }
        return sub;
    }
    public static float Sub(float ...numbers) {
        float sub = numbers[0];
        for(float n : numbers) {
            if(n == numbers[0]) continue;
            sub -= n;
        }
        return sub;
    }

    public static int Div(int ...numbers) {
        int div = numbers[0];
        for(int n : numbers) {
            if(n == numbers[0]) continue;
            div /= n;
        }
        return div;
    }
    public static double Div(double ...numbers) {
        double div = numbers[0];
        for(double n : numbers) {
            if(n == numbers[0]) continue;
            div /= n;
        }
        return div;
    }
    public static float Div(float ...numbers) {
        float div = numbers[0];
        for(float n : numbers) {
            if(n == numbers[0]) continue;
            div /= n;
        }
        return div;
    }

    public static double Pow(double base, double exponent) {
        if (exponent == 0) {
            return 1; // Anything raised to the power of 0 is 1
        } else {
            return base * Pow(base, exponent - 1);
        }
    }

    public static long Pow(long base, long exponent) {
        if (exponent == 0) {
            return 1; // Anything raised to the power of 0 is 1
        } else {
            return base * Pow(base, exponent - 1);
        }
    }

    public static float Pow(float base, float exponent) {
        if (exponent == 0) {
            return 1; // Anything raised to the power of 0 is 1
        } else {
            return base * Pow(base, exponent - 1);
        }
    }

    // Newton-Raphson method
    public long Sqrt(long value) {
        return __Sqrt__(value, value);
    }
    public double Sqrt(double value) {
        return __Sqrt__((long) value, (long) value);
    }
    public int Sqrt(int value) {
        return (int) __Sqrt__(value, value);
    }
    public float Sqrt(float value) {
        return __Sqrt__((long) value, (long) value);
    }
    public long __Sqrt__(long value, long guess) {
        long nextGuess = (long) (0.5 * (guess + value / guess));
        if (this.Abs(nextGuess - guess) < 1e-9) return nextGuess;
        return this.__Sqrt__(value, nextGuess);
    }

    public static int Abs(int value){
        if(value < 0) return value * -1;
        return value;
    }

    public static long Abs(long value){
        if(value < 0) return value * -1;
        return value;
    }

    public static float Abs(float value){
        if(value < 0) return value * -1;
        return value;
    }

    public static double Abs(double value){
        if(value < 0) return value * -1;
        return value;
    }

    public static long Factorial(long v) {
        if(v == 0) return 1;
        else return v * Factorial((v-1));
    }

    public static double Factorial(double v) {
        if(v == 0) return 1;
        else return v * Factorial((v-1));
    }

    public static int Factorial(int v) {
        if(v == 0) return 1;
        else return v * Factorial((v-1));
    }

    public static float Factorial(float v) {
        if(v == 0) return 1;
        else return v * Factorial((v-1));
    }
}
