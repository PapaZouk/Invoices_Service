package service;

import java.math.BigDecimal;

@FunctionalInterface
public interface CEO {
    void addInvoice(BigDecimal amount);
}
