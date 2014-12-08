package katas.potter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BookOrder {

    private int copiesSize = 0;

    private Map<Book, Integer> bookBasket;

    public BookOrder() {
        copiesSize = 0;
        bookBasket = new LinkedHashMap<>();
    }

    public BookOrder(BookOrder order) {
        copiesSize = order.copiesSize();
        bookBasket = new LinkedHashMap<>(order.getBookBasket());
    }

    public void add(int size, Book book) {
        bookBasket.put(book, size);
        copiesSize += size;
    }

    public Map<Book, Integer> getBookBasket() {
        return bookBasket;
    }

    public Set<Book> books() {
        return bookBasket.keySet();
    }

    public void removeBooksBy(BookSet bookSet) {
        for (Book book : bookSet.books()) {
            removeCopyBy(book);
        }
    }

    public void removeCopyBy(Book book) {
        copiesSize--;
        bookBasket.put(book, bookBasket.get(book) - 1);
        if (bookBasket.get(book) == 0) {
            bookBasket.remove(book);
        }
    }

    public int booksSize() {
        return bookBasket.size();
    }

    public int copiesSize() {
        return copiesSize;
    }

    public float price() {
        return getBestPriceFromSetups().floatValue();
    }

    private BookPrice getBestPriceFromSetups() {
        BookPrice bestPrice = new BookPrice();
        for (int bookSetSize = 1; bookSetSize <= booksSize(); bookSetSize++) {
            BookPrice priceSetup = BasketSetup.createBy(this, bookSetSize).price();
            if (priceSetup.isBestThan(bestPrice)) {
                bestPrice = priceSetup;
            }
        }
        return bestPrice;
    }

}
