package katas.potter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BookSet {

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

    public BookPrice price() {
        BookDiscount sizeDiscount = BookDiscounts.getBy(size());
        BookPrice bookSetPrice = BookPrice.getDefaultPrice();
        bookSetPrice.multiplyBy(size());
        bookSetPrice.apply(sizeDiscount);
        return bookSetPrice;
    }

}