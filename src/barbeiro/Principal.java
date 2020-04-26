package src.barbeiro;

public class Principal {

    static final int MAXCLIENTES = 6;
    static Semaforo clientes = new Semaforo(0);
    static Semaforo barbeiros = new Semaforo(0);
    static Semaforo mutex = new Semaforo(1);
    static int waiting = 0,cont;
    static Cliente cli[] = new Cliente [10];

    public Principal(){
    }

    public static void main(String[] args){

    Barbeiro b1 = new Barbeiro(1);
    b1.start();
    for(cont = 0; cont < 10; cont++)
    cli[cont]=new Cliente(cont);

    for(cont = 0; cont < 10; cont++)
    cli[cont].start();
    }
}
