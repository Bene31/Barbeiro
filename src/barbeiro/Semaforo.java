package src.barbeiro;

public class Semaforo{
    private int value;
    
    public Semaforo(int v){
        value = v;
    }
    public synchronized void decrementar(){
        while(value <= 0){
            try{
                wait();
            }catch(Exception e){}
        }
        value--;
    }
    public synchronized void incrementar(){
        ++value;
        notify();
    }
}