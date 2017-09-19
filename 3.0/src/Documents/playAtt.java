package Documents;

import java.time.LocalDateTime;

public class playAtt {
    public static void main(String[] args) {
        Attribute a = new Attribute("ID",4,true,false, 2017,02,1,8,25);
        a.show();

        LocalDateTime fecha = LocalDateTime.of(2012,02,5,3,25);
        System.out.println(a.getValue());
       // a.same(fecha);
       // a.isSameType(2);
    }
}
