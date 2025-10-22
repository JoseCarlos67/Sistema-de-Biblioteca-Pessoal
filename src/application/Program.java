package application;

import entities.*;
import enums.BookGenre;
import exceptions.DomainException;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
  public static void main(String[] args) {
//    ByteArrayInputStream fakeInput = autofillingOfData();
//    System.setIn(fakeInput);

    Scanner scanner = new Scanner(System.in);

    Library myLibary = new Library();

    try {
      registerUser(myLibary, scanner);
      registerBook(myLibary, scanner);
      registerLoanBook(myLibary, scanner);
    } catch (DateTimeParseException e) {
      System.out.println("Formato de data inválido!");
    } catch (DomainException e) {
      System.out.println(e);
    } catch (RuntimeException e) {
      System.out.println("Erro inesperado!");
    }

    System.out.println();

    System.out.println(myLibary.generateReport());

    scanner.close();
  }

  private static ByteArrayInputStream autofillingOfData() {
    String fakeInputString = """
            4
            Larissa Borges
            larissa@gmail.com
            35991919191
            Hokala
            João Silva
            joao.silva@email.com
            35991919192
            JSilva
            Maria Santos
            maria.santos@email.com
            35991919193
            MSantos
            Pedro Oliveira
            pedro.oliveira@email.com
            35991919194
            POliveira
            5
            O senhor dos anéis
            FANTASIA
            29/09/1954
            J.R.R. Tolkien
            tolkien@gmail.com
            Britânico
            1984
            DISTOPIA
            08/06/1949
            George Orwell
            orwell@gmail.com
            Britânico
            Dom Quixote
            ROMANCE
            16/01/1605
            Miguel de Cervantes
            cervantes@gmail.com
            Espanhol
            O pequeno príncipe
            FICCAO
            06/04/1943
            Antoine de Saint-Exupéry
            antoine@gmail.com
            Francês
            Crime e Castigo
            ROMANCE
            01/01/1866
            Fiódor Dostoiévski
            dostoiévski@gmail.com
            Russo
            3
            O senhor dos anéis
            Hokala
            1984
            JSilva
            Dom Quixote
            MSantos
            """;
    return new ByteArrayInputStream(fakeInputString.getBytes());
  }

  public static void registerUser(Library myLibrary, Scanner scanner) {
    System.out.println("=== Registro de Usuário ===");
    System.out.print("Quantos usuários deseja cadastrar? ");
    int qtdUsers = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= qtdUsers; i++) {
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


  }

  public static void registerBook(Library myLibrary, Scanner scanner) throws DateTimeParseException {
    System.out.println("=== Registro de Livro ===");
    System.out.print("Quantos livros deseja registrar? ");
    int qtdBooks = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= qtdBooks; i++) {
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

  private static void registerLoanBook(Library myLibrary, Scanner scanner) {
    System.out.println("=== Empreśtimo ===");
    System.out.print("Quantos emprestimos deseja realizar? ");
    int qtdLoans = scanner.nextInt();
    scanner.nextLine();
    for (int i = 1; i <= qtdLoans; i++) {
      System.out.print("Título do livro: ");
      String titleBook = scanner.nextLine();
      System.out.print("Apelido do comodatário: ");
      String nickNameUser = scanner.nextLine();
      System.out.println(myLibrary.lendBook(titleBook, nickNameUser));
    }
  }
}
