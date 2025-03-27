package za.ac.cput.factory;

import za.ac.cput.domain.BookLoan;
import za.ac.cput.util.Helper;
import java.time.LocalDate;

/**
 * LoanFactory.java
 * Factory class for creating Loan objects in a Library Management System
 * Author: Justin Angelo Karoles (222008237)
 * Date: 17 March 2025
 */

public class BookLoanFactory {
    public static BookLoan createLoan(String loanId, String bookId, String memberId, LocalDate loanDate, LocalDate returnDate, boolean isReturned) {
        if (isInvalidLoan(loanId, bookId, memberId, loanDate)) {
            return null;
        }

        return new BookLoan.Builder()
                .setLoanId(loanId)
                .setBookId(bookId)
                .setMemberId(memberId)
                .setLoanDate(loanDate)
                .setReturnDate(returnDate)
                .setReturned(isReturned)
                .build();
    }

    private static boolean isInvalidLoan(String loanId, String bookId, String memberId, LocalDate loanDate) {
        return Helper.isNullOrEmpty(loanId) || Helper.isNullOrEmpty(bookId) || Helper.isNullOrEmpty(memberId) || loanDate == null;
    }
}


