import java.util.Random;

class Randomize {
    public static void main(String[] args) {
        MyRandom r = new MyRandom();
        for(int i = 0; i <= 200; i++) {
            System.out.println(r.nextDouble(2.0, 4.0));
        }

        for(int i = 0; i <= 200; i++) {
            System.out.println(r.nextInt(5, 9));
        }
    }
}

class MyRandom {
    Random r = new Random();

    public int nextInt(int min, int max) {
        max += 1;
        return r.nextInt(max - min) + min;
    }

    public Double nextDouble(double min, double max) {
        return (r.nextDouble() * (max - min)) + min;
    }
}