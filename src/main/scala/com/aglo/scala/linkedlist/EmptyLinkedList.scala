package com.aglo.scala.linkedlist

class EmptyLinkedList extends LinkedList {

  override def size: Int = 0

  override def reverse(acc: LinkedList): LinkedList = acc

  override def head: LinkedList = throw new NoSuchElementException("EmptyLinkedList.head")

  override def tail: LinkedList = throw new NoSuchElementException("EmptyLinkedList.tail")

  override def addToHead(other: ListNode): LinkedList = new NonEmptyLinkedList(other, new EmptyLinkedList)

  override def isEqual(other: LinkedList): Boolean = other.size == 0

  override def isHeadEqual(n: ListNode): Boolean = false
}
