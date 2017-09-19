import java.time.LocalDateTime;

public class test {
    public static void main(String[] args) {
        Object z;
        z=0;
        LocalDateTime fecha = LocalDateTime.of(2012,02,5,3,25);
        System.out.println(fecha);
        z=fecha;
        System.out.println(z.getClass().getSimpleName());
    }
}
