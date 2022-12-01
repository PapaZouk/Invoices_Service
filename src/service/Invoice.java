package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Invoice {

    public static double TOTAL_AMOUNT = 0;
    private static Integer invoicesCounter = 0;
    private final LocalDate invoiceDate = LocalDate.now();
    private final BigDecimal amount;
    private Integer ID = 0;

    public Invoice(final BigDecimal amount) {
        this.amount = amount;
        invoicesCounter++;
        this.ID += invoicesCounter;
    }

    public static void printInvoices(InvoiceStack invoiceStack) {
        System.out.println(PrintingService.CURRENT_INVOICES_TO_PROCESS + " \n-------------------------------");
        for (Invoice invoice : invoiceStack.getInvoices()) {
            if (invoice != null) {
                System.out.println("[ID: " + invoice.getID() + "/" +
                        invoice.getInvoiceDate().getYear() +
                        ", amount: " + invoice.getAmount().setScale(2, RoundingMode.HALF_EVEN) + "]");
            } else {
                System.out.println(PrintingService.NO_MORE_INVOICES_TO_PROCESS);
            }
        }

    }

    public Integer getID() {
        return ID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

}
