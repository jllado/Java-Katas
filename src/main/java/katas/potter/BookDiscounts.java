package katas.potter;

/**
 * Created by jllado on 8/12/14.
 */
public class BookDiscounts {

    private static final BookDiscount[] sizeDiscounts = {
            new BookDiscount("0"),
            new BookDiscount("1"),
            new BookDiscount("0.95"),
            new BookDiscount("0.9"),
            new BookDiscount("0.8"),
            new BookDiscount("0.75") };

    public static BookDiscount getBy(int size) {
        return sizeDiscounts[size];
    }
}
