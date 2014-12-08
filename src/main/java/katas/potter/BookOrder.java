package katas.potter;

import java.util.Set;

public class BookOrder {

    private BookBasket basket;

    public BookOrder() {
        basket = new BookBasket();
    }

    public BookOrder(BookOrder order) {
        basket = new BookBasket(order.basket);
    }

    public void add(int size, Book book) {
        basket.add(book, size);
    }

    public Set<Book> books() {
        return basket.books();
    }

    public void removeBooksBy(BookSet bookSet) {
        for (Book book : bookSet.books()) {
            removeCopyBy(book);
        }
    }

    public void removeCopyBy(Book book) {
        basket.remove(book);
    }

    public int booksSize() {
        return basket.size();
    }

    public int copiesSize() {
        return basket.copiesSize();
    }

    public float price() {
        return getBestPriceFromSetups().floatValue();
    }

    private BookPrice getBestPriceFromSetups() {
        BookPrice bestPrice = new BookPrice();
        for (int bookSetSize = 1; bookSetSize <= booksSize(); bookSetSize++) {
            BookPrice priceSetup = BookBasketSetup.createBy(this, bookSetSize).price();
            if (priceSetup.isBestThan(bestPrice)) {
                bestPrice = priceSetup;
            }
        }
        return bestPrice;
    }

    public int size() {
        return basket.size();
    }
}
