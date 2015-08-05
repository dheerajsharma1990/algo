package com.algo.scala.linkedlist

import com.aglo.scala.linkedlist.{ListNode, NonEmptyLinkedList, LinkedList, EmptyLinkedList}
import org.scalatest.FunSuite


class ReverseListTest extends FunSuite {

  def emptyList: LinkedList = new EmptyLinkedList

  def singleNodeList(value: Int): LinkedList = new NonEmptyLinkedList(new ListNode(value), emptyList)

  def reverse(list: LinkedList): LinkedList = list.reverse(emptyList)

  def node(value: Int): ListNode = new ListNode(value)

  test("Reverse Empty List") {
    //given
    def empty = emptyList

    //when
    def reversed = reverse(empty)

    //then
    assert(reversed.size == 0)
  }

  test("Reverse Single Node List") {
    //given
    def singleList = singleNodeList(1)

    //when
    def reversed = reverse(singleList)

    //then
    assert(reversed.isEqual(singleNodeList(1)))
  }

  test("Reverse Two Nodes List") {
    //given
    def list = singleNodeList(2).addToHead(node(1))

    //when
    def reversed = reverse(list)

    //then
    assert(reversed.isEqual(singleNodeList(1).addToHead(node(2))))
  }

}
