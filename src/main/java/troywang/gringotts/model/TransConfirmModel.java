package troywang.gringotts.model;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class TransConfirmModel {

    private Long userId;

    private String transId;

    private Double amount;

    private String confirmTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTransId() {
        return transId;
    }

    public void setTransId(String transId) {
        this.transId = transId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(String confirmTime) {
        this.confirmTime = confirmTime;
    }

    @Override
    public String toString() {
        return "TransConfirmModel{" +
                "userId=" + userId +
                ", transId='" + transId + '\'' +
                ", amount=" + amount +
                ", confirmTime='" + confirmTime + '\'' +
                '}';
    }
}
