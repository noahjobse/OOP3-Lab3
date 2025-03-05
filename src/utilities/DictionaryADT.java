package utilities;

import exceptions.DuplicateKeyException;
import exceptions.KeyNotFoundException;

/**
* DictionaryADT.java
*
* @author Christin Racicot, Noah Jobse, Parth Nileshkumar Dave, Jacob Jobse
* @version major.minor revision number starting at 1.0
* 
* Class Definition: This interface represents the public contract for the
* implementation of Dictionary for the DictionaryADT Lab. 
*/

public interface DictionaryADT<K, V> {

    /**
     * Inserts a (key, value) pair into the dictionary.
     *
     * @param key   the key to insert (must be unique)
     * @param value the value associated with the key
     * @throws DuplicateKeyException if the key already exists in the dictionary
     * @pre key is not null and does not exist in the dictionary
     * @post the dictionary contains the new (key, value) pair
     */
    void insert(K key, V value) throws DuplicateKeyException;

    /**
     * Removes a key-value pair from the dictionary based on the key.
     *
     * @param key the key to remove
     * @return the value that was associated with the key
     * @throws KeyNotFoundException if the key does not exist in the dictionary
     * @pre key exists in the dictionary
     * @post the dictionary no longer contains the (key, value) pair
     */
    V remove(K key) throws KeyNotFoundException;

    /**
     * Updates the value associated with an existing key.
     *
     * @param key   the key whose value is to be updated
     * @param value the new value to associate with the key
     * @throws KeyNotFoundException if the key does not exist in the dictionary
     * @pre key exists in the dictionary
     * @post the key is still in the dictionary, but its value has been updated
     */
    void update(K key, V value) throws KeyNotFoundException;

    /**
     * Looks up the value associated with a given key.
     *
     * @param key the key to search for
     * @return the value associated with the key
     * @throws KeyNotFoundException if the key does not exist in the dictionary
     * @pre key exists in the dictionary
     * @post the dictionary remains unchanged
     */
    V lookup(K key) throws KeyNotFoundException;

    /**
     * Checks if the dictionary is empty.
     *
     * @return true if the dictionary contains no key-value pairs, false otherwise
     * @pre none
     * @post the dictionary remains unchanged
     */
    boolean isEmpty();

    /**
     * Returns the number of key-value pairs in the dictionary.
     *
     * @return the size of the dictionary
     * @pre none
     * @post the dictionary remains unchanged
     */
    int size();
}

