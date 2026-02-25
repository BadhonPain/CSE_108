/**
 * Custom CHECKED exception for this assignment.
 * Throw this when any delivery rule or validation rule is violated.
 *
 */
public class InvalidRequestException extends Exception {
    public InvalidRequestException(String message) {
        super(message);
    }
}

