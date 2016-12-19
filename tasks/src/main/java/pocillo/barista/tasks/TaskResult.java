package pocillo.barista.tasks;

/**
 * This class is used when transferring data from
 * child task to parent task
 * @author Will Czifro
 */
class TaskResult<T> {

    T value;
    String parentKey;
}
