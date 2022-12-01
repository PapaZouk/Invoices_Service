package service;

import java.math.RoundingMode;

public class AccountantImpl implements Accountant{

    @Override
    public void process() {
        Invoice invoice = Invoice.getInvoicePeek();
        if (Invoice.TOTAL_AMOUNT > 0) {
            Invoice.TOTAL_AMOUNT -= invoice.getAmount().setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            PrintingService.printProcessMsg(invoice);
            Invoice.popInvoice();
            PrintingService.printSummary();
        } else {
            System.out.println("No more invoices to process");
        }
    }

}
