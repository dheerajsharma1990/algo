package com.algo.scala.linkedlist

import org.scalatest.FunSuite

import scala.util.Sorting


class MergeSortListTest extends FunSuite {

  def sort(list: List[Int]): List[Int] = {

    def merge(list1: List[Int], list2: List[Int]): List[Int] = {
      (list1, list2) match {
        case (Nil, list2) => list2
        case (list1, Nil) => list1
        case (f :: fr, s :: sr) => if (f < s) f :: merge(fr, list2) else s :: merge(list1, sr)
      }
    }

    if (list.length < 2) list
    else {
      val (first, second) = list.splitAt(list.length / 2)
      merge(sort(first), sort(second))
    }

  }

  test("Sort single element") {
    assert(sort(List(1)) == List(1))
  }

  test("Sort already sorted elements") {
    assert(sort(List(1, 2, 3)) == List(1, 2, 3))
  }

  test("Sort reverse sorted elements") {
    assert(sort(List(3, 2, 1, 0)) == List(0, 1, 2, 3))
  }

  test("sort mix of negative and positive") {
    assert(sort(List(-1, 5, -3, 0, 4, 18, -24)) == List(-24, -3, -1, 0, 4, 5, 18))
  }

}
