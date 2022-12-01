package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrintingService {

    public static final String ID = "ID: ";
    public static final String ACCOUNTANT_PROCESS_INVOICE = "ACCOUNTANT: PROCESS INVOICE";
    public static final String ACCOUNTANT_PROCESSED_INVOICE = "ACCOUNTANT processed invoice: ";
    public static final String AMOUNT = "AMOUNT: ";
    public static final String CEO_ADD_INVOICE = "CEO: ADD INVOICE";
    public static final String CEO_ADDED_INVOICE_ID = "CEO added invoice: " + ID;
    public static final String CURRENT_INVOICES_AMOUNT = "Current invoices amount: ";
    public static final String CURRENT_INVOICES_TO_PROCESS = "Current invoices to process:";
    public static final String EXIT = "EXIT";
    public static final String FORMAT_WARNING = "Format number must be (nn.nn)";
    public static final String NO_MORE_INVOICES_TO_PROCESS = "No more invoices to process";
    public static final String SHOW_INVOICES = "SHOW INVOICES";
    public static final String WRONG_AMOUNT = "Amount must be > 0";
    public static final String UNKNOWN_COMMAND = "UNKNOWN COMMAND";

    public static void printSummary(InvoiceStack invoiceStack) {
        System.out.print(CURRENT_INVOICES_AMOUNT +
                BigDecimal.valueOf(invoiceStack.getTotalAmount()).setScale(2, RoundingMode.HALF_EVEN) + ". ");
        Invoice.printInvoices(invoiceStack);
    }

    public static void printProcessMsg(Invoice invoice) {
        if (invoice != null) {
            System.out.println(ACCOUNTANT_PROCESSED_INVOICE +
                    "{" + ID +
                    invoice.getID() + "/" +
                    invoice.getInvoiceDate().getYear() + ", " +
                    AMOUNT + invoice.getAmount() + "}");
        }
    }

    public static void printAddMsg(Invoice invoice) {
        System.out.println(CEO_ADDED_INVOICE_ID +
                invoice.getID() + "/"
                + invoice.getInvoiceDate().getYear() +
                ", " + invoice.getAmount());
    }

    public static void help() {
        System.out.println("Use following commands to: ");
        System.out.printf("%-30s \t:\t %-20s\n", "\"CEO: ADD INVOICE(amount)\"", "to add new invoice.");
        System.out.printf("%-30s \t:\t %-20s\n", "\"ACCOUNTANT: PROCESS INVOICE\"", "to process last invoice.");
        System.out.printf("%-30s \t:\t %-20s\n", "\"SHOW INVOICES\" ", "to check available invoices.");
        System.out.printf("%-30s \t:\t %-20s\n\n", "\"EXIT\"", "to exit program.");
    }

    public static void introduction() {
        System.out.println("-----------------------------------------------------");
        System.out.println("\t\t## INVOICE SERVICE MANAGER ##");
        System.out.println("-----------------------------------------------------");
    }

}

