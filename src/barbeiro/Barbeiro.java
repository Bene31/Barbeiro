package src.barbeiro;

public class Barbeiro extends Thread{
    private int id;
    
    public Barbeiro(int id){
        this.id = id;
    }
    
    private void cortarCabelo(){
        System.out.println("Barbeiro cortando o cabelo");
        try{
            sleep((int)(Math.random() * 1000));
        }catch(Exception e){}
        System.out.println("Barbeiro terminando");
    }
    
    @Override
    public void run(){
        System.out.println(" Barbeiro chegou a barbearia");
        while(true){
            Principal.clientes.decrementar();
            Principal.mutex.decrementar();
            Principal.waiting = Principal.waiting+1;
            Principal.barbeiros.incrementar();
            Principal.mutex.incrementar();
            cortarCabelo();
        }
    }
}
