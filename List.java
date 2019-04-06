//import java.util.List;

/**
 * This class creates List class that opperates similarly to how ArrayLists
 * class inside java works. This class will create methods to be used by main.
 * List will connect nodes holding information as a linked list.
 */

public class List<T> implements MyCollectionInterface<T> {

    private Node<T> head;
    private Node<T> pn;
    private Node<T> cn;
    private Node<T> temp;
    private int count;
    //private T[] array =(T[]) new Object[list.size()];

    public List(){
        count = 0;
        this.head = null;
    }

    /**
     * Adds a new entry to this collection
     *
     * @param newItem The object to be added to the collection
     * @return True if the addition is successful, or false if not.
     */

    @Override
    public boolean add(T newItem) {

        temp = new Node(newItem);

        if(!isEmpty()){
            temp.next = head;
        }
        head = temp;
        count++;

        return true;
    }

    /**
     * Removes one unspecified entry from the collection, if possible.
     *
     * @return Either the removed entry, if the removal was successful, or
     * null.
     */

    @Override
    public T remove() {
        T data = (T) head.data;
        head = head.next;
        count--;
        return data;
    }

    /**
     * Removes one occurrence of a given entry from this collection.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */

    @Override
    public boolean remove(T anEntry) {              //this? Yes?

        pn = new Node(null);
        cn = new Node(null);
        cn = head;
        if(head.data.equals(anEntry)){
            head = head.next;
            count --;
            return true;
        }
        else{
            while(cn!= null){
                if(cn.data.equals(anEntry)){
                    pn.next = cn.next;
                    count--;
                    return true;
                }
                pn = cn ;
                cn = cn.next;
            }
        }
        return false;
    }

    /**
     * Removes all entries from this collection.
     */

    @Override
    public void clear() {
        head = null;
        count = 0;
    }

    /**
     * Gets the current number of entries in this collection.
     *
     * @return The integer number of entries currently in the collection.
     */

    @Override
    public int getCurrentSize() {
        return count;
    }

    /**
     * Check to see if the collection is empty.
     *
     * @return True if the collection is empty, or false if not.
     */

    @Override
    public boolean isEmpty() {
        if(count == 0){
            return true;
        }
        return false;
    }

    /**
     * Counts the number of times a given entry appears in this collection.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the collection.
     */

    @Override
    public int getFrequencyOf(T anEntry) {
        int frequency = 0;

        cn = head;

        for (int i =0; i<count; i++){
            if(cn.data.equals(anEntry)){
                frequency++;
            }
            cn = cn.next;
        }
        return frequency;
    }

    /**
     * Tests whether this collection contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the collection contains anEntry, or false if not.
     */

    @Override
    public boolean contains(T anEntry) {
        boolean found = false;

        cn = head;
        while(cn != null){
            if (cn.data.equals(anEntry)){
                found = true;
            }
                cn = cn.next;
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this collection.
     *
     * @return A newly allocated array of all the entries in the collection.
     * Note: If the collection is empty, the returned array is empty.
     */

    @Override
    public T[] toArray() {
        T[] arr = (T[])new Object[count+1];
        int index =0;
        cn = head;
        while((index < count) && (cn != null))
        {
            arr[index] = (T) cn.getData();
            cn = cn.next;
            index++;
        }
        return arr;
    }

    /**
     * This class creates the nodes that will hold the information to be linked
     * together.
     *
     * @param <T>
     */

    private class Node<T> {

        private Node<T> next;
        private T data;

        private Node(T dataPortion) {
            next = null;
            data = dataPortion;
        }

        private T getData(){
            return data;
        }

        private Node<T> getNext(){
            return next;
        }

        private void setData(T anEntry){
            data = anEntry;
        }

        private void setNext(Node<T> nextNode){
            next = nextNode;
        }
    }
}
