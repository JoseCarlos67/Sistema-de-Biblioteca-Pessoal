package application;

import entities.Library;
import entities.User;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Library myLibary = new Library();

        registerUser(myLibary, scanner);

        scanner.close();
    }

    public static void registerUser(Library myLibrary, Scanner scanner) {
        System.out.println("=== Registro de Usuário +++");
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
