package com.diegomendez40.lms.manager;

import com.diegomendez40.lms.model.Book;
import com.diegomendez40.lms.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryManagerTest {

    private LibraryManager libraryManager;

    @BeforeEach
    void setUp() {
        libraryManager = new LibraryManager();
        libraryManager.addBook(new Book("111", "Test Book to Lend", "Test Author"));
        libraryManager.addBook(new Book("222", "Test Book to Return", "Test Author"));
        libraryManager.addBook(new Book("444", "Test Book never to Lend", "Test Author"));
        libraryManager.addUser(new User("1234", "Pepe"));
    }

    @Test
    void testLendBook() {
        assertTrue(libraryManager.lendBook("111", "1234"), "El libro debe ser prestado exitosamente.");

        // En el futuro: Verificar que el libro ahora está marcado como no disponible
        // (Cuando tenga un método para verificar la disponibilidad)
    }

    @Test
    void testLendBookNotAvailable() {
        libraryManager.lendBook("333", "1234");
        assertFalse(libraryManager.lendBook("333", "1234"), "El libro no debe estar disponible para prestar.");
    }

    @Test
    void testReturnBook() {
        libraryManager.lendBook("222", "1234");
        assertTrue(libraryManager.returnBook("222"), "El libro debe ser devuelto exitosamente.");
    }

    @Test
    void testReturnBookNotLent() {
        assertFalse(libraryManager.returnBook("444"), "No se debe poder devolver un libro que no estaba prestado.");
    }
}
