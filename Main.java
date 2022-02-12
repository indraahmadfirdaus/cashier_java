package currencyConverter_java;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {

    static double rptousd = 0.000069711915509;
    static double rptorm = 0.00029172379591;
    static double rptosgd = 0.000093951408332;
    static double rptoeuro = 0.00006140311019;
    static int rupiah = 0;

    public static int ShowMenu() {

        System.out.println("Konversi Kurs Mata Uang Rupiah");
        System.out.println("Masukkan input rupiah yang akan dikonversi :");

        Scanner inputRupiah = new Scanner(System.in);
        rupiah = inputRupiah.nextInt();

        Scanner inputMenu = new Scanner(System.in);

        System.out.println("--->");
        System.out.println("USD/Dolar US,RM/Ringgit Malay,SGD/dolar singapura,EURO/ Uni Eropa");
        System.out.println("--------------------------------");
        System.out.println("Info Kurs");
        System.out.println("1 USD = Rp14.344,75");
        System.out.println("2 RM = Rp3.427,90");
        System.out.println("3 SGD = Rp10.643,80");
        System.out.println("4 EURO = Rp16.285,82");
        System.out.println("--------------------------------");

        System.out.println("\nMenu Utama\n" +
                "-------"
                + "----------\n" +
                "1. Konversi ke USD \n" +
                "2. Konversi ke RM \n" +
                "3. Konversi ke SGD \n" +
                "4. Konversi ke EURO\n" +
                "5. Keluar\n" +
                "-----------------");

        return inputMenu.nextInt();
    }

    public static void toUsd(int input) {
        double konversi_rptousd = input * rptousd;

        System.out.println(printFormat(input, konversi_rptousd, "USD"));
    }

    public static void toRm(int input) {
        double konversi_rptorm = input * rptorm;

        System.out.println(printFormat(input, konversi_rptorm, "RM"));
    }

    public static void toSgd(int input) {
        double konversi_rptosgd = input * rptosgd;

        System.out.println(printFormat(input, konversi_rptosgd, "SGD"));
    }

    public static void toEuro(int input) {
        double konversi_toeur = input * rptoeuro;

        System.out.println(printFormat(input, konversi_toeur, "EUR"));
    }

    public static String printFormat(int rupiah, double converted, String type) {
        if (rupiah >= 135) {
            DecimalFormat digit = new DecimalFormat("0.00");
            System.out.println("Rp------>" + type);
            String dcikon = digit.format(converted);
            return "Rp" + rupiah + "= " + dcikon + type;
        } else if (rupiah < 135) {
            DecimalFormat digit = new DecimalFormat("0.000000000");
            System.out.println("Rp------>" + type);
            String dcikon = digit.format(converted);
            return "Rp" + rupiah + "= " + dcikon + type;
        } else {
            return "Not Valid";
        }
    }

    public static int askAgain() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lakukan konverter lagi ? y / n");
        String ans = input.next();
        if (ans.toLowerCase().equals("y")) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        boolean backToMenu = true;

        do {
            int pickedMenu = ShowMenu();
            switch (pickedMenu) {
                case 1:
                    toUsd(rupiah);
                    break;
                case 2:
                    toRm(rupiah);
                    break;
                case 3:
                    toSgd(rupiah);
                    break;
                case 4:
                    toEuro(rupiah);
                    break;
                case 5:
                    backToMenu = false;
                    System.exit(0);
                    break;
                default:
                    break;
            }
            int again = askAgain();
            if (again == 0) {
                backToMenu = false;
            }

        } while (backToMenu);
    }
}
