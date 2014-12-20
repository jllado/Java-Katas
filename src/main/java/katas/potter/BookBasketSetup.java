package katas.potter;

import java.util.ArrayList;
import java.util.List;

public class BookBasketSetup {

    private List<BookSet> bookSets;

    public BookBasketSetup() {
        bookSets = new ArrayList<>();
    }

    public void add(BookSet bookSet) {
        bookSets.add(bookSet);
    }

    public BookPrice price() {
        BookPrice price = new BookPrice();
        for (BookSet bookSet : bookSets) {
            price = price.add(bookSet.price());
        }
        return price;
    }

}
