package katas.potter;

public enum Book {
    BOOK1("Book 1"), BOOK2("Book 2"), BOOK3("Book 3"), BOOK4("Book 4"), BOOK5("Book 5");
    
    private final String tittle;

    Book(String title) {
        this.tittle = title;
    }
}
