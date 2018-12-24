package domian;

/**
 * 自定义异常类
 *
 * @author wt
 */
public class ErrorMessageException extends Exception {

    private String Message;

    public ErrorMessageException(String mess) {
        super();
        Message = mess;
    }
    @Override
    public String getMessage() {
        return Message;
    }

    public void setMessage(String mess) {
        Message = mess;
    }

}
