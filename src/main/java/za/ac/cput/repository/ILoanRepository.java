package za.ac.cput.repository;

import za.ac.cput.domain.Loan;
import java.util.List;

/**
 * @author - Justin Angelo Karoles 222008237
 */

public interface ILoanRepository {
    Loan create(Loan loan);
    Loan read(String loanId);
    Loan update(Loan loan);
    boolean delete(String loanId);
    List<Loan> getAll();
}
