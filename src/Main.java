import model.Exchange;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        currency_info();
        currency_convert();
    }

    private static void currency_info() {
        Exchange exchange = new Exchange();

        System.out.println("Exchange Rate Today");
        System.out.println("-------------------------");
        System.out.println("1 JPY = IDR " +formatNumber(exchange.getJpy()));
        System.out.println("1 MYR  = IDR " +formatNumber(exchange.getRm()));
        System.out.println("1 SGD = IDR " +formatNumber(exchange.getSgd()));
        System.out.println("1 CNY = IDR " +formatNumber(exchange.getCny()));
        System.out.println("-------------------------");
    }

    private static void currency_convert() {
        int selectedMenu = 0, inAMount, loop;
        String inCheck;
        Scanner input = new Scanner(System.in);

        loop = 0;

        do {
            loop++;

            System.out.println("\nSelect exchange type:");
            System.out.println("1/ Japanese Yen to Indonesian Rupiah (JPY - IDR)");
            System.out.println("2/ Malaysian Ringgit to Indonesian Rupiah (MYR - IDR)");
            System.out.println("3/ Singapore Dollar to Indonesian Rupiah (SGD - IDR)");
            System.out.println("4/ Chinese Yuan to Indonesian Rupiah (CNY - IDR)");
            System.out.println("5/ Indonesian Rupiah to Other (IDR - Other)\n");

            System.out.print("Your selection: ");
            selectedMenu = input.nextInt();

            System.out.print("Input your amount number: ");
            inAMount = input.nextInt();

            convert(selectedMenu, inAMount);

            System.out.print("Check exchange again? [y/n]: ");
            inCheck = input.next();

            if (Objects.equals(inCheck, "n")) {
                System.out.println("Thanks :)");
                loop = 0;
            }
        } while (loop > 0);
    }

    private static void convert(int selected, int amount) {
        double resJpy, resMyr, resSgd, resCny;

        Exchange exchange = new Exchange();

        switch (selected) {
            case 1:
                resJpy = amount * exchange.getJpy();
                printResult("JPY", amount, resJpy);
                break;
            case 2:
                resMyr = amount * exchange.getRm();
                printResult("MYR", amount, resMyr);
                break;
            case 3:
                resSgd = amount * exchange.getSgd();
                printResult("SGD", amount, resSgd);
                break;
            case 4:
                resCny = amount * exchange.getCny();
                printResult("CNY", amount, resCny);
                break;
            case 5:
                resJpy = amount / exchange.getJpy();
                resMyr = amount / exchange.getRm();
                resSgd = amount / exchange.getSgd();
                resCny = amount / exchange.getCny();

                System.out.println("Result");
                System.out.println("IDR: " +formatNumber(amount));
                System.out.println("JPY: " +formatNumber(resJpy));
                System.out.println("MYR: " +formatNumber(resMyr));
                System.out.println("SGD: " +formatNumber(resSgd));
                System.out.println("CNY: " +formatNumber(resCny)+ "\n");
                break;
            default:
                System.out.println("no one selected");
                break;
        }
    }

    private static String formatNumber(double value) {
        DecimalFormat df = new DecimalFormat("###,###,###");
        return df.format(value);
    }

    private static void printResult(String type, int amt, double res) {
        System.out.println("Result");
        System.out.println(type+ ": " +formatNumber(amt));
        System.out.println("IDR: " +formatNumber(res)+ "\n");
    }
}