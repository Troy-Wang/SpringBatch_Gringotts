package troywang.gringotts.model;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class PayRecord {
    private Long id;

    private Bill bill;

    private Double paidFees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Double getPaidFees() {
        return paidFees;
    }

    public void setPaidFees(Double paidFees) {
        this.paidFees = paidFees;
    }
}
