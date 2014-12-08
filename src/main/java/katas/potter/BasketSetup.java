package katas.potter;

import java.util.ArrayList;
import java.util.List;

public class BasketSetup {

    private List<BookSet> bookSets;

    public BasketSetup() {
        bookSets = new ArrayList<>();
    }

    public static BasketSetup createBy(BookOrder bookOrder, int bookSetSize) {
        BasketSetup basketSetup = new BasketSetup();

        BookOrder newBookOrder = new BookOrder(bookOrder);
        while (basketSetup.isThereBooksIn(newBookOrder)) {
            BookSet bookSet = BookSet.createBy(newBookOrder, basketSetup.bookSetSize(bookSetSize, newBookOrder));
            basketSetup.add(bookSet);
            newBookOrder.removeBooksBy(bookSet);
        }
        return basketSetup;
    }

    private int bookSetSize(int bookSetSize, BookOrder bookOrder) {
        if (bookOrder.booksSize() >= bookSetSize) {
            return bookSetSize;
        } else {
            return bookOrder.booksSize();
        }
    }

    private boolean isThereBooksIn(BookOrder bookOrder) {
        return bookOrder.booksSize() > 0;
    }

    public void add(BookSet bookSet) {
        bookSets.add(bookSet);
    }

    public List<BookSet> getBookSets() {
        return bookSets;
    }

    public BookPrice price() {
        BookPrice price = new BookPrice();
        for (BookSet bookSet : bookSets) {
            price.add(bookSet.price());
        }
        return price;
    }

}
