package application;

import entities.Author;
import entities.Book;
import entities.Library;
import entities.User;
import enums.BookGenre;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library myLibary = new Library();

//        registerUser(myLibary, scanner);
        registerBook(myLibary, scanner);
        scanner.close();
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

        Book newBook = new Book(titleBook, bookGenre,publishDate, author);
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
}
