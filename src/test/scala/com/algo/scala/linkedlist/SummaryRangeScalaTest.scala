package com.algo.scala.linkedlist

import org.scalatest.FunSuite

import scala.util.Sorting


class SummaryRangeScalaTest extends FunSuite {

  def summaryRange(arr: Array[Int]): List[String] = {
    summaryRange(0, 0, 1, arr)
  }

  def createRange(start: Int, end: Int): String = {
    if (start == end) start.toString
    else start + "->" + end
  }

  def summaryRange(startIndex: Int, previousIndex: Int, currentIndex: Int, numbers: Array[Int]): List[String] = {
    if (currentIndex == numbers.length) List(createRange(numbers(startIndex), numbers(previousIndex)))
    else if (numbers(currentIndex) == numbers(previousIndex) + 1) summaryRange(startIndex, currentIndex, currentIndex + 1, numbers)
    else List(createRange(numbers(startIndex), numbers(previousIndex))) ::: summaryRange(currentIndex, currentIndex, currentIndex + 1, numbers)
  }

  test("Create two ranges") {
    //given
    def expected = "0->2" :: ("4" :: Nil)

    //then
    assert(summaryRange(Array(0, 1, 2, 4)) == expected)
  }

  test("Create independent ranges") {
    //given
    def expected = "0" :: "2" :: "4" :: "6" :: Nil

    //then
    assert(summaryRange(Array(0, 2, 4, 6)) == expected)
  }

  test("Create single range1") {
    //given
    def expected = "0->4" :: Nil

    //then
    assert(summaryRange(Array(0, 1, 2, 3, 4)) == expected)
  }

}
