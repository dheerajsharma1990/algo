package com.algo.scala.linkedlist

import org.scalatest.FunSuite


class PartitionListTest extends FunSuite {

  def partition(list: List[Int], value: Int): List[Int] = {
    list match {
      case Nil => list
      case x :: xs =>
        val (left, right) = list.partition(x => x < value)
        left ::: right
    }
  }

  test("partition nil list") {
    assert(partition(List(), 1) == List())
  }

  test("sorted list should be unchanged") {
    assert(partition(List(1, 2, 3, 4, 5, 6), 4) == List(1, 2, 3, 4, 5, 6))
  }

  test("Reverse sorted half partition") {
    assert(partition(List(6, 5, 4, 3, 2, 1, 0), 4) == List(3, 2, 1, 0, 6, 5, 4))
  }

}
