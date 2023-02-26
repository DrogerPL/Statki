

public class PoleBitwy extends Strzały {

   public char[][] polebitwy = new char[10][10];


    boolean Stzał(String kordy) {

        int x,y;
        x = (int)kordy.charAt(0)-64;
        y = (int)kordy.charAt(1)-48;

        if(kordy.endsWith("10")) {
            y = 10;
        }

        if(y<=0 || y >10 || x<=0 || x >10) { //Jak za mape chce ktoś wylecieć
            System.out.println("Źle podane dane!");
            return false;
        }


        if(polebitwy[x-1][y-1] == 'O'|| polestrzałów[x-1][y-1] == 'X') {
            if(CzyZatopiony(x-1,y-1)) {
                System.out.println("Zatopiony!");
            }
            System.out.println("Trafiony!");
            polestrzałów[x-1][y-1] = 'X' ;
            polebitwy[x-1][y-1] = '~';
            return true;
        }
        else {
            System.out.println("Pudło!");
            polestrzałów[x-1][y-1] = 'S';
            return true;
        }

    }


    boolean CzyZatopiony(int x, int y) {

        try {
            if(polebitwy[x-1][y] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x][y-1] == 'O')
                return false;
        }
        catch (Exception ingore) { }


        try {
            if(polebitwy[x+1][y] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x][y+1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        return true;


    }
    void Załadujpole() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 ; j++) {
                polebitwy[i][j] = '~';
            }
        }
    }

    void Drukpole() {
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
                System.out.print(polebitwy[i][j] + " ");
            }
            System.out.println();
        }

    }


    boolean SprawdźPole(int x, int y) {
        //hard code
        try {
            if(polebitwy[x-1][y-1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x-1][y] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x][y-1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x][y] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x+1][y] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x][y+1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x+1][y+1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x+1][y-1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

        try {
            if(polebitwy[x-1][y+1] == 'O')
                return false;
        }
        catch (Exception ingore) { }

      
        return true;

    }

    boolean SprawdźKoordynaty(int x1, int x2, int y1, int y2 ) {

        if(x1 == x2) {

            if(y1>y2){
                int temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }

            for (int i = y1-1; i < y2; i++) {

                if(!SprawdźPole(x1-1,i)) {

                    return false;
                }


            }
        }
        else if(y1 == y2) {

            if(x1>x2){
                int temp;
                temp = x1;
                x1 = x2;
                x2 = temp;
            }

            for (int i = x1-1; i < x2; i++) {
                if(!SprawdźPole(i,y1-1)) {
                    return false;
                }

            }
        }
         return true;
    }

    boolean DodajStatek(String x , String y, int leng) {
        // A to 65
        //5 to 53
        //1 to 48
        int x1,y1,x2,y2;

        x1 = (int)x.charAt(0)-64;
        x2 = (int)y.charAt(0)-64;
        y1 = (int)x.charAt(1)-48;
        y2 = (int)y.charAt(1)-48;

      //  System.out.println(y2);
        if(x.endsWith("10")) {
            y1 = 10;
        }
        if(y.endsWith("10")){
            y2 = 10;
        }
     


        if(y2<=0 || y2 >10 || y1<=0 || y1 >10 || x2<=0 || x2 >10 || x1<=0 || x1 >10) { //Jak za mape chce ktoś wylecieć
            System.out.println("Źle podane dane!");
          //  System.out.println("Tutaj?");
            return false;
        }


        if(x1 == x2) {
            if(Math.abs(y2-y1) != leng-1) {   //Sprawdzanie y
                System.out.println("Źle podane dane!");
                return false;
            }
            if(y1>y2){
                int temp;
                temp = y1;
                y1 = y2;
                y2 = temp;
            }
            if(!SprawdźKoordynaty(x1,x2,y1,y2)) {
                return false;
            }

            for (int i = y1-1; i < y2; i++) {
                polebitwy[x1-1][i] = 'O';
            }
        }
        else if(y1 == y2) {

            if(Math.abs(x2-x1) != leng-1) {   //Sprawdzanie x
                System.out.println("Źle podane dane!");
                return false;
            }


            if(x1>x2){
                int temp;
                temp = x1;
                x1 = x2;
                x2 = temp;
            }

            if(!SprawdźKoordynaty(x1,x2,y1,y2)) {
                return false;
            }
            for (int i = x1-1; i < x2; i++) {
                polebitwy[i][y1-1] = 'O';
            }
        }
        else {
            System.out.println("Źle podane dane!");  //Próba jakiegoś krzywych danych
            return false;
        }
        return true;


    }

}
