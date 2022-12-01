package service;

import java.math.RoundingMode;

public class AccountantImpl implements Accountant{


    @Override
    public void process(InvoiceStack invoiceStack) {
        Invoice invoice = invoiceStack.getInvoicePeek();
        if (invoiceStack.getTotalAmount() > 0 || invoice != null) {
            invoiceStack.reduceTotalAmount(invoice.getAmount());
            PrintingService.printProcessMsg(invoice);
            invoiceStack.popInvoice();
            PrintingService.printSummary(invoiceStack);
        } else {
            System.out.println(PrintingService.NO_MORE_INVOICES_TO_PROCESS);
        }
    }

}
