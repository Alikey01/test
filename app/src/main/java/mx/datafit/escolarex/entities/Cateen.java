package mx.datafit.escolarex.entities;

/**
 * Created by Gerardo on 11/08/2017.
 */

public class Cateen {

    private String date;
    private String concept;
    private String charge;
    private String registeredAt;
    private String payment;
    private String paymentConcept;
    private String residue;


    public Cateen() {
    }

    public String  getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getCharge() {
        return "$ " + charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }


    public String getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(String registeredAt) {
        this.registeredAt = registeredAt;
    }

    public String getPayment() {
        return "$ " +payment;
    }

    public String getPaymentConcept() {
        return paymentConcept;
    }


    public String getResidue() {
        return residue;
    }


    public void setPayment(String payment) {
        this.payment = payment;
    }

    public void setPaymentConcept(String paymentConcept) {
        this.paymentConcept = paymentConcept;
    }


    public void setResidue(String residue) {
        this.residue = residue;
    }
}
