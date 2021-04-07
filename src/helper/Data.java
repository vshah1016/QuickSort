package helper;

import error.EmptyList;
import error.ListLimit;

public class Data {
    public static int MAXIMUM_LENGTH = 10; //change this
    public int[] list;

    public Data() {
        this.list = new int[0];
    }

    public void addNumber(int i) {
        if (list.length == MAXIMUM_LENGTH) throw new ListLimit();
        int[] copy = new int[list.length + 1];
        if (i >= 0) System.arraycopy(list, 0, copy, 0, list.length);
        copy[list.length] = i;
        list = copy;
    }

    public void quickSort() {
        if (list.length == 0) throw new EmptyList();
        quickSort(list, 0, list.length - 1);
    }

    private void swap(int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private void quickSort(int[] array, int left, int right){
        if (left < right){
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int numberFromLeft = left;

        for (int i = left + 1; i <= right; i++){
            if (array[i] > pivot) {
                numberFromLeft++;
                swap(i, numberFromLeft);
            }
        }
        swap(left, numberFromLeft);
        return numberFromLeft;
    }
}
