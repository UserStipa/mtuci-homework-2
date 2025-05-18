package org.example.search;

public class HashTable {
    private static final int DEFAULT_CAPACITY = 16;
    private Entry[] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    public Object get(Object key) {
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;
        int startIndex = index;

        // Линейное пробирование
        while (table[index] != null) {
            if (table[index].key.equals(key)) {
                return table[index].value; // Ключ найден
            }

            index = (index + 1) % table.length; // Простое рехэширование

            if (index == startIndex) {
                return null;
            }
        }

        return null;
    }

    public void put(Object key, Object value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }

        if (size >= table.length * 0.75) {
            resize();
        }

        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % table.length;

        while (table[index] != null && !table[index].key.equals(key)) {
            index = (index + 1) % table.length;
        }

        if (table[index] == null) {
            size++;
        }

        table[index] = new Entry(key, value);
    }

    private void resize() {
        Entry[] oldTable = table;
        table = new Entry[oldTable.length * 2];
        size = 0;

        for (Entry entry : oldTable) {
            if (entry != null) {
                put(entry.key, entry.value);
            }
        }
    }
}

class Entry {
    Object key;
    Object value;

    Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
