public class Uzytkownik {
    private String imie;
    private String nazwisko;
    private int wiek;

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        if (wiek > 0 && wiek <120) {
            this.wiek = wiek;
        }
        else{
            System.out.println("nieprawidlowy wiek");
        }
    }
}
