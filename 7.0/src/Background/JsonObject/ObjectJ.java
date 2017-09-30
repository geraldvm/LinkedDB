package Background.JsonObject;

import Background.Documents.Attribute;
import Background.LinkedList.SimpleList.SimpleList;

/**
 * Clase ObjectJ
 *Lista de Objetos
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class ObjectJ {
    /**
     * Lista de atributos
     * Lista con los valores del Objeto "ROW"
     */
    private SimpleList<Attribute> attributeList;
    private SimpleList<Objeto> row;

    /**
     * Constructor
     * @param attributeList: lista de atributos
     * @param row: fila de Objetos
     */
    public ObjectJ(SimpleList<Attribute> attributeList, SimpleList<Objeto> row){
        this.attributeList=attributeList;
        this.row=row;
    }

    /**
     * Constructor de 1 parametro
     * @param attributeList: Lista de atributos
     */
    public ObjectJ(SimpleList<Attribute> attributeList){
        this.attributeList=attributeList;
        this.row=new SimpleList<>();
    }

    /**
     * Funcion Booleana
     * @param attribute: Atributo
     * @param value: Valor del Objeto
     * @return Si los tipos coinciden
     */
    private boolean isSameType(Attribute attribute,Object value){
        String x = value.getClass().getSimpleName();
        switch (x){
            case "Integer":
                return attribute.getType()=="int";
            case "Double":
                return attribute.getType()=="float";
            case "String":
                return attribute.getType()=="String";
            case "LocalDateTime":
                return attribute.getType()=="date";
        }return false;
    }
    /**
     * Getter
     * @return Retorna la fila de Objetos
     */
    public SimpleList<Objeto> getRow() {
        return this.row;
    }

    /**
     * Crear Fila de Objetos
     * @param value valor para cada columna
     */
    public void createRow (Object...value){

        for (int i=0;i<this.attributeList.length();++i){
            if(isSameType(this.attributeList.find(i).getItem(),value[i])){
                Objeto x = new Objeto(this.attributeList.find(i).getItem().getName(),
                        this.attributeList.find(i).getItem().getType(),
                        this.attributeList.find(i).getItem().isPrimary(),
                        value[i]);
                this.row.addLast(x);
            }
            else {
                Objeto x = new Objeto(this.attributeList.find(i).getItem().getName(),
                        this.attributeList.find(i).getItem().getType(),
                        this.attributeList.find(i).getItem().isPrimary(),
                        this.attributeList.find(i).getItem().getValue());
                this.row.addLast(x);
            }
        }
    }

    /**
     * Crear Fila de Objetos
     * @param attribute: Nombre del atributo
     * @param value : valor de la columna
     */
    public void createRow (String attribute,Object value){

        for (int i=0;i<this.attributeList.length();++i){
            if (this.attributeList.find(i).getItem().getName()==attribute){
                Attribute n = this.attributeList.findItem(i);
                if(isSameType(n,value)){
                    Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),value);
                    this.row.addLast(x);
                }
                else{
                    Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),n.getValue());
                    this.row.addLast(x);
                }
            }

        }
    }

    /**
     * Metodo para cargar Objetos guardados en memoria
     * @param attribute : nombre del atributo
     * @param value : valor del atributo
     */
    public void createRowFromJson(String attribute,Object value) {
        this.createRowFromJson_aux(attribute,value);
    }
    private void createRowFromJson_aux (String attribute,Object value){

        for (int i=0;i<this.attributeList.length();++i){
            if (this.attributeList.findItem(i).getName().equals(attribute)){
                Attribute n = this.attributeList.find(i).getItem();
                Objeto x = new Objeto(attribute,n.getType(), n.isPrimary(),value);
                this.row.addLast(x);
            }
        }
    }


}
