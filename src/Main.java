import service.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        PrintingService.introduction();
        PrintingService.help();

        CEO ceo = new CEOImpl();
        Accountant accountant = new AccountantImpl();
        InvoiceStack invoiceStack = new InvoiceStack();

        while (SCANNER.hasNextLine()) {
            String input = SCANNER.nextLine();
            if (input.contains(PrintingService.CEO_ADD_INVOICE)) {
                String amount = getAmount(input);
                try {
                    ceo.addInvoice(invoiceStack, BigDecimal.valueOf(Double.parseDouble(amount)));
                } catch (NumberFormatException e) {
                    System.out.println(PrintingService.FORMAT_WARNING);
                }
            } else if (input.contains(PrintingService.ACCOUNTANT_PROCESS_INVOICE)) {
                accountant.process(invoiceStack);
            } else if (input.equals(PrintingService.SHOW_INVOICES)) {
                Invoice.printInvoices(invoiceStack);
            } else if (input.equals(PrintingService.EXIT)) {
                break;
            } else {
                System.out.println(PrintingService.UNKNOWN_COMMAND);
                PrintingService.help();
            }
        }
    }

    private static String getAmount(String input) {
        int start = input.lastIndexOf("(");
        int end = input.lastIndexOf(")");
        return input.substring(start + 1, end);
    }

}
