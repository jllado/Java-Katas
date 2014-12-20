package katas.potter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jllado on 8/12/14.
 */
public class BookBasket {
    private final Map<Book, Integer> books;
    private int copiesSize = 0;

    public BookBasket() {
        this.books = new LinkedHashMap<>();
    }

    private BookBasket(BookBasket basket) {
        this.books = new LinkedHashMap<>(basket.books);
        this.copiesSize = basket.copiesSize;
    }

    public void add(Book book, int size) {
        books.put(book, size);
        copiesSize += size;
    }

    private int sizeOf(Book book) {
        return books.get(book);
    }

    public void remove(Book book) {
        copiesSize--;
        books.put(book, sizeOf(book) - 1);
        if (sizeOf(book) == 0) {
            books.remove(book);
        }
    }

    private void removeBooksBy(BookSet bookSet) {
        for (Book book : bookSet.books()) {
            remove(book);
        }
    }

    public BookBasketSetup getSetupBy(int maxBooks) {
        BookBasketSetup basketSetup = new BookBasketSetup();
        BookBasket basket = new BookBasket(this);
        while (basket.notEmpty()) {
            BookSet bookSet = basket.getSetBy(maxBooks);
            basketSetup.add(bookSet);
            basket.removeBooksBy(bookSet);
        }
        return basketSetup;
    }

    private BookSet getSetBy(int maxBooks) {
        int setSize = bookSetSize(maxBooks);
        BookSet bookSet = new BookSet();
        for (Book book : books.keySet()) {
            if (bookSet.isSize(setSize)) {
                break;
            }
            bookSet.add(book);
        }
        return bookSet;
    }

    private int bookSetSize(int maxBook) {
        if (books.size() >= maxBook) {
            return maxBook;
        } else {
            return books.size();
        }
    }

    private boolean notEmpty() {
        return books.size() > 0;
    }

    public BookPrice getBestPrice() {
        BookPrice bestPrice = new BookPrice();
        for (int maxBookSetSize = 1; maxBookSetSize <= books.size(); maxBookSetSize++) {
            BookPrice priceSetup = getSetupBy(maxBookSetSize).price();
            if (priceSetup.isBetterThan(bestPrice)) {
                bestPrice = priceSetup;
            }
        }
        return bestPrice;
    }

}
