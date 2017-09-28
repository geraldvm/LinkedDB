package sample;

import javafx.beans.property.SimpleObjectProperty;

public class Table {
    private SimpleObjectProperty a[];
    public Table(Object...values){
        this.a =new SimpleObjectProperty[values.length];
        for (int i=0;i<3;i++){
            SimpleObjectProperty x = new SimpleObjectProperty(values[i]);
            this.a[i]=x;
        }
    }

    public SimpleObjectProperty[] getA() {
        return this.a;
    }
}
