package implementations;

import java.util.ArrayList;
import utilities.DictionaryADT;
import exceptions.DuplicateKeyException;

/**
 * Implementation of the DictionaryADT using ArrayLists to store key-value pairs.
 * Keys must be unique.
 *
 * @param <K> the type of keys maintained by this dictionary
 * @param <V> the type of values associated with the keys
 */
public class Dictionary<K, V> implements DictionaryADT<K, V> {
    // Constant for the default size.
    private static final int DEFAULT_SIZE = 10;
    
    // The lists that store keys and values, where the index in one list corresponds to the same index in the other.
    private ArrayList<K> keys;
    private ArrayList<V> values;
    
    /**
     * Default constructor that creates a Dictionary with a default size.
     */
    public Dictionary() {
        create(DEFAULT_SIZE);
    }
    
    /**
     * Constructor that creates a Dictionary with a specified initial size.
     * 
     * @param size the initial capacity for the dictionary.
     */
    public Dictionary(int size) {
        create(size);
    }
    
    /**
     * Initializes the dictionary's internal storage with the specified size.
     * <p>
     * <b>Precondition:</b> None.<br>
     * <b>Postcondition:</b> The keys and values ArrayLists are initialized with the given size. 
     * If the provided size is less than or equal to 0, the default size is used.
     * </p>
     * 
     * @param size the initial capacity of the dictionary.
     */
    @Override
    public void create(int size) {
        if (size <= 0) {
            size = DEFAULT_SIZE;
        }
        keys = new ArrayList<>(size);
        values = new ArrayList<>(size);
    }
    
    /**
     * Inserts a new key-value pair into the dictionary.
     * <p>
     * <b>Precondition:</b> Both key and value are not null.<br>
     * <b>Postcondition:</b> The key-value pair is added if the key does not exist. 
     * If the key is already present, a DuplicateKeyException is thrown.
     * </p>
     * 
     * @param key the key to be inserted.
     * @param value the value to be associated with the key.
     * @return true if the key-value pair is successfully inserted.
     * @throws DuplicateKeyException if the key already exists in the dictionary.
     */
    @Override
    public boolean insert(K key, V value) throws DuplicateKeyException {
        if (key == null || value == null) {
            throw new IllegalArgumentException("Key and value must not be null.");
        }
        if (keys.contains(key)) {
            throw new DuplicateKeyException("Duplicate key: " + key);
        }
        keys.add(key);
        values.add(value);
        return true;
    }
    
    /**
     * Removes the key-value pair associated with the given key from the dictionary.
     * <p>
     * <b>Precondition:</b> The key is not null.<br>
     * <b>Postcondition:</b> If the key exists, its associated key-value pair is removed and 
     * its value is returned; if not, the method returns null.
     * </p>
     * 
     * @param key the key whose associated pair is to be removed.
     * @return the value associated with the removed key, or null if the key was not found.
     */
    @Override
    public V remove(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        V removedValue = values.get(index);
        keys.remove(index);
        values.remove(index);
        return removedValue;
    }
    
    /**
     * Updates the value associated with the specified key.
     * <p>
     * <b>Precondition:</b> Both key and new value are not null.<br>
     * <b>Postcondition:</b> If the key exists, its value is updated to the new value and the method returns true.
     * If the key does not exist, the dictionary remains unchanged and the method returns false.
     * </p>
     * 
     * @param key the key whose value is to be updated.
     * @param value the new value to associate with the key.
     * @return true if the update is successful, or false if the key does not exist.
     */
    @Override
    public boolean update(K key, V value) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return false;
        }
        values.set(index, value);
        return true;
    }
    
    /**
     * Retrieves the value associated with the specified key from the dictionary.
     * <p>
     * <b>Precondition:</b> The key is not null.<br>
     * <b>Postcondition:</b> Returns the value associated with the key if found; otherwise, returns null.
     * </p>
     * 
     * @param key the key whose value is to be looked up.
     * @return the value associated with the key, or null if the key does not exist.
     */
    @Override
    public V lookup(K key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        return values.get(index);
    }
}
