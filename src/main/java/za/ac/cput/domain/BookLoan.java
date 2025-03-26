package za.ac.cput.domain;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Loan.java
 * Domain class for BookLoan
 * Author: Justin Angelo Karoles (222008237)
 * Date: 15 March 2025
 */

public class BookLoan {
    private String loanId;
    private String bookId;
    private String memberId;
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean isReturned;

    private BookLoan(Builder builder) {
        this.loanId = builder.loanId;
        this.bookId = builder.bookId;
        this.memberId = builder.memberId;
        this.loanDate = builder.loanDate;
        this.returnDate = builder.returnDate;
        this.isReturned = builder.isReturned;
    }

    public String getLoanId() {
        return loanId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getMemberId() {
        return memberId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLoan bookLoan = (BookLoan) o;
        return Objects.equals(loanId, bookLoan.loanId);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", bookId='" + bookId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", isReturned=" + isReturned +
                '}';
    }

    public static class Builder {
        private String loanId;
        private String bookId;
        private String memberId;
        private LocalDate loanDate;
        private LocalDate returnDate;
        private boolean isReturned;

        public Builder setLoanId(String loanId) {
            this.loanId = loanId;
            return this;
        }

        public Builder setBookId(String bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setMemberId(String memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder setLoanDate(LocalDate loanDate) {
            this.loanDate = loanDate;
            return this;
        }

        public Builder setReturnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder setReturned(boolean isReturned) {
            this.isReturned = isReturned;
            return this;
        }

        public BookLoan build() {
            if (loanId == null || bookId == null || memberId == null || loanDate == null) {
                throw new IllegalArgumentException("Invalid loan parameters");
            }
            return new BookLoan(this);
        }
    }
}