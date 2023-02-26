public class Strzały  {

    char[][] polestrzałów = new char[10][10];



    boolean Czykoniec(int ilex) {

        int x = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                if(polestrzałów[i][j] == 'X') {
                    x++;
                }
            }
        }
        if(ilex == x) {
            return true;
        }
        else {
            return false;
        }
    }

    void ZaładujPoleStrzału() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                polestrzałów[i][j] = '~';
            }
        }
    }

    void DrukpoleStrzału() {
        System.out.print("  ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
        char y = 'A';
        for (int i = 0; i < 10; i++) {
            System.out.print(y + " ");
            y++;
            for (int j = 0; j < 10 ; j++) {
                //   polebitwy[i][j] = '~';
                System.out.print(polestrzałów[i][j] + " ");
            }
            System.out.println();
        }
    }

}
