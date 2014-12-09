package katas.potter;

public class BookOrder {

    private BookBasket basket;

    public BookOrder() {
        basket = new BookBasket();
    }

    public void add(int size, Book book) {
        basket.add(book, size);
    }

    public float price() {
        return basket.getBestPrice().floatValue();
    }

}
