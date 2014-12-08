package katas.potter;

import java.math.BigDecimal;

/**
 * Created by jllado on 8/12/14.
 */
public class BookPrice {
    public static final BigDecimal DEFAULT_PRICE_VALUE = new BigDecimal("8");

    private BigDecimal value;

    public BookPrice() {
        value = new BigDecimal("0");
    }

    public BookPrice(BigDecimal value) {
        this.value = value;
    }

    public void add(BookPrice price) {
        value = value.add(price.value);
    }

    public boolean isBestThan(BookPrice price) {
        return price.isZero() || value.compareTo(price.value) < 0;
    }

    private boolean isZero() {
        return value.equals(BigDecimal.ZERO);
    }

    public float floatValue() {
        return value.floatValue();
    }

    public static BookPrice getDefaultPrice() {
        return new BookPrice(DEFAULT_PRICE_VALUE);
    }

    public void multiplyBy(int value) {
        this.value = this.value.multiply(new BigDecimal(value));
    }

    public void multiplyBy(BigDecimal value) {
        this.value = this.value.multiply(value);
    }

    public void apply(BookDiscount discount) {
        multiplyBy(discount.value());
    }
}
