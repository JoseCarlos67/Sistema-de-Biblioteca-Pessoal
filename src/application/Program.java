package application;

import entities.*;
import enums.BookGenre;

import java.io.ByteArrayInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
    ByteArrayInputStream fakeInput = autofillingOfData();
    System.setIn(fakeInput);

    Scanner scanner = new Scanner(System.in);

    Library myLibary = new Library();

    registerUser(myLibary, scanner);
    registerBook(myLibary, scanner);
    String resultLoan = registerLoanBook(myLibary, scanner);
    System.out.println(resultLoan);


    System.out.println();

    List<Loan> borrewedBooks = new ArrayList<>();
    borrewedBooks = myLibary.listBorrowedBooks();
    for (Loan book : borrewedBooks) {
      System.out.println(book);
    }


    scanner.close();
  }

  private static ByteArrayInputStream autofillingOfData() {
    String fakeInputString = """
            Larissa Borges
            larissa@gmail.com
            35991919191
            Hokala
            O senhor dos anéis
            FANTASI
            29/07/1954
            J.R.R. Tolkien
            tolkien@gmail.com
            Britânico
            O senhor dos anéis
            Hokala
            """;
    return new ByteArrayInputStream(fakeInputString.getBytes());
  }

  public static void registerUser(Library myLibrary, Scanner scanner) {
    System.out.println("=== Registro de Usuário ===");
    System.out.print("Nome: ");
    String nameUser = scanner.nextLine();
    System.out.print("E-mail: ");
    String emailUer = scanner.nextLine();
    System.out.print("Telefone: ");
    String phoneNumerUser = scanner.nextLine();
    System.out.print("Apelido: ");
    String nickNameUser = scanner.nextLine();

    User newUser = new User(nameUser, emailUer, phoneNumerUser, nickNameUser);

    myLibrary.registerUser(newUser);
  }

  public static void registerBook(Library myLibrary, Scanner scanner) {
    System.out.println("=== Registro de Livro ===");
    System.out.print("Título: ");
    String titleBook = scanner.nextLine();
    System.out.print("Gênero: ");
    BookGenre bookGenre = BookGenre.valueOf(scanner.nextLine());
    System.out.print("Data de publicação: ");
    String publishDateString = scanner.nextLine();
    DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate publishDate = LocalDate.parse(publishDateString, fmt1);

    Author author = registerAuthor(scanner);

    Book newBook = new Book(titleBook, bookGenre, publishDate, author);
    myLibrary.registerBook(newBook);
  }

  public static Author registerAuthor(Scanner scanner) {
    System.out.println("--- Registro de Autor ---");
    System.out.print("Nome: ");
    String nameAuthor = scanner.nextLine();
    System.out.print("E-mail: ");
    String emailAuthor = scanner.nextLine();
    System.out.print("Nacionalidade: ");
    String nationalityAuthor = scanner.nextLine();
    return new Author(nameAuthor, emailAuthor, nationalityAuthor);
  }

  private static String registerLoanBook(Library myLibrary, Scanner scanner) {
    System.out.println("=== Empreśtimo ===");
    System.out.print("Título do livro: ");
    String titleBook = scanner.nextLine();
    System.out.print("Apelido do comodatário: ");
    String nickNameUser = scanner.nextLine();

    return myLibrary.lendBook(titleBook, nickNameUser);
  }
}
