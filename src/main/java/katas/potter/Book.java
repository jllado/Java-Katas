package katas.potter;

public class Book {

    public static final Book BOOK1 = new Book("Book 1");
    public static final Book BOOK2 = new Book("Book 2");
    public static final Book BOOK3 = new Book("Book 3");
    public static final Book BOOK4 = new Book("Book 4");
    public static final Book BOOK5 = new Book("Book 5");

    private final String title;

    public Book(String title) {
        this.title = title;
    }

}
