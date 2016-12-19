package pocillo.barista.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Will Czifro
 */
public class TaskLocale {

    private Map<String, Object> objectStore;
    private PrimitiveStore primitiveStore;

    public TaskLocale() {
        objectStore = new HashMap<>();
        primitiveStore = new PrimitiveStore();
    }

    public <T> T get(String key) {
        return (T) objectStore.get(key);
    }

    public void addOrUpdate(String key, Object obj) {
        if (objectStore.containsKey(key))
            objectStore.remove(key);
        objectStore.put(key, obj);
    }

    public int getInt(String key) {
        return primitiveStore.intStore.get(key);
    }

    public void addOrUpdateInt(String key, int value) {
        if (primitiveStore.intStore.containsKey(key))
            primitiveStore.intStore.remove(key);
        primitiveStore.intStore.put(key, value);
    }

    public double getDouble(String key) {
        return primitiveStore.doubleStore.get(key);
    }

    public void addOrUpdateDouble(String key, double value) {
        if (primitiveStore.doubleStore.containsKey(key))
            primitiveStore.doubleStore.remove(key);
        primitiveStore.doubleStore.put(key, value);
    }

    public float getFloat(String key) {
        return primitiveStore.floatStore.get(key);
    }

    public void addOrUpdateFloat(String key, float value) {
        if (primitiveStore.floatStore.containsKey(key))
            primitiveStore.floatStore.remove(key);
        primitiveStore.floatStore.put(key, value);
    }

    public long getLong(String key) {
        return primitiveStore.longStore.get(key);
    }

    public void addOrUpdateLong(String key, Long value) {
        if (primitiveStore.longStore.containsKey(key))
            primitiveStore.longStore.remove(key);
        primitiveStore.longStore.put(key, value);
    }

    public boolean getBoolean(String key) {
        return primitiveStore.booleanStore.get(key);
    }

    public void addOrUpdateBoolean(String key, boolean value) {
        if (primitiveStore.booleanStore.containsKey(key))
            primitiveStore.booleanStore.remove(key);
        primitiveStore.booleanStore.put(key, value);
    }

    public char getChar(String key) {
        return primitiveStore.charStore.get(key);
    }

    public void addOrUpdateChar(String key, char value) {
        if (primitiveStore.charStore.containsKey(key))
            primitiveStore.charStore.remove(key);
        primitiveStore.charStore.put(key, value);
    }

    private class PrimitiveStore {

        private Map<String, Integer> intStore;
        private Map<String, Double> doubleStore;
        private Map<String, Float> floatStore;
        private Map<String, Long> longStore;
        private Map<String, Boolean> booleanStore;
        private Map<String, Character> charStore;

        PrimitiveStore() {
            intStore = new HashMap<>();
            doubleStore = new HashMap<>();
            floatStore = new HashMap<>();
            longStore = new HashMap<>();
            booleanStore = new HashMap<>();
        }
    }
}
