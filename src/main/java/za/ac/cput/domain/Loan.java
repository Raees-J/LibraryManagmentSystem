package za.ac.cput.domain;

import java.util.Objects;

/**
 * @author - Justin Angelo Karoles 222008237
 */

public class Loan {
    private String loanId;
    private double amount;
    private double interestRate;
    private int termInMonths;

    private Loan(Builder builder) {
        this.loanId = builder.loanId;
        this.amount = builder.amount;
        this.interestRate = builder.interestRate;
        this.termInMonths = builder.termInMonths;
    }

    public String getLoanId() {
        return loanId;
    }

    public double getAmount() {
        return amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTermInMonths() {
        return termInMonths;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(loanId, loan.loanId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId='" + loanId + '\'' +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", termInMonths=" + termInMonths +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String loanId;
        private double amount;
        private double interestRate;
        private int termInMonths;

        public Builder setLoanId(String loanId) {
            this.loanId = loanId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setInterestRate(double interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder setTermInMonths(int termInMonths) {
            this.termInMonths = termInMonths;
            return this;
        }

        public Loan build() {
            if (loanId == null || loanId.isEmpty() || amount <= 0 || interestRate <= 0 || termInMonths <= 0) {
                throw new IllegalArgumentException("Invalid loan parameters");
            }
            return new Loan(this);
        }
    }
}
