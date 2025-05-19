package org.example.stack;

public class CustomStack {
    private char[] data;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        data = new char[size];
        top = -1;
        capacity = size;
    }

    public void push(char c) {
        if (isFull()) {
            resize();
        }
        data[++top] = c;
    }

    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return data[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    private void resize() {
        char[] newData = new char[capacity * 2];
        System.arraycopy(data, 0, newData, 0, capacity);
        data = newData;
        capacity *= 2;
    }

    public int size() {
        return top + 1;
    }
}