
public class ServiceException extends Exception {

    public ServiceException(String str) {
        super("Error: " + str);
    }
}
