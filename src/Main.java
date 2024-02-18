import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KontoBankowe[] konta = {new KontoBankowe(1, 1234), new KontoBankowe(2, 2222), new KontoBankowe(3, 3345)};
        Scanner sc = new Scanner(System.in);
        int nr;
        nr = logowanie(konta);
        boolean zakoncz = false;
        do {
            System.out.println("1. Saldo");
            System.out.println("2. Wplata");
            System.out.println("3. Wyplata");
            System.out.println("4. Przelew");
            System.out.println("5. Wyloguj");
            System.out.println("6. Zakoncz");
            System.out.print("Co chcesz zrobic? ");
            int wybor = sc.nextInt();
            switch (wybor) {
                case 1:
                    saldo_1(nr, konta);
                    break;
                case 2:
                    wplata_2(nr, konta);
                    break;
                case 3:
                    wyplata_3(nr, konta);
                    break;
                case 4:
                    przelew_4(nr, konta);
                    break;
                case 5:
                    nr = logowanie(konta);
                    break;
                case 6:
                    zakoncz = true;
                    break;
            }

        }
        while (!zakoncz);
    }

    public static void saldo_1(int nr, KontoBankowe[] konta) {
        System.out.println("Twoje saldo wynosi: " + konta[nr].getSaldo());
    }

    public static void wplata_2(int nr, KontoBankowe[] konta) {
        System.out.print("Ile chcesz wplacic? ");
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        konta[nr].wplac(ile);
        System.out.println("Wplacono " + ile + ". Saldo po wplacie wynosi " + konta[nr].getSaldo() + ".");
    }

    public static void wyplata_3(int nr, KontoBankowe[] konta) {

        System.out.print("Ile chcesz wyplacic? ");
        Scanner sc = new Scanner(System.in);
        int ile = sc.nextInt();
        if (konta[nr].getSaldo() < ile) {
            System.out.println("Nie masz wystaraczojących środków");
        } else {
            konta[nr].wyplac(ile);
            System.out.println("Wyplacono " + ile + ". Saldo po wyplacie wynosi " + konta[nr].getSaldo() + ".");
        }
    }

    public static void przelew_4(int nr, KontoBankowe[] konta) {
        System.out.print("Ile chcesz przelac? ");
        Scanner sc = new Scanner(System.in);
        Double ile = sc.nextDouble();
        if (konta[nr].getSaldo() < ile) {
            System.out.println("Nie masz wystaraczojących środków");
        } else {
            System.out.print("Na ktore konto? ");
            int id = sc.nextInt();
            boolean przelano = false;
            for (KontoBankowe konto : konta) {
                if (konto.getId() == id) {
                    konta[nr].zmienSaldo(-ile);
                    konto.zmienSaldo(ile);
                    przelano = true;
                }
            }
            if (przelano) {
                System.out.println("Przelano " + ile + ". Saldo po transakcji wynosi " + konta[nr].getSaldo() + ".");
            } else {
                System.out.println("Nie odnaleziono konta o nr " + id + ". Przelew nie zostal wykonany.");
            }

        }
    }

    public static int logowanie(KontoBankowe[] konta) {
        System.out.print("Podaj kod pin: ");
        Scanner sc = new Scanner(System.in);
        int pin = sc.nextInt();
        int nr = -1;
        boolean znaleziono = false;
        for (int i = 0; i < konta.length; i++) {
            if (konta[i].getPin() == pin) {
                nr = i;
                znaleziono = true;
                System.out.println("Zalogowales sie na konto nr " + konta[i].getId());
                break;
            }
        }
        if (!znaleziono) {
            System.out.println("Nie znaleziono konta o takim pinie");
            System.exit(0);
        }
        return nr;
    }


}