package za.ac.cput.repository;

import za.ac.cput.domain.BookLoan;
import java.util.List;

/**
 * IBookLoanRepository.java
 * Repository interface for BookLoan entity
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 */

public interface IBookLoanRepository {
    BookLoan create(BookLoan bookLoan);
    BookLoan read(String loanId);
    BookLoan update(BookLoan bookLoan);
    boolean delete(String loanId);
    List<BookLoan> getAll();

    // Additional methods for Library Management System
    List<BookLoan> getLoansByMemberId(String memberId);
    List<BookLoan> getActiveLoans();
}

