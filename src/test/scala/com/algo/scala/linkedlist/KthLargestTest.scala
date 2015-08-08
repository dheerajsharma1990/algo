package com.algo.scala.linkedlist

import com.aglo.scala.linkedlist.{EmptyLinkedList, LinkedList, ListNode, NonEmptyLinkedList}
import org.scalatest.FunSuite

import scala.util.Sorting


class KthLargestTest extends FunSuite {

  def kthLargest(arr: Array[Int], k: Int) = {
    Sorting.quickSort(arr)
    arr(arr.length - k)
  }

  test("1st largest") {
    assert(kthLargest(Array(1), 1) == 1)
  }

  test("2nd largest") {
    assert(kthLargest(Array(2, 1), 2) == 1)
  }

  test("3rd largest") {
    assert(kthLargest(Array(7, 10, 2), 3) == 2)
  }

  test("largest") {
    assert(kthLargest(Array(11, 10, 9, 8), 1) == 11)
  }

}
