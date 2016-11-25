package troywang.gringotts.model;

/**
 * Created by wangzhijian02 on 2016/11/25.
 */
public class Message {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "content='" + content + '\'' +
                '}';
    }
}
