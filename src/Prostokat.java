public class Prostokat {
    private int dlugosc;
    private int szerokosc;

    public int getDlugosc() {
        return dlugosc;
    }

    public void setDlugosc(int dlugosc) {
        this.dlugosc = dlugosc;
    }

    public int getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(int szerokosc) {
        this.szerokosc = szerokosc;
    }

    public int obliczPole() {
        return dlugosc * szerokosc;
    }
}
