package com.na.test;

interface ICustomIterator<E> {
    boolean hasNext();
    E next();
    boolean remove();
}

abstract class AbstractCustomIterator<E> implements ICustomIterator<E> {
    protected int currentIndex;

    @Override
    public boolean remove() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

class CustomArray<E> {
    private final Object[] array;

    public CustomArray(Object[] array) {
        this.array = array;
    }

    public ICustomIterator<E> iterator() {
        return new CustomIterator();
    }

    public ICustomIterator<E> oddIterator() {
        return new CustomOddIterator();
    }

    public ICustomIterator<E> evenIterator() {
        return new CustomEvenIterator();
    }

    class CustomOddIterator extends AbstractCustomIterator<E> {
        public CustomOddIterator() {
            super.currentIndex = 1;
        }

        @Override
        public boolean hasNext() {
            return (currentIndex < array.length && currentIndex % 2 != 0);
        }

        @Override
        public E next() {
            Object element = array[currentIndex];
            currentIndex = currentIndex + 2;
            return (E) element;
        }
    }

    class CustomEvenIterator extends AbstractCustomIterator<E> {
        @Override
        public boolean hasNext() {
            return (currentIndex < array.length);
        }

        @Override
        public E next() {
            Object element = array[currentIndex];
            currentIndex = currentIndex + 2;
            return (E) element;
        }
    }

    private class CustomIterator extends AbstractCustomIterator<E> {
        @Override
        public boolean hasNext() {
            return currentIndex < array.length;
        }

        @Override
        public E next() {
            return (E) array[currentIndex++];
        }
    }
}

public class IteratorDemoMain {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        CustomArray<Integer> intArray = new CustomArray<>(array);
        ICustomIterator<Integer> iterator = intArray.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("-------------------------------------");

        ICustomIterator<Integer> evenIterator = intArray.evenIterator();
        while (evenIterator.hasNext()) {
            System.out.println(evenIterator.next());
        }
        System.out.println("--------------------------------------");

        ICustomIterator<Integer> oddIterator = intArray.oddIterator();
        while (oddIterator.hasNext()) {
            System.out.println(oddIterator.next());
        }
    }
}