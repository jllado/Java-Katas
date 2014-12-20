package katas.potter;

public class BookOrder {

    private final BookBasket basket;

    public BookOrder() {
        basket = new BookBasket();
    }

    public void add(int size, Book book) {
        basket.add(book, size);
    }

    public BookPrice price() {
        return basket.getBestPrice();
    }

}
