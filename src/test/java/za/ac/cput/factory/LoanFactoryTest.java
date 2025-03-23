package za.ac.cput.factory;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Loan;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author - Justin Angelo Karoles 222008237
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoanFactoryTest {
    private static Loan loan1 = LoanFactory.createLoan("L001", 10000, 5.5, 12);
    private static Loan loan2 = LoanFactory.createLoan("L002", 5000, 6.0, 24);
    private static Loan loan3 = LoanFactory.createLoan("L003", 1000, 5.5, 12); // Invalid loan

    @Test
    @Order(1)
    public void testCreateLoan_ValidParameters() {
        assertNotNull(loan1);
        System.out.println(loan1.toString());
        assertEquals("L001", loan1.getLoanId());
        assertEquals(10000, loan1.getAmount());
        assertEquals(5.5, loan1.getInterestRate());
        assertEquals(12, loan1.getTermInMonths());
    }

    @Test
    @Order(2)
    public void testCreateLoan_AnotherValidLoan() {
        assertNotNull(loan2);
        System.out.println(loan2.toString());
        assertEquals("L002", loan2.getLoanId());
        assertEquals(5000, loan2.getAmount());
        assertEquals(6.0, loan2.getInterestRate());
        assertEquals(24, loan2.getTermInMonths());
    }

    @Test
    @Order(3)
    public void testCreateLoan_InvalidLoan() {
        assertThrows(IllegalArgumentException.class, () -> {
            LoanFactory.createLoan("L003", -1000, -5.5, 12);  // This should throw an exception due to invalid parameters
        });
    }
}
