package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CEOImpl implements CEO{

    @Override
    public void addInvoice(InvoiceStack invoiceStack, BigDecimal amount) {
        if (amount.doubleValue() < 0) {
            System.out.println(PrintingService.WRONG_AMOUNT);
            return;
        }
        Invoice invoice = new Invoice(amount.setScale(2, RoundingMode.HALF_EVEN));
        PrintingService.printAddMsg(invoice);
        invoiceStack.addInvoice(invoice);
        invoiceStack.addTotalAmount(amount);

        PrintingService.printSummary(invoiceStack);
    }

}
