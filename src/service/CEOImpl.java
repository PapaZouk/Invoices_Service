package service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CEOImpl implements CEO{

    @Override
    public void addInvoice(BigDecimal amount) {
        if (amount.doubleValue() < 0) {
            System.out.println(PrintingService.WRONG_AMOUNT);
            return;
        }
        Invoice invoice = new Invoice(amount.setScale(2, RoundingMode.HALF_EVEN));
        PrintingService.printAddMsg(invoice);
        Invoice.addInvoice(invoice);

        Invoice.TOTAL_AMOUNT += amount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();

        PrintingService.printSummary();
    }

}
