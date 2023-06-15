/*Алгоритмы и структуры данных (семинары)
Урок 4. Структуры данных дерево и хэш-таблица
Реализовать класс работающий по принципу HashMap, включая внутренний массив узлов с индексацией по хешу и описание узла.
Добавить в класс методы:
- Object put(Integer key , Integer value)-  добавить элемент;
- Object get(Integer key) - получить значение, соответствующее ключу;
- Object remove(Integer key) - удалить элемент с соответствующем ключом;
- Object replays(Integer key, Integer v) - заменить значение.
int size() количество элементов;
boolean containsKey(Integer key) проверка наличия ключа и значения;
boolean containsValue(Integer v).

Обучающийся: ШИТОВ Олег Владимирович, "Разработчик Python", поток 4544, будни, утро.  14.06.2023
 */

package org.example;

public class Main {

    public static void main(String[] args) {
        public class HashMap {
            private Node[] nodes;
            private int capacity;
            private int size;
        }

            public HashMap(int capacity) {
                this.capacity = capacity;
                nodes = new Node[capacity];
                size = 0;
            }

            private int hash(Integer key) {
                return key % capacity;
            }

            public Object put(Integer key, Integer value) {              //  метод добавления элемента
                int index = hash(key);
                Node node = new Node(key, value);
                if (nodes[index] == null) {
                    nodes[index] = node;
                    size++;
                } else {
                    Node current = nodes[index];
                    while (current.next != null) {
                        if (current.key.equals(key)) {
                            Object oldValue = current.value;
                            current.value = value;
                            return oldValue;
                        }
                        current = current.next;
                    }
                    if (current.key.equals(key)) {
                        Object oldValue = current.value;
                        current.value = value;
                        return oldValue;
                    }
                    current.next = node;
                    size++;
                }
                return null;
            }

            public Object get(Integer key) {    // метод получения значения, соответствующего ключу
                int index = hash(key);
                Node current = nodes[index];
                while (current != null) {
                    if (current.key.equals(key)) {
                        return current.value;
                    }
                    current = current.next;
                }
                return null;
            }

            public Object remove(Integer key) {        // метод удаления элемента с соответствующем ключом
                int index = hash(key);
                Node current = nodes[index];
                Node previous = null;
                while (current != null) {
                    if (current.key.equals(key)) {
                        if (previous == null) {
                            nodes[index] = current.next;
                        } else {
                            previous.next = current.next;
                        }
                        size--;
                        return current.value;
                    }
                    previous = current;
                    current = current.next;
                }
                return null;
            }

            public Object replace(Integer key, Integer value) {          //  метода замены значения
                int index = hash(key);
                Node current = nodes[index];
                while (current != null) {
                    if (current.key.equals(key)) {
                        Object oldValue = current.value;
                        current.value = value;
                        return oldValue;
                    }
                    current = current.next;
                }
                return null;
            }

            public int size() {
                return size;
            }

            public boolean containsKey(Integer key) {
                int index = hash(key);
                Node current = nodes[index];
                while (current != null) {
                    if (current.key.equals(key)) {
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }

            public boolean containsValue(Integer value) {
                for (Node node : nodes) {
                    Node current = node;
                    while (current != null) {
                        if (current.value.equals(value)) {
                            return true;
                        }
                        current = current.next;
                    }
                }
                return false;
            }

            private static class Node {
                private Integer key;
                private Integer value;
                private Node next;

                public Node(Integer key, Integer value) {
                    this.key = key;
                    this.value = value;
                }
            }
        }
    }
    HashMap hashMap = new HashMap(10);
    hashMap.put(1, 10);
    hashMap.put(2, 20);
    hashMap.put(3, 30);
    hashMap.put(4, 40);
}