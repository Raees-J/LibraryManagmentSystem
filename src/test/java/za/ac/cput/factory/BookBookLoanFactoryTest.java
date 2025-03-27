package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.BookLoan;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * LoanFactoryTest.java
 * Test class for the LoanFactory in a Library Management System
 * Author: Justin Angelo Karoles (222008237)
 * Date: 25 March 2025
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookBookLoanFactoryTest {
    private static BookLoan bookLoan1;
    private static BookLoan bookLoan2;
    private static BookLoan bookLoan3;

    @BeforeAll
    public static void setUp() {
        bookLoan1 = BookLoanFactory.createLoan("L01", "B01", "M01", LocalDate.of(2025, 5, 5), LocalDate.of(2025, 3, 15), false);
        bookLoan2 = BookLoanFactory.createLoan("L02", "B02", "M02", LocalDate.of(2025, 3, 5), LocalDate.of(2025, 3, 20), true);
        bookLoan3 = BookLoanFactory.createLoan("", "B03", "M03", null, LocalDate.of(2025, 3, 25), false);
    }

    @Test
    @Order(1)
    public void testCreateLoan_ValidLoan() {
        assertNotNull(bookLoan1);
        System.out.println(bookLoan1.toString());
        assertEquals("L01", bookLoan1.getLoanId());
        assertEquals("B01", bookLoan1.getBookId());
        assertEquals("M01", bookLoan1.getMemberId());
        assertEquals(LocalDate.of(2025, 5, 5), bookLoan1.getLoanDate());
        assertEquals(LocalDate.of(2025, 3, 15), bookLoan1.getReturnDate());
        assertFalse(bookLoan1.isReturned());
    }

    @Test
    @Order(2)
    public void testCreateLoan_AnotherValidLoan() {
        assertNotNull(bookLoan2);
        System.out.println(bookLoan2.toString());
        assertEquals("L02", bookLoan2.getLoanId());
        assertEquals("B02", bookLoan2.getBookId());
        assertEquals("M02", bookLoan2.getMemberId());
        assertEquals(LocalDate.of(2025, 3, 5), bookLoan2.getLoanDate());
        assertEquals(LocalDate.of(2025, 3, 20), bookLoan2.getReturnDate());
        assertTrue(bookLoan2.isReturned());
    }

    @Test
    @Order(3)
    public void testCreateLoan_InvalidLoan_EmptyLoanId_NullLoanDate() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // create an invalid loan
            bookLoan3 = BookLoanFactory.createLoan("", "B003", "M006", null, LocalDate.of(2025, 3, 25), false);
        });
        System.out.println("Exception caught: " + exception.getMessage());
        assertEquals("Invalid loan details: loanId, bookId, memberId, or loanDate cannot be null or empty.", exception.getMessage());
    }

}
