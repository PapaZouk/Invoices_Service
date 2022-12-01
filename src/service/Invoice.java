package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayDeque;

public class Invoice {

    private static final ArrayDeque<Invoice> INVOICES = new ArrayDeque<>();

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

    public static void addInvoice(Invoice invoice) {
        INVOICES.push(invoice);
    }

    public static Invoice getInvoicePeek() {
        return INVOICES.peek();
    }

    public static void popInvoice() {
        INVOICES.pop();
    }

    public static void printInvoices() {
        System.out.println(PrintingService.CURRENT_INVOICES_TO_PROCESS + " \n-------------------------------");
        for (Invoice invoice : INVOICES) {
            System.out.println("[ID: " + invoice.getID() + "/" +
                    invoice.getInvoiceDate().getYear() +
                    ", amount: " + invoice.getAmount().setScale(2, RoundingMode.HALF_EVEN) + "]");
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

    @Override
    public String toString() {
        return "Invoice ID = " + ID + ", amount = " + amount.setScale(2, RoundingMode.HALF_EVEN);
    }
}
