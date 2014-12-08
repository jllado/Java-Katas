package katas.potter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by jllado on 8/12/14.
 */
public class BookBasket {
    private Map<Book, Integer> values;
    private int copiesSize = 0;

    public BookBasket() {
        this.values = new LinkedHashMap<>();
    }

    public BookBasket(BookBasket basket) {
        this.values = new LinkedHashMap<>(basket.values);
        this.copiesSize = basket.copiesSize;
    }

    public void add(Book book, int size) {
        values.put(book, size);
        copiesSize += size;
    }

    public Set<Book> books() {
        return values.keySet();
    }

    private int sizeOf(Book book) {
        return values.get(book);
    }

    public void remove(Book book) {
        copiesSize--;
        values.put(book, sizeOf(book) - 1);
        if (sizeOf(book) == 0) {
            values.remove(book);
        }
    }

    public int size() {
        return values.size();
    }

    public int copiesSize() {
        return copiesSize;
    }
}
