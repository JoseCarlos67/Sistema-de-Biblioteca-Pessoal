package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> bookList = new ArrayList<>();
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

        if (book == null || user == null || !book.getAvailable()) {
            return "Falha no empréstimo!";
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
        return null;
    }

    public User findUserByNickName(String nickName) {
        for (User user : userList) {
            if (user.getNickName().equals(nickName))
                return user;
        }
        return null;
    }

    public List<Book> listAvailableBooks() {
        List<Book> availableBooksList = new ArrayList<>();

        for (Book book : bookList) {
            if (book.getAvailable())
                availableBooksList.add(book);
        }

        return availableBooksList;
    }

    public List<Book> listBorrowedBooks() {
        List<Book> borrowedBooksList = new ArrayList<>();

        for (Book book : bookList) {
            if (!book.getAvailable())
                borrowedBooksList.add(book);
        }

        return borrowedBooksList;
    }
}
