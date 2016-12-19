package pocillo.barista.tasks;

import pocillo.barista.tasks.ITaskDelegate;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Will Czifro
 */
public class Task<T> {

    private Queue<ITaskDelegate> delegates;

    private TaskLocale locale;

    private TaskState state;

    private final AtomicBoolean notify = new AtomicBoolean(false);

    private final Object locker = new Object();

    private Task parent;
    private String parentKey;

    public Task() {
        delegates = new ArrayDeque<>();
        locale = new TaskLocale();
    }

    ITaskDelegate getNextDelegate() {
        return delegates.poll();
    }

    void setParentKey(String key) {
        parentKey = key;
    }

    void setParentTask(Task parent) {
        this.parent = parent;
    }

    Task getParentTask() {
        return parent;
    }

    public TaskLocale getLocale() {
        return locale;
    }

    public synchronized TaskState getState() {
        return state;
    }

    synchronized void setState(TaskState state) {
        this.state = state;
        synchronized (locker) {
            if (notify.get()) {
                locker.notify();
            }
        }
    }

    public T getResult() {
        synchronized (locker) {
            if (getState() == TaskState.IN_PROGRESS || getState() == TaskState.WAITING) {
                notify.set(true);
                try {
                    locker.wait();
                } catch (InterruptedException e) {
                    throw new TaskException(e);
                }
            }
            return locale.get("return");
        }
    }

    TaskResult<T> getTaskResult() {
        TaskResult<T> tr = new TaskResult<>();
        tr.value = getResult();
        tr.parentKey = parentKey;
        return tr;
    }

    enum TaskState {
        IN_PROGRESS,
        WAITING,
        FAULTED,
        COMPLETED
    }

    public static <Z> Z await(Task<Z> task) {
        return task.getResult();
    }

    public static void awaitNested(Task<?> child, Task<?> parent) {
        child.setParentTask(parent);
        parent.setState(TaskState.WAITING);
    }
}
