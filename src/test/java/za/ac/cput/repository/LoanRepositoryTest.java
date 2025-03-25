package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Loan;
import za.ac.cput.factory.LoanFactory;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


/**
 * LoanRepositoryTest.java
 * Test class for the LoanRepository
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 * */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class LoanRepositoryTest {
    private static LoanRepository loanRepository;
    private static Loan loan1, loan2;

    @BeforeAll
    public static void setUp() {
        loanRepository = LoanRepository.getRepository(); // ✅ Correct singleton access
        loan1 = LoanFactory.createLoan("L001", 10000, 5.5, 12);
        loan2 = LoanFactory.createLoan("L002", 5000, 6.0, 24);
    }

    @BeforeEach
    public void resetRepository() {
        loanRepository.getAll().forEach(loan -> loanRepository.delete(loan.getLoanId())); // ✅ Clears repo before each test
    }

    @Test
    @Order(1)
    public void testCreateLoan() {
        Loan createdLoan1 = loanRepository.create(loan1);
        Loan createdLoan2 = loanRepository.create(loan2);

        System.out.println("Created Loan 1: " + createdLoan1);
        System.out.println("Created Loan 2: " + createdLoan2);

        assertNotNull(createdLoan1);
        assertNotNull(createdLoan2);
        assertEquals(2, loanRepository.getAll().size());
    }

    @Test
    @Order(2)
    public void testReadLoan() {
        loanRepository.create(loan1);
        Loan loan = loanRepository.read("L001");

        System.out.println("Read Loan: " + loan);
        assertNotNull(loan);
        assertEquals("L001", loan.getLoanId());
    }

    @Test
    @Order(3)
    public void testUpdateLoan() {
        loanRepository.create(loan1);
        System.out.println("Before update: " + loanRepository.read("L001"));

        Loan updatedLoan = LoanFactory.createLoan("L001", 12000, 5.0, 18);
        Loan result = loanRepository.update(updatedLoan);

        System.out.println("Updated Loan: " + result);
        assertNotNull(result);

        Loan fetchedLoan = loanRepository.read("L001");
        assertEquals(12000, fetchedLoan.getAmount());
        assertEquals(5.0, fetchedLoan.getInterestRate(), 0.01); //  Floating-point comparison fix
        assertEquals(18, fetchedLoan.getTermInMonths());
    }

    @Test
    @Order(4)
    public void testDeleteLoan() {
        loanRepository.create(loan1);
        loanRepository.create(loan2);

        System.out.println("Loans before deletion: " + loanRepository.getAll());
        boolean isDeleted = loanRepository.delete("L002");

        System.out.println("Deleted Loan L002: " + isDeleted);
        assertTrue(isDeleted);
        assertNull(loanRepository.read("L002"));

        System.out.println("Loans after deletion: " + loanRepository.getAll());
        assertEquals(1, loanRepository.getAll().size()); //  Ensure only one loan remains
    }

    @Test
    @Order(5)
    public void testGetAllLoans() {
        loanRepository.create(loan1);
        loanRepository.create(loan2);

        List<Loan> loans = loanRepository.getAll();
        System.out.println("All Loans: " + loans);

        assertEquals(2, loans.size()); //  Corrected assertion
        assertTrue(loans.contains(loan1));
        assertTrue(loans.contains(loan2));
    }
}
