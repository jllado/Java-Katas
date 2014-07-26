package katas.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookSet {

    private BigDecimal[] discounts = {
            new BigDecimal("0"),
            new BigDecimal("1"),
            new BigDecimal("0.95"),
            new BigDecimal("0.9"),
            new BigDecimal("0.8"),
            new BigDecimal("0.75") };

    private List<Book> books;

    public BookSet() {
        books = new ArrayList<Book>();
    }

    public static BookSet createBy(BookOrder bookOrder, int bookSetSize) {
        BookSet bookSet = new BookSet();
        for (Book book : bookOrder.books()) {
            if (bookSet.isSize(bookSetSize)) {
                break;
            }
            bookSet.add(book);
        }
        return bookSet;
    }

    private boolean isSize(int bookSetSize) {
        return books.size() == bookSetSize;
    }

    public void add(Book book) {
        books.add(book);
    }

    public int size() {
        return books.size();
    }

    public List<Book> books() {
        return books;
    }

    public BigDecimal price() {
        return discounts[size()].multiply(new BigDecimal(Book.PRIZE * size()));
    }

}