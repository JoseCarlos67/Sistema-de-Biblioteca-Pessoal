package entities;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan {
    private LocalDate startDate, dueDate, returnDate;
    private Boolean active;

    private Book book;
    private User user;

    public Loan() {}

    public Loan(Book book, User user, LocalDate startDate, LocalDate dueDate) {
        this.book = book;
        this.user = user;
        this.startDate = startDate;
        this.dueDate = dueDate;
        active = true;
    }

    public void closeLoan() {
        returnDate = LocalDate.now();
        active = false;
        book.returnBook();
    }

    public boolean isOverdue() {
        return active && LocalDate.now().isAfter(this.dueDate);
    }
}
