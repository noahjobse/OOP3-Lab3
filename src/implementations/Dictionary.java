package implementations;

import java.util.ArrayList;
import utilities.DictionaryADT;
import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;

public class Dictionary<K, V> implements DictionaryADT<K, V> {
    // Constants
    private static final int DEFAULT_SIZE = 10;

    // Index indicates pairing, e.g., keys[1] is stored at values[1]
    private ArrayList<K> keys;
    private ArrayList<V> values;

    /**
     * Default constructor initializes empty ArrayLists for keys and values.
     * Precondition: None.
     * Postcondition: An empty dictionary is created.
     */
    public Dictionary() {
        this.keys = new ArrayList<>();
        this.values = new ArrayList<>();
    }

    /**
     * Constructor with initial size.
     * Precondition: size should be non-negative.
     * Postcondition: A dictionary with a predefined initial capacity is created.
     */
    public Dictionary(int size) {
        this.keys = new ArrayList<>(size);
        this.values = new ArrayList<>(size);
    }

    /**
     * Inserts a new key-value pair into the dictionary.
     * Precondition: key must not be null and must be unique.
     * Postcondition: Key-value pair is stored in the dictionary.
     * @throws DuplicateKeyException if key already exists.
     * @throws IllegalArgumentException if key is null.
     */
    @Override
    public void insert(K key, V value) throws DuplicateKeyException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (keys.contains(key)) {
            throw new DuplicateKeyException("Key already exists in the dictionary");
        }
        keys.add(key);
        values.add(value);
    }

    /**
     * Removes a key-value pair from the dictionary.
     * Precondition: key must exist in the dictionary.
     * Postcondition: Key and associated value are removed.
     * @throws KeyNotFoundException if key is not found.
     * @throws IllegalArgumentException if key is null.
     */
    @Override
    public V remove(K key) throws KeyNotFoundException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = keys.indexOf(key);
        if (index == -1) {
            throw new KeyNotFoundException("Key not found in the dictionary");
        }
        keys.remove(index);
        return values.remove(index);
    }

    /**
     * Updates the value associated with an existing key.
     * Precondition: key must exist in the dictionary.
     * Postcondition: Value for the key is updated.
     * @throws KeyNotFoundException if key is not found.
     * @throws IllegalArgumentException if key is null.
     */
    @Override
    public void update(K key, V value) throws KeyNotFoundException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = keys.indexOf(key);
        if (index == -1) {
            throw new KeyNotFoundException("Key not found in the dictionary");
        }
        values.set(index, value);
    }

    /**
     * Retrieves the value associated with a given key.
     * Precondition: key must exist in the dictionary.
     * Postcondition: Value associated with key is returned.
     * @throws KeyNotFoundException if key is not found.
     * @throws IllegalArgumentException if key is null.
     */
    @Override
    public V lookup(K key) throws KeyNotFoundException {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        int index = keys.indexOf(key);
        if (index == -1) {
            throw new KeyNotFoundException("Key not found in the dictionary");
        }
        return values.get(index);
    }

    /**
     * Checks whether the dictionary is empty.
     * Precondition: None.
     * Postcondition: Returns true if dictionary is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    /**
     * Returns the number of key-value pairs in the dictionary.
     * Precondition: None.
     * Postcondition: Returns the count of stored key-value pairs.
     */
    @Override
    public int size() {
        return keys.size();
    }
}
