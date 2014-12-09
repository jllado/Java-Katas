package katas.potter;

import java.math.BigDecimal;

/**
 * Created by jllado on 8/12/14.
 */
public class BookDiscount {

    private final BigDecimal value;

    public BookDiscount(String value) {
        this.value = new BigDecimal(value);
    }

    public BigDecimal value() {
        return value;
    }
}
