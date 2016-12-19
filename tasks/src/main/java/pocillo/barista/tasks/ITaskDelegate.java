package pocillo.barista.tasks;

/**
 * @author Will Czifro
 */
@FunctionalInterface
public interface ITaskDelegate {

    void delegate(TaskLocale locale);

}
