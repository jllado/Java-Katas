package katas.potter;

public class Book {
    public static final int PRIZE = 8;

    public static final String BOOK1 = "Book 1";
    public static final String BOOK2 = "Book 2";
    public static final String BOOK3 = "Book 3";
    public static final String BOOK4 = "Book 4";
    public static final String BOOK5 = "Book 5";

    private String title = "";

    public Book(String title) {
        this.title = title;
    }

    public final String getTitle() {
        return title;
    }

}
