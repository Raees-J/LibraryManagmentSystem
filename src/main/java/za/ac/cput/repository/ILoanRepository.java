package za.ac.cput.repository;

import za.ac.cput.domain.Loan;
import java.util.List;

/**
 * ILoanRepository.java
 * Repository interface for Loan entity
 * Author: Justin Angelo Karoles (222008237)
 * Date: 23 March 2025
 */

public interface ILoanRepository {
    Loan create(Loan loan);
    Loan read(String loanId);
    Loan update(Loan loan);
    boolean delete(String loanId);
    List<Loan> getAll();
}
