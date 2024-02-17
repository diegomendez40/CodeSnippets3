package com.diegomendez40.lms.ui;

import com.diegomendez40.lms.manager.LibraryManager;
import com.diegomendez40.lms.model.Book;

import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private final LibraryManager libraryManager = new LibraryManager();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("Bienvenido a la Gestión de la Biblioteca");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consumir línea restante

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    searchBookByTitle();
                    break;
                case 3:
                    lendBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void addBook() {
        System.out.println("Agregar nuevo libro");
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Título: ");
        String title = scanner.nextLine();
        System.out.print("Autor: ");
        String author = scanner.nextLine();

        Book newBook = new Book(isbn, title, author);
        libraryManager.addBook(newBook);
        System.out.println("Libro agregado exitosamente.");
    }

    private void searchBookByTitle() {
        System.out.println("Buscar libro por título");
        System.out.print("Título: ");
        String title = scanner.nextLine();

        List<Book> foundBooks = libraryManager.searchBooksByTitle(title);
        if (foundBooks.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Libros encontrados:");
            foundBooks.forEach(book -> System.out.println(book.toString()));
        }
    }

    private void lendBook() {
        System.out.println("Prestar libro");
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();
        System.out.print("ID del Usuario: ");
        String userId = scanner.nextLine();

        boolean result = libraryManager.lendBook(isbn, userId);
        if (result) {
            System.out.println("Libro prestado exitosamente.");
        } else {
            System.out.println("No se pudo prestar el libro. Verifique que el ISBN y el ID del usuario sean correctos y que el libro esté disponible.");
        }
    }

    private void returnBook() {
        System.out.println("Devolver libro");
        System.out.print("ISBN del libro: ");
        String isbn = scanner.nextLine();

        boolean result = libraryManager.returnBook(isbn);
        if (result) {
            System.out.println("Libro devuelto exitosamente.");
        } else {
            System.out.println("No se pudo devolver el libro. Verifique que el ISBN sea correcto y que el libro estuviera prestado.");
        }
    }
}
