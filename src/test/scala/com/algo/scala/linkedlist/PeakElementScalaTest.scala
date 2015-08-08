package com.algo.scala.linkedlist

import org.scalatest.FunSuite

class PeakElementScalaTest extends FunSuite {

  def isMax(arr: Array[Int], current: Int, index: Int): Boolean = {
    if (index < 0 || index == arr.length) true else arr(current) > arr(index)
  }

  def peakElement(arr: Array[Int]): Int = {
    peakElement(arr, 0)
  }

  def peakElement(arr: Array[Int], index: Int): Int = {
    if (isMax(arr, index, index + 1) && isMax(arr, index, index - 1)) index
    else peakElement(arr, index + 1)
  }

  test("Single element peak") {
    assert(peakElement(Array(1)) == 0)
  }

  test("Decreasing Sequence peak") {
    assert(peakElement(Array(2, 1)) == 0)
  }


  test("Increasing Sequence peak") {
    assert(peakElement(Array(1, 2)) == 1)
  }

  test("Increasing Decreasing Sequence peak") {
    assert(peakElement(Array(1, 2, 1)) == 1)
  }

}
