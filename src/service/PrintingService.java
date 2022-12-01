package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrintingService {

    public static final String CEO_ADD_INVOICE = "CEO: ADD INVOICE";
    public static final String ACCOUNTANT_PROCESS_INVOICE = "ACCOUNTANT: PROCESS INVOICE";
    public static final String SHOW_INVOICES = "SHOW INVOICES";
    public static final String EXIT = "EXIT";
    public static final String UNKNOWN_COMMAND = "UNKNOWN COMMAND";
    public static final String FORMAT_WARNING = "Format number must be (nn.nn)";
    public static final String WRONG_AMOUNT = "Amount must be > 0";
    public static final String CURRENT_INVOICES_AMOUNT = "Current invoices amount: ";
    public static final String CEO_ADDED_INVOICE_ID = "CEO added invoice: ID: ";
    public static final String ACCOUNTANT_PROCESSED_INVOICE = "ACCOUNTANT processed invoice: ";

    public static final String CURRENT_INVOICES_TO_PROCESS = "Current invoices to process:";

    public static void printSummary() {
        System.out.print(CURRENT_INVOICES_AMOUNT +
                BigDecimal.valueOf(Invoice.TOTAL_AMOUNT).setScale(2, RoundingMode.HALF_EVEN) + ". ");
        Invoice.printInvoices();
    }

    public static void printProcessMsg(Invoice invoice) {
        if (invoice != null) {
            System.out.println(ACCOUNTANT_PROCESSED_INVOICE +
                    "{ID: " +
                    invoice.getID() + "/" +
                    invoice.getInvoiceDate().getYear() + ", " +
                    "AMOUNT: " + invoice.getAmount() + "}");
        }
    }

    public static void printAddMsg(Invoice invoice) {
        System.out.println(CEO_ADDED_INVOICE_ID +
                invoice.getID() + "/"
                + invoice.getInvoiceDate().getYear() +
                ", " + invoice.getAmount());
    }

}

