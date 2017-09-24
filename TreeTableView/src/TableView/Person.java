package TableView;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty nameProperty;
    private SimpleStringProperty emailProperty;
    private SimpleIntegerProperty ageProperty;

    public Person(String name, String email, int age){
        this.nameProperty=new SimpleStringProperty(name);
        this.emailProperty=new SimpleStringProperty(email);
        this.ageProperty=new SimpleIntegerProperty(age);
    }

    public SimpleIntegerProperty getAgeProperty() {
        return this.ageProperty;
    }

    public SimpleStringProperty getEmailProperty() {
        return this.emailProperty;
    }



    public SimpleStringProperty getNameProperty() {
        return this.nameProperty;
    }

    public void setNameProperty(String name) {
        this.nameProperty.set(name);
    }
}
