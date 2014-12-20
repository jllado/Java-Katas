package katas.potter;

import java.math.BigDecimal;

/**
 * Created by jllado on 8/12/14.
 */
public class BookPrice {

    private BigDecimal value;

    public BookPrice() {
        value = new BigDecimal("0");
    }

    public BookPrice(String value) {
        this.value = new BigDecimal(value);
    }

    public BookPrice add(BookPrice price) {
        return getBookPriceBy(value.add(price.value));
    }

    public boolean isBestThan(BookPrice price) {
        return price.isZero() || value.compareTo(price.value) < 0;
    }

    private boolean isZero() {
        return value.equals(BigDecimal.ZERO);
    }

    public static BookPrice getDefaultPrice() {
        return new BookPrice("8");
    }

    public BookPrice times(int value) {
        return getBookPriceBy(this.value.multiply(new BigDecimal(value)));
    }

    private BookPrice getBookPriceBy(BigDecimal value) {
        BookPrice bookPrice = new BookPrice();
        bookPrice.value = value;
        return bookPrice;
    }

    public BookPrice multiplyBy(BigDecimal value) {
        return getBookPriceBy(this.value.multiply(value));
    }

    public BookPrice apply(BookDiscount discount) {
        return multiplyBy(discount.value());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BookPrice bookPrice = (BookPrice) o;

        if (value != null ? value.floatValue() != bookPrice.value.floatValue() : bookPrice.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
