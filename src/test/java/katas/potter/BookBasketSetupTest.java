package katas.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BookBasketSetupTest {

    private BookBasketSetup basketSetup;
    private BookOrder bookOrder;

    @Before
    public void setUp() {
        bookOrder = new BookOrder();
        bookOrder.add(2, Book.BOOK1);
        bookOrder.add(2, Book.BOOK3);
        bookOrder.add(2, Book.BOOK2);
        bookOrder.add(1, Book.BOOK4);
        bookOrder.add(1, Book.BOOK5);
    }

    @Test
    public void get_basketSetup_with_bookSetSize_one() {
        basketSetup = BookBasketSetup.createBy(bookOrder, 1);

        assertThat(basketSetup.getBookSets().size(), is(8));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_two() {
        basketSetup = BookBasketSetup.createBy(bookOrder, 2);

        assertThat(basketSetup.getBookSets().size(), is(4));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_three() {
        basketSetup = BookBasketSetup.createBy(bookOrder, 3);

        assertThat(basketSetup.getBookSets().size(), is(3));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_four() {
        basketSetup = BookBasketSetup.createBy(bookOrder, 4);

        assertThat(basketSetup.getBookSets().size(), is(2));
    }

    @Test
    public void get_basketSetup_with_bookSetSize_five() {
        basketSetup = BookBasketSetup.createBy(bookOrder, 5);

        assertThat(basketSetup.getBookSets().size(), is(2));
    }
}
