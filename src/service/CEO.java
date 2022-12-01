package service;

import java.math.BigDecimal;

@FunctionalInterface
public interface CEO {
    void addInvoice(InvoiceStack invoiceStack, BigDecimal amount);
}
