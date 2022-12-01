package service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;

public class InvoiceStack {

    private Deque<Invoice> invoices = new ArrayDeque<>();

    private double totalAmount = 0;

    public Deque<Invoice> getInvoices() {
        return invoices;
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.push(invoice);
    }

    public Invoice getInvoicePeek() {
        return this.invoices.peek();
    }

    public void popInvoice() {
        this.invoices.pop();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void addTotalAmount(BigDecimal amount) {
        totalAmount += amount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }

    public void reduceTotalAmount(BigDecimal amount) {
        totalAmount -= amount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
    }
}
