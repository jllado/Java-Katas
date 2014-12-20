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
        return  BookPrice.getDefaultPrice().times(books.size()).apply(sizeDiscount);
    }

}