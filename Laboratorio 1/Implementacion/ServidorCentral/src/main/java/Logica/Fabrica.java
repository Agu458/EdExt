package Logica;

public class Fabrica {
    
    private static Fabrica instance = null;
    
    private Fabrica(){
    }
    
    public static Fabrica getInstance(){
        if(instance == null){
            instance = new Fabrica();
        }
        return instance;
    }
    
    public ISistema getISistema(){
        return Sistema.getInstance();
    }
}
