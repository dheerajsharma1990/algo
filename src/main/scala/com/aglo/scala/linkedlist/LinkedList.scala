package com.aglo.scala.linkedlist

trait LinkedList {

  def size: Int

  def reverse(acc: LinkedList): LinkedList

  def isHeadEqual(n: ListNode): Boolean

  def tail: LinkedList

  def head: LinkedList

  def addToHead(other: ListNode): LinkedList

  def isEqual(other: LinkedList): Boolean
}
