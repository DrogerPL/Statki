
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String x,y;


        boolean pstryk = false;
        int jednostki = 7;
        //Pierwszy gracz
        PoleBitwy pole1 = new PoleBitwy();
        pole1.Załadujpole();
        pole1.ZaładujPoleStrzału();


        System.out.println("Pierwszy gracz dokuje statki");

        do
        {
            System.out.println("Podaj koordynaty lotniskowca (4 jednostek)");
            x = scan.next();
            y = scan.next();

        } while (!pole1.DodajStatek(x,y,4));

        pole1.Drukpole();
        do
        {
            System.out.println("Podaj koordynaty krążownika (3 jednostki)");
            x = scan.next();
            y = scan.next();

        } while (!pole1.DodajStatek(x,y,3));

        pole1.Drukpole();


        //Drugi gracz
        PoleBitwy pole2 = new PoleBitwy();
        pole2.Załadujpole();
        pole2.ZaładujPoleStrzału();

        do
        {
            System.out.println("Podaj koordynaty lotniskowca (4 jednostek)");
            x = scan.next();
            y = scan.next();

        } while (!pole2.DodajStatek(x,y,4));

        pole2.Drukpole();
        do
        {
            System.out.println("Podaj koordynaty krążownika (3 jednostki)");
            x = scan.next();
            y = scan.next();

        } while (!pole2.DodajStatek(x,y,3));


        pole2.Drukpole();


        while(!pstryk) {
            do
            {
                System.out.println("Strzela gracz 2!");
                x = scan.next();
            } while (!pole1.Stzał(x));
            if(pole1.Czykoniec(jednostki)) {
                System.out.println("Wygrał gracz 2!");
                break;
            }
            pole1.DrukpoleStrzału();

            do
            {
                System.out.println("Strzela gracz 1!");
                x = scan.next();;
            } while (!pole2.Stzał(x));
            if(pole2.Czykoniec(jednostki)) {
                System.out.println("Wygrał gracz 1!");
                break;
            }
            pole2.DrukpoleStrzału();
        }




        // Write your code here
    }
}
