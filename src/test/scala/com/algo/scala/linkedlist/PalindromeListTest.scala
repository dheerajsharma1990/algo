package com.algo.scala.linkedlist

import com.aglo.scala.linkedlist.{EmptyLinkedList, LinkedList, ListNode, NonEmptyLinkedList}
import org.scalatest.FunSuite


class PalindromeListTest extends FunSuite {

  def emptyList: LinkedList = new EmptyLinkedList

  def singleNodeList(value: Int): LinkedList = new NonEmptyLinkedList(new ListNode(value), emptyList)

  def node(value: Int): ListNode = new ListNode(value)

  test("Empty List is Palindrome") {
    //given
    def empty = emptyList

    //when
    def palindrome = empty.isPalindrome

    //then
    assert(palindrome)
  }

  test("Single Node List is Palindrome") {
    //given
    def node = singleNodeList(1)

    //when
    def palindrome = node.isPalindrome

    //then
    assert(palindrome)
  }

  test("1 2 List is Not Palindrome") {
    //given
    def list = singleNodeList(2).addToHead(node(1))

    //when
    def palindrome = list.isPalindrome

    //then
    assert(!palindrome)
  }

  test("1 2 1 List is Palindrome") {
    //given
    def list = singleNodeList(1).addToHead(node(2)).addToHead(node(1))

    //when
    def palindrome = list.isPalindrome

    //then
    assert(palindrome)
  }

}
