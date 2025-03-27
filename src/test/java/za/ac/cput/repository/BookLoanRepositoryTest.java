package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.BookLoan;
import za.ac.cput.factory.BookLoanFactory;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.List;

/**
 * LoanRepositoryTest.java
 * Test class for the LoanRepository
 * Author: Justin Angelo Karoles (222008237)
 * Date: 25 March 2025
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookLoanRepositoryTest {
    private static BookLoanRepository bookLoanRepository;
    private static BookLoan bookLoan1, bookLoan2;

    @BeforeAll
    public static void setUp() {
        bookLoanRepository = BookLoanRepository.getRepository();

        bookLoan1 = BookLoanFactory.createLoan("L01", "B01", "M01",
                LocalDate.of(2025, 9, 20), LocalDate.of(2025, 3, 15), false);

        bookLoan2 = BookLoanFactory.createLoan("L02", "B02", "M02",
                LocalDate.of(2025, 3, 5), LocalDate.of(2025, 3, 20), false);
    }

    @BeforeEach
    public void resetRepository() {
        bookLoanRepository.getAll().forEach(loan -> bookLoanRepository.delete(loan.getLoanId()));
    }

    @Test
    @Order(1)
    public void testCreateLoan() {
        BookLoan createdBookLoan1 = bookLoanRepository.create(bookLoan1);
        BookLoan createdBookLoan2 = bookLoanRepository.create(bookLoan2);

        System.out.println("Created Loan 1: " + createdBookLoan1);
        System.out.println("Created Loan 2: " + createdBookLoan2);

        assertNotNull(createdBookLoan1);
        assertNotNull(createdBookLoan2);
        assertEquals(2, bookLoanRepository.getAll().size());
    }

    @Test
    @Order(2)
    public void testReadLoan() {
        bookLoanRepository.create(bookLoan1);
        BookLoan bookLoan = bookLoanRepository.read("L01");

        System.out.println("Read Loan: " + bookLoan);
        assertNotNull(bookLoan);
        assertEquals("L01", bookLoan.getLoanId());
        assertEquals("B01", bookLoan.getBookId());
        assertEquals("M01", bookLoan.getMemberId());
    }

    @Test
    @Order(3)
    public void testUpdateLoan() {
        bookLoanRepository.create(bookLoan1);
        System.out.println("Before update: " + bookLoanRepository.read("L01"));

        BookLoan updatedBookLoan = BookLoanFactory.createLoan("L01", "B01", "M01",
                LocalDate.of(2025, 3, 1), LocalDate.of(2025, 3, 18), true);
        BookLoan result = bookLoanRepository.update(updatedBookLoan);

        System.out.println("Updated Loan: " + result);
        assertNotNull(result);

        BookLoan fetchedBookLoan = bookLoanRepository.read("L01");
        assertEquals(LocalDate.of(2025, 3, 18), fetchedBookLoan.getReturnDate());
        assertTrue(fetchedBookLoan.isReturned());
    }

    @Test
    @Order(4)
    public void testDeleteLoan() {
        bookLoanRepository.create(bookLoan1);
        bookLoanRepository.create(bookLoan2);

        System.out.println("Loans before deletion: " + bookLoanRepository.getAll());
        boolean isDeleted = bookLoanRepository.delete("L02");

        System.out.println("Deleted Loan L02: " + isDeleted);
        assertTrue(isDeleted);
        assertNull(bookLoanRepository.read("L02"));

        System.out.println("Loans after deletion: " + bookLoanRepository.getAll());
        assertEquals(1, bookLoanRepository.getAll().size());
    }

    @Test
    @Order(5)
    public void testGetAllLoans() {
        bookLoanRepository.create(bookLoan1);
        bookLoanRepository.create(bookLoan2);

        List<BookLoan> bookLoans = bookLoanRepository.getAll();
        System.out.println("All Loans: " + bookLoans);

        assertEquals(2, bookLoans.size());
        assertTrue(bookLoans.contains(bookLoan1));
        assertTrue(bookLoans.contains(bookLoan2));
    }
}
