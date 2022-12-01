import service.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CEO ceo = new CEOImpl();
        Accountant accountant = new AccountantImpl();

        StringBuilder cmd = new StringBuilder();

        beginning:
        while (scanner.hasNextLine()) {
            cmd.append(scanner.nextLine());
            if (cmd.toString().contains(PrintingService.CEO_ADD_INVOICE)) {
                int start = cmd.toString().lastIndexOf("(");
                int end = cmd.toString().lastIndexOf(")");
                String line = cmd.substring(start + 1, end);
                try {
                    ceo.addInvoice(BigDecimal.valueOf(Double.parseDouble(line)));
                } catch (NumberFormatException e) {
                    System.out.println(PrintingService.FORMAT_WARNING);
                }
                cmd = new StringBuilder();
            } else if (cmd.toString().contains(PrintingService.ACCOUNTANT_PROCESS_INVOICE)) {
                accountant.process();
            } else if (cmd.toString().equals(PrintingService.SHOW_INVOICES)) {
                Invoice.printInvoices();
            } else if (cmd.toString().equals(PrintingService.EXIT)) {
                break beginning;
            } else {
                System.out.println(PrintingService.UNKNOWN_COMMAND);
                break beginning;
            }
        }
    }
}
