package entities;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan {
  private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

  private LocalDate startDate, dueDate, returnDate;
  private Boolean active;

  private Book book;
  private User user;

  public Loan() {
  }

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

  public Book getBook() {
    return book;
  }

  public User getUser() {
    return user;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  @Override
  public String toString() {
    return book.getTitle() +
            " emprestado para " + user.getNickName() +
            " em " + startDate.format(fmt) +
            " e deve ser devolvido em " + dueDate.format(fmt);
  }
}
