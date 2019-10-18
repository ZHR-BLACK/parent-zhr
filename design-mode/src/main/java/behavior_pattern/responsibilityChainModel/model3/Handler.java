package behavior_pattern.responsibilityChainModel.model3;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Handler
 * @Date 2019-10-17 17:14
 * @description todo
 **/
public abstract class Handler {

    protected Handler nextHandler = null;

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract String dispose(String user, double fee);
}
