/**
 * Creates and contains methods to maintain a simple list of integers. New elements can be added at the front of the
 * array or the back of the array. The list size will be adjusted depending on the number of elements.
 *
 * @author Christina Bowman, class ID 127
 * @version 3.0
 */
package cse360assign2;
import java.util.Arrays;


public class SimpleList {

    private int[] list;
    private int count;
    private int size;


    public SimpleList(){
        size = 10;
       list = new int[size];
       count = 0;
    }

    /**
     * Adds a new element to the front of the list while moving older elements back 1 space and allows the oldest
     * elements which exceed the desired size of 10 elements to fall of the list. If the list is full it increases the
     * size by 50%
     *
     * @param num The number to be added to the array.
     */
    public void add(int num){
        int reverseIterator = count - 1;

        if(size == count){
            size = (int) Math.round (size + (.5 * size));
            int[] newList = new int[size];

            for(int iterator = 0; iterator < count; iterator++){
                newList[iterator] = list[iterator];
            }

            list = newList;
        }

        while (reverseIterator >= 0){
            list[reverseIterator + 1] = list[reverseIterator];
            reverseIterator--;
        }

        count++;
        list[0] = num;


    }

    /**
     * Adds a new element to the back of the list. If the list is full it increases the size by 50%
     *
     * @param num The number to be added to the array.
     */
    public void append(int num){

        if(size == count){
            size = (int) Math.round (size + (.5 * size));
            int[] newList = new int[size];

            for(int iterator = 0; iterator < count; iterator++){
                newList[iterator] = list[iterator];
            }

            list = newList;
        }

        list[count] = num;
        count++;


    }

    /**
     * Removes the desired element from the list while moving the older elements forward to fill in the gap. If 25% or
     * more of the list is empty it decreases the list by 20%
     *
     * @param num The element desired to be removed from the list.
     */
    public void remove(int num){
        int index = search(num);

        if(index != -1) {

            if(count < (int)Math.round(.75*size)){
                size = (int) Math.round (.8 * size);
                int[] newList = new int[size];

                for(int iterator = 0; iterator < count; iterator++){
                    newList[iterator] = list[iterator];
                }

                list = newList;
            }

            while(index < count) {
                if(index == count - 1) {
                    list[index] = 0;
                }else {
                    list[index] = list[index + 1];
                }

                index++;

            }

        }

    }

    /**
     * Gets the count of numbers in the list.
     *
     * @return The number of elements in the list.
     */
    public int count(){
        return count;
    }

    /**
     * Gets the elements in the list.
     *
     * @return The elements in the list represented by a String.
     */
    public String toString(){


        return Arrays.toString(list);
    }

    /**
     * Searches the list for where a desired element exists if it does at all.
     *
     * @param num The number in the list desired to be found.
     * @return The index where the element in the list can be found. Returns -1 if the elements does not exist
     * in the list
     */
    public int search(int num){
        int index = -1;

        for(int iterator = 0; iterator < count; iterator++){
            if(list[iterator] == num){
                index = iterator;
            }
        }

        return index;
    }

    /**
     * Returns the first element of the list
     *
     * @return The number at the beginning of the list
     */
    public int first(){
        return list[0];
    }

    /**
     * Returns the number of available locations in the list
     *
     * @return The size of the list
     */
    public int size(){
        return size;
    }

}
