package troywang.gringotts.model;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class User {
    /**
     * id
     */
    private Long userId;

    /**
     * userName
     */
    private String userName;

    /**
     * age
     */
    private Integer age;

    /**
     * balance
     */
    private Double balance;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                '}';
    }
}
