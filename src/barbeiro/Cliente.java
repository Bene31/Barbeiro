package src.barbeiro;

public class Cliente extends Thread{
    private int id;
    
    public Cliente(int id){
        this.id = id;
    }
    
    private void cortarCabelo(){
        System.out.println("Cliente " + this.id + " cortando o cabelo");
    }
    
    @Override
    public void run(){
        System.out.println("Cliente "+ this.id +" chegou a barbearia");
        Principal.mutex.decrementar();
        if ( Principal.waiting < Principal.MAXCLIENTES ){
        Principal.waiting++;
        Principal.clientes.incrementar();
        Principal.mutex.incrementar();
        Principal.barbeiros.decrementar();
        cortarCabelo();
        }else{
            System.out.println("Barbearia Cheia! Cliente " + this.id + " indo embora"); 
            Principal.mutex.incrementar();
        }
    }

}