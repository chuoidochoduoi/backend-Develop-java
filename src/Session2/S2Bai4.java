package Session2;

public class S2Bai4 {


    public void trigle(int a, int b, int c) {

        if(a +b > c && a +c > b && b +c > a && b +c > c){

            if (a== b && b == c){
                System.out.println("tam giac deu");

            } else if (a == b && b == c) {
                System.out.println("tam giac can");

            } else if (Math.pow(a,2) == Math.pow(b,2)+Math.pow(c,2)
                    && Math.pow(b,2) == Math.pow(a,2)+Math.pow(c,2)
                    && Math.pow(c,2) == Math.pow(b,2)+Math.pow(a,2)) {
                System.out.println("tam giac vuong");
            }else {
                System.out.println("tam giac thuong");
            }

        }else {
            System.out.println("not tam giac");
        }
    }
}
