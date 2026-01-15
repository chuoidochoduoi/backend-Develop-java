package Session5;

public class Bai2S5 {

    public static void main(String[] args) {

        int times = 1_000_000;

        long start = System.currentTimeMillis();
        String s = "Hello";
        for (int i = 0; i < times; i++) {
            s += " World";
        }
        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < times; i++) {
            sb.append(" World");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < times; i++) {
            sbf.append(" World");
        }
        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}

