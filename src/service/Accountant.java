package service;

@FunctionalInterface
public interface Accountant {
    void process(InvoiceStack invoiceStack);
}
