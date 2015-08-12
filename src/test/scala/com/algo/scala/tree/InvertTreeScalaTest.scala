package com.algo.scala.tree

import com.aglo.scala.linkedlist.{EmptyLinkedList, LinkedList, ListNode, NonEmptyLinkedList}
import com.aglo.scala.tree.{NonEmptyTree, EmptyTree, Tree}
import org.scalatest.FunSuite


class InvertTreeScalaTest extends FunSuite {

  def emptyTree: Tree = new EmptyTree

  def singleNodeTree(value: Int): Tree = new NonEmptyTree(value, emptyTree, emptyTree)

  test("Invert Single Node Tree") {
    //given
    def tree = singleNodeTree(1)

    //when
    def reversed = tree.invert

    //then
    assert(reversed.isEqual(singleNodeTree(1)))
  }

  test("Invert Skewed Node Tree") {
    //given
    def tree = new NonEmptyTree(1, singleNodeTree(2), emptyTree)

    //when
    def reversed = tree.invert

    //then
    assert(reversed.isEqual(new NonEmptyTree(1, emptyTree, singleNodeTree(2))))
  }

  test("Invert Complete Tree") {
    //given
    def tree = new NonEmptyTree(1, singleNodeTree(2), singleNodeTree(3))

    //when
    def reversed = tree.invert

    //then
    assert(reversed.isEqual(new NonEmptyTree(1, singleNodeTree(3), singleNodeTree(2))))
  }

}
