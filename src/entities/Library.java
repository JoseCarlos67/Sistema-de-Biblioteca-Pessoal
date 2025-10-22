package entities;

import exceptions.DomainException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
  public List<Book> bookList = new ArrayList<>();
  private List<User> userList = new ArrayList<>();
  private List<Loan> loanList = new ArrayList<>();

  public void registerBook(Book newBook) {
    bookList.add(newBook);
  }

  public void registerUser(User newUser) {
    userList.add(newUser);
  }

  public String lendBook(String bookTitle, String nickName) {
    Book book = findBookByTitle(bookTitle);
    User user = findUserByNickName(nickName);

    if (!book.getAvailable()) {
      throw new DomainException("Livro não disponível!");
    }

    Loan newLoan = new Loan(book, user, LocalDate.now(), LocalDate.now().plusDays(7));
    loanList.add(newLoan);
    book.lend();
    return "Sucesso no empréstimo!";
  }

  public Book findBookByTitle(String bookTitle) {
    for (Book book : bookList) {
      if (book.getTitle().equals(bookTitle))
        return book;
    }
    throw  new DomainException("Livro não encontrado!");
  }

  public User findUserByNickName(String nickName) {
    for (User user : userList) {
      if (user.getNickName().equals(nickName))
        return user;
    }
    throw new DomainException("Usuário não encontrado!");
  }

  public List<Book> listAvailableBooks() {
    List<Book> availableBooksList = new ArrayList<>();
    for (Book book : bookList) {
      if (book.getAvailable())
        availableBooksList.add(book);
    }

    return availableBooksList;
  }

  public List<Loan> listBorrowedBooks() {
    return loanList;
  }

  public String generateReport() {
    StringBuilder sb = new StringBuilder();

    sb.append("\n=== Estado Atual da Bíblioteca ===\n");

    sb.append("--- Usuários ---\n");
    if (userList.isEmpty())
      sb.append("(Nenhum usário cadastrado)");
    else {
      int i = 1;
      for (User user : userList) {
        sb.append(i++).append(". ")
                .append(user.getName())
                .append(" (")
                .append(user.getNickName())
                .append(")\n");
      }
    }

    sb.append("\n--- Livros ---\n");
    if (bookList.isEmpty())
      sb.append("(nenhum livro cadastrado)\n");
    else {
      int i = 1;
      for (Book book : bookList) {
        sb.append(i++).append(". ")
                .append(book.getTitle())
                .append(" (")
                .append(book.getAvailable() ? "disponível" : "emprestado")
                .append(")\n");
      }
    }

    sb.append("\n--- Empréstimos Ativos ---\n");
    if (loanList.isEmpty())
      sb.append("(nenhum empréstimo ativo)\n");
    else {
      int i = 1;
      for (Loan loan : loanList) {
        sb.append(i++).append(". Livro: ")
                .append(loan.getBook().getTitle())
                .append(" | Usuário: ")
                .append(loan.getUser().getNickName())
                .append(" | Empréstimo: ")
                .append(loan.getStartDate())
                .append(" | Devolução: ")
                .append(loan.getDueDate())
                .append("\n");
      }
    }

    return sb.toString();
  }
}
