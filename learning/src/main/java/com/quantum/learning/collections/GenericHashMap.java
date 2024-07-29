package com.quantum.learning.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GenericHashMap <K, V> {

    private LinkedList<Node<K, V>>[] buckets;
    private int size;
    private double threshold;

    public GenericHashMap() {
        this.size = 0;
        this.initBuckets(4);
        this.threshold = 2.0;
    }

    public GenericHashMap(final int capacity) {
        this.size = 0;
        this.initBuckets(capacity);
        this.threshold = 2.0;
    }

    public void put(final K key, final V value) {
        final int bucketIndex = key.hashCode() % buckets.length;
        int nodeIndex = getIndexForKeyInBucket(key, bucketIndex);

        if (nodeIndex > -1) {
            buckets[bucketIndex]
                    .set(nodeIndex, new Node<>(key, value));
            return;
        }

        buckets[bucketIndex]
                .add(new Node<>(key, value));
        size++;

        double loadFactor = (double) size / (double) buckets.length;
        if (loadFactor > threshold) {
            rehash();
        }
    }

    public V get(final K key) {
        final int bucketIndex = key.hashCode() % buckets.length;

        int nodeIndex = getIndexForKeyInBucket(key, bucketIndex);

        if (nodeIndex == -1) {
            return null;
        }

        return buckets[bucketIndex]
                .get(nodeIndex)
                .value;
    }

    public V remove(final K key) {

        final int bucketIndex = key.hashCode() % buckets.length;
        int nodeIndex = getIndexForKeyInBucket(key, bucketIndex);

        if (nodeIndex == -1) {
            return null;
        }

        size--;

        return buckets[bucketIndex]
                .remove(nodeIndex)
                .value;
    }

    public V getOrDefault(final K key, final V defaultValue) {
        final int bucketIndex = key.hashCode() % buckets.length;
        int nodeIndex = getIndexForKeyInBucket(key, bucketIndex);

        if (nodeIndex == -1) {
            buckets[bucketIndex]
                    .add(new Node<>(key, defaultValue));

            size++;

            double loadFactor = (double) size / (double) buckets.length;
            if (loadFactor > threshold) {
                rehash();
            }

            return defaultValue;
        }

        return buckets[bucketIndex]
                .get(nodeIndex)
                .value;
    }

    public int size() {
        return this.size;
    }

    public List<Node<K, V>> keySet() {

        List<Node<K, V>> list = new ArrayList<>();
        for (LinkedList<Node<K, V>> bucket : buckets) {
            list.addAll(bucket);
        }

        return list;
    }

    private class Node <K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private void initBuckets(final int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getIndexForKeyInBucket(final K key, final int bucketIndex) {

        int index = 0;
        for (Node<K, V> node: buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    private void rehash() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        this.initBuckets(oldBuckets.length * 2);
        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            for (Node<K, V> node : bucket) {
                put(node.key, node.value);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LinkedList<Node<K, V>> bucket : buckets) {
            for (Node<K, V> node : bucket) {
                sb.append("{key: ").append(node.key).append(", ").append("value: ").append(node.value).append("\n");
            }
        }

        return sb.toString();
    }
}
