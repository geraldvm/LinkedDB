package Background;

import Background.JsonStore.Store;
import Background.LinkedList.DoubleList.DoubleList;

/**
 * Clase Main
 * Contiene la lista de Stores
 * Es la clase de estructura principal
 * @author Gerald Valverde Mc kenzie
 * @version 7.0
 */
public class Main {
    /**
     * Atributos
     * Lista de Stores
     */
    private DoubleList<Store> storeList;

    /**
     * Constructor
     * Inicializa la lista
     */
    public Main(){
        this.storeList = new DoubleList<>();
    }

    /**
     * Getter
     * @return lista de Store
     */
    public DoubleList<Store> getStoreList() {
        return this.storeList;
    }

    /**
     * Setter
     * @param storeList Cambia lista de Store
     */
    public void setStoreList(DoubleList<Store> storeList) {
        this.storeList = storeList;
    }

    /**
     * Crea un nuevo Store
     * @param name Nombre del Store
     */
    public void newStore(String name){
        Store a = new Store(name);
        this.storeList.addLast(a);
    }

    /**
     * Getter
     * @param i posicion en la lista
     * @return Store
     */
    public Store getStore(int i){
        return this.storeList.find(i).getItem();
    }

    /**
     * Getter
     * @return tamaño de la lista
     */
    public int getAmountStore(){
        return this.storeList.length();
    }


}
