package za.ac.cput.factory;

import za.ac.cput.domain.Loan;
import za.ac.cput.util.Helper;

/**
 * LoanFactory.java
 * Loan class for creating Loan objects
 * Author: Justin Angelo Karoles (222008237)
 * Date: 17 March 2025
 */

public class LoanFactory {
    public static Loan createLoan(String loanId, double amount, double interestRate, int termInMonths) {
        if (isInvalidLoan(loanId, amount, interestRate, termInMonths)) {
            return null;
        }

        return new Loan.Builder()
                .setLoanId(loanId)
                .setAmount(amount)
                .setInterestRate(interestRate)
                .setTermInMonths(termInMonths)
                .build();
    }

    private static boolean isInvalidLoan(String loanId, double amount, double interestRate, int termInMonths) {
        return Helper.isNullOrEmpty(loanId) || amount <= 0 || interestRate <= 0 || termInMonths <= 0;
    }
}
