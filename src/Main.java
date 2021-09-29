import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {
        // Adat tipusok
        String koszones;
        koszones = "hello";
        System.out.println(koszones.toUpperCase());
        System.out.println(koszones);
        System.out.println("Hello");
        int kor = 23;
        System.out.println(kor);
        char jogosultsag = 'r';
        byte pelda = 127;
        int pelda2 = 2147483647;
        double atlag = 25.4;
        boolean korozott = true;
        int pelda3 = pelda;
        String byteszoveg = String.valueOf(pelda);
        int pelda4 = Integer.parseInt("23");
        double pelda5 = Double.parseDouble("23e2");
        double pelda6 = Double.parseDouble("23.15");
        System.out.println(pelda5);

        /* Beolvasas konzolrol
         * Scanner*/
      /*  Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        System.out.println("A beolvasott ertek:" +s);

        int a = in.nextInt();
        System.out.println("A beolvasott ertek:" +a);

        double c = in.nextDouble();
        System.out.println("A beolvasott ertek:" +c);
*/
        // Operátorok
       /* System.out.println(3 + 4);
        System.out.println("4"+3);
        System.out.println(3-4);
        System.out.println(14 *2);
        System.out.println(14 /2);
        System.out.println(14 % 3);
        int d = 14;
        d++;
        System.out.println(d);
        System.out.println(10 < 14);
        System.out.println(10==10);
        System.out.println(10!=10);
        System.out.println(10 < 14 && 10 > 5);
        System.out.println(10 < 14 && 10 > 11);
        System.out.println(20< 14 || 20 >25);*/


       /* //Elágazás
       Scanner in = new Scanner(System.in);
        int szam = in.nextInt();

        if (szam >=1 && szam <= 5){
            System.out.println("Jó a szám");
            if (szam % 2 == 0){
                System.out.println("Páros szám");
            }else{
                System.out.println("Páratlan szám");
            }
        }
        // Switch-case szerkezet
        int day = 1;
        switch (day){
            case 1:
                System.out.println("Hétfő van");
                break;
            case 2:
                System.out.println("Kedd van");
                break;
            default:
                System.out.println("Nem ismerem a mai napot");
        }
    */
/*      //While ciklis, ellenőrzött beolvasás
        Scanner in = new Scanner(System.in);
        int szam = in.nextInt();
        while (!(szam >= 1 && szam <= 5)) {
            System.out.println("Nem jó a szám, próbálja újra");
            szam = in.nextInt();
        }
        System.out.println("Jó a szám");
        if (szam % 2 == 0) {
            System.out.println("Páros szám");
        } else {
            System.out.println("Páratlan szám");
        }*/
        // For ciklus, -10 és 10 közötti páratlan számok kiírása
        for (int i = -10; i < 10; i++) {
            if (abs(i % 2) == 1) {
                System.out.println(i);
            }
        }
        // For ciklus, 1 és 10 közötti minden második szám kiírása (jelenleg páratlan számok kiírása)
        for (int i = 1; i < 10; i = i + 2) {
            System.out.println(i);
        }


      /*  // Tömb elemeinek feltöltése for ciklus segítségével
        String [] tomb = new String[20];
        tomb[0] = "Szia";
        tomb[1] = "Cica";
        for (int i = 0; i < tomb.length; i++){
            System.out.println("Az "+i+". elem: "+ tomb[i]);
        }*/

        // Tömb elemeinek feltöltése függvény segítségével
        Scanner in = new Scanner(System.in);
        System.out.println("Hány elemet szeretne felvinni\n");
        int N = in.nextInt();
        in.nextLine(); //Új sor karakter elnyelése

        String[] ertekek = beolvasSzoveget(N);
        kiirSzovegetSorrendben(ertekek); // Sorrendben kiirjuk a tömb értékeit
        kiirtSzovegetForditva(ertekek); // Fordított sorrendben kiirjuk a tömb értékeit

        System.out.println("A legalább 4 hosszú elemek száma: " +
                megszamlalas(ertekek, 4));
        int osszeg = osszegzes(ertekek);
        System.out.println("A betűk összege:"
                + osszeg + ", átlagos hossz: " + (double) osszeg / N);
        if (eldontesUresElem(ertekek)) {
            System.out.println("Van benne ures elem");
        } else {
            System.out.println("Nincs benne ures elem");
        }
        System.out.println("A keresett ertek indexe: "
                + kivalasztas(ertekek, "HELLO"));
        int index = kereses(ertekek, "Hi");
        System.out.println(index == -1 ? "Nincs benne" : "A keresett ertek indexe: "
                + index);

        System.out.println("A legrövidebb szöveg hossza: " +
                legrovidebbSzoveg(ertekek));


        kivalogatas(ertekek); //Kiválogatás algoritmus megvalósítása
        novekvoSorban(ertekek); //Rendezési algoritmus megvalósítása
    }

    //region Szovegbeolvasas pelda
    public static String[] beolvasSzoveget(int N) {
        Scanner in = new Scanner(System.in);
        System.out.println("Az elemek:");
        String[] tomb = new String[N];
        for (int i = 0; i < N; i++) {
            tomb[i] = in.nextLine();
        }
        return tomb;
    }

    public static void kiirSzovegetSorrendben(String[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            System.out.println("Az " + i + ". elem: " + tomb[i]);
        }

    }

    public static void kiirtSzovegetForditva(String[] tomb) {
        for (int i = tomb.length - 1; i >= 0; i--) {
            System.out.println("Az " + i + ". elem: " + tomb[i]);
        }
    }

    //endregion
    public static int megszamlalas(String[] tomb, int minHossz) {
        int szamlalo = 0;
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i].length() >= minHossz) {
                szamlalo++;
            }
        }
        return szamlalo;
    }

    public static int osszegzes(String[] tomb) {
        int osszeg = 0;
        for (int i = 0; i < tomb.length; i++) {
            osszeg = osszeg + tomb[i].length();
        }
        return osszeg;

    }

    public static boolean eldontesUresElem(String[] tomb) {
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i].length() == 0) {
                return true;
            }
        }
        return false;
    }

    public static int kivalasztas(String[] tomb, String keresendo) {
        int i = 0;
        while (!tomb[i].equalsIgnoreCase(keresendo)) {
            i++;
        }
        return i;
    }

    public static int kereses(String[] tomb, String keresendo) {
        int i = 0;
        while (i < tomb.length && !tomb[i].equalsIgnoreCase(keresendo)) {
            i++;
        }
        if (i >= tomb.length) {
            return -1;
        }
        return i;
    }

    public static int legrovidebbSzoveg(String[] tomb) {
        int min = tomb[0].length();
        for (int i = 1; i < tomb.length; i++) {
            if (min > tomb[i].length()) {
                min = tomb[i].length();
            }
        }
        return min;
    }

    public static void kivalogatas(String[] tomb) {
        String[] paratlanHosszu = new String[tomb.length];
        String[] parosHosszu = new String[tomb.length];
        int paratlanIndex = 0;
        int parosIndex = 0;
        for (int i = 0; i < tomb.length; i++) {
            if (tomb[i].length() % 2 == 0) {
                parosHosszu[parosIndex] = tomb[i];
                parosIndex++;
            } else {
                paratlanHosszu[paratlanIndex] = tomb[i];
                paratlanIndex++;
            }
        }
        System.out.println(Arrays.toString(paratlanHosszu));
        System.out.println(Arrays.toString(parosHosszu));
    }

    public static void novekvoSorban(String[] tomb) {
        String csere;
        int min;
        for (int i = 0; i < tomb.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < tomb.length; j++) {
                if (tomb[j].length() < tomb[min].length()) {
                    min = j;
                }
            }
            if (min != i) {
                csere = tomb[i];
                tomb[i] = tomb[min];
                tomb[min] = csere;
            }
        }
        System.out.println(Arrays.toString(tomb));

    }
}
