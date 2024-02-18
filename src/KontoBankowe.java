public class KontoBankowe {
    private double saldo = 0;
    private int pin;
    private int id;
    public KontoBankowe(int id, int pin){
        this.pin = pin;
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public double getSaldo() {

        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void zmienSaldo(double saldo) {
        this.saldo += saldo;
    }
    public void setPin(int pin){
        this.pin = pin;
    }
    public int getPin(){
        return pin;
    }
    public void wyplac(int kwota){
        saldo -= kwota;
    }
    public void wplac(int kwota){
        saldo += kwota;
    }

}
