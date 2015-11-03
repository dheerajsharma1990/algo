package com.algo.scala.linkedlist

import org.scalatest.FunSuite


class MaximumSumListScalaTest extends FunSuite {

  def maxSum(firstList: List[Int], secondList: List[Int]): List[Int] = {
    def max(acc: List[Int], firstList: List[Int], secondList: List[Int], firstAcc: List[Int], secondAcc: List[Int],
            firstSum: Int, secondSum: Int): List[Int] = {
      (firstList, secondList) match {
        case (List(), secondList) => acc ::: secondList
        case (firstList, List()) => acc ::: firstList
        case (f :: fx, s :: sx) => if (f == s)
          if (firstSum > secondSum) max((acc ::: firstAcc) :+ f, fx, sx, List(), List(), 0, 0)
          else
            max((acc ::: secondAcc) :+ s, fx, sx, List(), List(), 0, 0)
        else if (f < s) max(acc, fx, secondList, firstAcc :+ f, secondAcc, firstSum + f, secondSum)
        else max(acc, firstList, sx, firstAcc, secondAcc :+ s, firstSum, secondSum + s)
      }
    }
    max(List(), firstList, secondList, List(), List(), 0, 0)
  }

  test("Should return first list for empty second list") {
    assert(maxSum(List(1, 2, 3), List()) == List(1, 2, 3))
  }

  test("Should return second list for empty first list") {
    assert(maxSum(List(), List(1, 2, 3)) == List(1, 2, 3))
  }

  test("Should return empty list for empty both list") {
    assert(maxSum(List(), List()) == List())
  }

  test("Should return any list for similar two list") {
    assert(maxSum(List(1, 2, 3), List(1, 2, 3)) == List(1, 2, 3))
  }

  test("Should return list with maximum sum") {
    assert(maxSum(List(1, 3, 30, 90, 120, 240, 511), List(0, 3, 12, 32, 90, 125, 240, 249)) == List(1, 3, 12, 32, 90, 125, 240, 511))
  }

}
