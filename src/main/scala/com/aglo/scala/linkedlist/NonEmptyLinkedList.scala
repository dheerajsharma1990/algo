package com.aglo.scala.linkedlist

class NonEmptyLinkedList(val node: ListNode, val tail: LinkedList) extends LinkedList {

  override def size: Int = 1 + tail.size

  override def reverse(acc: LinkedList): LinkedList = {
    tail.reverse(acc.addToHead(node))
  }

  override def addToHead(other: ListNode): LinkedList = new NonEmptyLinkedList(other, this)

  override def head: LinkedList = this

  override def isEqual(other: LinkedList): Boolean = other.head.isHeadEqual(node) && tail.isEqual(other.tail)

  override def isHeadEqual(n: ListNode): Boolean = node.equals(n)

}
