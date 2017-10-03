package mx.datafit.escolarex.entities;

/**
 * Created by Gerardo on 15/08/2017.
 */

public class AccountStatus {
    public AccountStatus() {
    }

    private String conceptAccount,chargeNumber,paymentAmount,amountPaid,paymentDate,chargeDate,paymentMethod,paymentReference,transactionCode;
    public String getConcept() {
        return conceptAccount;
    }
    public void setConcept(String conceptAccount) {
        this.conceptAccount = conceptAccount;
    }

    public String getChargeNumber() {
        return chargeNumber;
    }

    public void setChargeNumber(String chargeNumber) {
        this.chargeNumber = chargeNumber;
    }

    public String getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(String paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(String amountPaid) {
        this.amountPaid = amountPaid;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getChargeDate() {
        return chargeDate;
    }

    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

}
