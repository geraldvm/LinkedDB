import Background.Start;

public class test {
    public static void main(String[] args) {
        /*Object z;
        z=0;
        LocalDateTime fecha = LocalDateTime.of(2012,02,5,3,25);
        System.out.println(fecha);
        z=fecha;
        System.out.println(z.getClass().getSimpleName());*/

        Start z = new Start();
        z.newStore("StoreA");
        z.newStore("StoreB");
        z.newStore("StoreC");

        System.out.println(z.getAmountStore());

    }
}
