package katas.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BookOrderTest {

    private BookOrder bookOrder;

    @Before
    public void setUp() {
        bookOrder = new BookOrder();
    }

    @Test
    public void calculate_price_one_book() {
        bookOrder.add(1, Book.BOOK1);

        assertThat(calculatePriceOf(bookOrder), is(8f));
    }

    @Test
    public void calculate_price_two_same_books() {
        bookOrder.add(2, Book.BOOK1);

        assertThat(calculatePriceOf(bookOrder), is(16f));
    }

    @Test
    public void calculate_price_two_different_books() {
        bookOrder.add(1, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);

        assertThat(calculatePriceOf(bookOrder), is(15.2f));
    }

    @Test
    public void calculate_price_three_different_books() {
        bookOrder.add(1, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);
        bookOrder.add(1, Book.BOOK3);

        assertThat(calculatePriceOf(bookOrder), is(21.6f));
    }

    @Test
    public void calculate_price_two_identical_and_one_different() {
        bookOrder.add(2, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);

        assertThat(calculatePriceOf(bookOrder), is(23.2f));
    }

    @Test
    public void calculate_price_2_2_2_1_1() {
        bookOrder.add(2, Book.BOOK1);
        bookOrder.add(2, Book.BOOK2);
        bookOrder.add(2, Book.BOOK3);
        bookOrder.add(1, Book.BOOK4);
        bookOrder.add(1, Book.BOOK5);

        assertThat(calculatePriceOf(bookOrder), is(51.20f));
    }

    private float calculatePriceOf(BookOrder pedido) {
        return pedido.price();
    }

    @Test
    public void remove_books_by_bookSet() {
        bookOrder.add(2, Book.BOOK1);

        bookOrder.removeBooksBy(BookSet.createBy(bookOrder, 1));

        assertThat(bookOrder.copiesSize(), is(1));
        assertThat(bookOrder.getBookBasket().size(), is(1));
    }

    @Test
    public void remove_books_by_bookSet_with_bookOrder_size() {
        bookOrder.add(1, Book.BOOK1);
        bookOrder.add(1, Book.BOOK2);

        bookOrder.removeBooksBy(BookSet.createBy(bookOrder, 2));

        assertThat(bookOrder.copiesSize(), is(0));
        assertThat(bookOrder.getBookBasket().size(), is(0));
    }
}
