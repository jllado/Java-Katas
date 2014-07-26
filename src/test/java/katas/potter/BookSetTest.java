package katas.potter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BookSetTest {

    private BookOrder bookOrder;
    private BookSet bookSet;

    @Before
    public void setUp() {
        bookOrder = new BookOrder();
        bookOrder.add(2, new Book(Book.BOOK1));
        bookOrder.add(2, new Book(Book.BOOK3));
        bookOrder.add(2, new Book(Book.BOOK2));
        bookOrder.add(1, new Book(Book.BOOK4));
        bookOrder.add(1, new Book(Book.BOOK5));
    }

    @Test
    public void get_bookSet_with_bookSetSize_one() {
        bookSet = BookSet.createBy(bookOrder, 1);
        assertThat(bookSet.books().size(), is(1));
    }

    @Test
    public void get_bookSet_with_bookSetSize_two() {
        bookSet = BookSet.createBy(bookOrder, 2);
        assertThat(bookSet.books().size(), is(2));
    }

    @Test
    public void get_bookSet_with_bookSetSize_three() {
        bookSet = BookSet.createBy(bookOrder, 3);
        assertThat(bookSet.books().size(), is(3));
    }

    @Test
    public void get_bookSet_with_bookSetSize_four() {
        bookSet = BookSet.createBy(bookOrder, 4);
        assertThat(bookSet.books().size(), is(4));
    }

    @Test
    public void get_bookSet_with_bookSetSize_five() {
        bookSet = BookSet.createBy(bookOrder, 5);
        assertThat(bookSet.books().size(), is(5));
    }

    @Test
    public void obtener_paquete_con_tamaño_seis() {
        bookSet = BookSet.createBy(bookOrder, 6);
        assertThat(bookSet.books().size(), is(5));
    }

}
