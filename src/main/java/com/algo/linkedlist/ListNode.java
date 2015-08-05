package com.algo.linkedlist;

public class ListNode<T> {
    private T item;
    private ListNode<T> next;

    public ListNode() {

    }

    public ListNode(T item) {
        this.item = item;
    }

    public ListNode(T item, ListNode<T> next) {
        this.item = item;
        this.next = next;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        if (item != null ? !item.equals(listNode.item) : listNode.item != null) return false;
        if (next != null ? !next.equals(listNode.next) : listNode.next != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
