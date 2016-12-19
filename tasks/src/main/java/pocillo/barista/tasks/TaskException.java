package pocillo.barista.tasks;

/**
 * @author Will Czifro
 */
public class TaskException extends RuntimeException {

    public TaskException(Throwable throwable) {
        super(throwable);
    }
}
