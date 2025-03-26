package za.ac.cput.repository;

import za.ac.cput.domain.BookLoan;
import java.util.*;

/**
 * BookLoanRepository.java
 * Repository class for BookLoan entity
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 */

public class BookLoanRepository implements IBookLoanRepository {
    private static BookLoanRepository repository = null;
    private final Map<String, BookLoan> bookLoanMap;

    private BookLoanRepository() {
        bookLoanMap = new HashMap<>();
    }

    public static BookLoanRepository getRepository() {
        if (repository == null) {
            repository = new BookLoanRepository();
        }
        return repository;
    }

    // Create a new book loan (only if it doesn't already exist)
    @Override
    public BookLoan create(BookLoan bookLoan) {
        if (bookLoanMap.containsKey(bookLoan.getLoanId())) {
            return null;
        }
        bookLoanMap.put(bookLoan.getLoanId(), bookLoan);
        return bookLoan;
    }

    // Read a book loan by its ID
    @Override
    public BookLoan read(String loanId) {
        return bookLoanMap.get(loanId);
    }

    // Update an existing book loan (only if it exists)
    @Override
    public BookLoan update(BookLoan bookLoan) {
        if (!bookLoanMap.containsKey(bookLoan.getLoanId())) {
            return null;
        }
        bookLoanMap.put(bookLoan.getLoanId(), bookLoan);
        return bookLoan;
    }

    // Delete a book loan by its ID
    @Override
    public boolean delete(String loanId) {
        return bookLoanMap.remove(loanId) != null;
    }

    // Get all book loans
    @Override
    public List<BookLoan> getAll() {
        return new ArrayList<>(bookLoanMap.values());
    }

    // Get all book loans for a specific member
    @Override
    public List<BookLoan> getLoansByMemberId(String memberId) {
        List<BookLoan> memberBookLoans = new ArrayList<>();
        for (BookLoan bookLoan : bookLoanMap.values()) {
            if (bookLoan.getMemberId().equals(memberId)) {
                memberBookLoans.add(bookLoan);
            }
        }
        return memberBookLoans;
    }

    // Get all active book loans (not returned yet)
    @Override
    public List<BookLoan> getActiveLoans() {
        List<BookLoan> activeBookLoans = new ArrayList<>();
        for (BookLoan bookLoan : bookLoanMap.values()) {
            if (!bookLoan.isReturned()) {
                activeBookLoans.add(bookLoan);
            }
        }
        return activeBookLoans;
    }
}
