package za.ac.cput.repository;

import za.ac.cput.domain.Loan;
import java.util.*;

/**
 * LoanRepository.java
 * Repository class for Loan entity
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 */

public class LoanRepository implements ILoanRepository {
    private static LoanRepository repository = null;
    private Map<String, Loan> loanMap;


    private LoanRepository() {
        loanMap = new HashMap<>();
    }


    public static LoanRepository getRepository() {
        if (repository == null) {
            repository = new LoanRepository();
        }
        return repository;
    }

    // Create a new loan (only if it doesn't already exist)
    @Override
    public Loan create(Loan loan) {
        if (loanMap.containsKey(loan.getLoanId())) {
            return null;  // Prevent duplicate loans
        }
        loanMap.put(loan.getLoanId(), loan);
        return loan;
    }

    // Read a loan by its ID
    @Override
    public Loan read(String loanId) {
        return loanMap.get(loanId);
    }

    // Update an existing loan
    @Override
    public Loan update(Loan loan) {
        if (!loanMap.containsKey(loan.getLoanId())) {
            return null;
        }
        loanMap.put(loan.getLoanId(), loan); // Replace existing loan
        return loan;
    }

    // Delete a loan by its ID
    @Override
    public boolean delete(String loanId) {
        return loanMap.remove(loanId) != null;
    }

    // Get all loans
    @Override
    public List<Loan> getAll() {
        return new ArrayList<>(loanMap.values());
    }
}

