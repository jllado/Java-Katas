package katas.potter;

import java.util.ArrayList;
import java.util.List;

public class BookSet {

    private List<Book> books;

    public BookSet() {
        books = new ArrayList<>();
    }

    public boolean isSize(int size) {
        return books.size() == size;
    }

    public void add(Book book) {
        books.add(book);
    }

    public List<Book> books() {
        return books;
    }

    public BookPrice price() {
        BookDiscount sizeDiscount = BookDiscounts.getBy(books.size());
        BookPrice bookSetPrice = BookPrice.getDefaultPrice();
        bookSetPrice.multiplyBy(books.size());
        bookSetPrice.apply(sizeDiscount);
        return bookSetPrice;
    }

}