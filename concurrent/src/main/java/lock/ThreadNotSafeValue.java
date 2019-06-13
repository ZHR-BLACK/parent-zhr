package lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestVolatile
 * @Date 2019/6/12 15:06
 * 不安全的value
 **/
public class ThreadNotSafeValue {

    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
