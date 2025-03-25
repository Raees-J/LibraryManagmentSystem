package za.ac.cput.factory;

import za.ac.cput.domain.Loan;

/**
 * LoanFactory.java
 * Loan class for creating Loan objects
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 */

public class LoanFactory {
    public static Loan createLoan(String loanId, double amount, double interestRate, int termInMonths) {
        // Add validation to check for invalid loan parameters
        if (loanId == null || loanId.isEmpty() || amount <= 0 || interestRate <= 0 || termInMonths <= 0) {
            throw new IllegalArgumentException("Invalid loan parameters");
        }
        return new Loan.Builder()
                .setLoanId(loanId)
                .setAmount(amount)
                .setInterestRate(interestRate)
                .setTermInMonths(termInMonths)
                .build();
    }
}
