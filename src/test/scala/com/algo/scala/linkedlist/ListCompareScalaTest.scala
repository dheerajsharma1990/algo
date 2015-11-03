package com.algo.scala.linkedlist

import org.scalatest.FunSuite

import scala.util.Sorting


class ListCompareScalaTest extends FunSuite {

  def compareList(firstList: List[Char], secondList: List[Char]): Int = {
    if (firstList.isEmpty && secondList.isEmpty) {
      0
    } else if (firstList.isEmpty && !secondList.isEmpty) {
      -1
    } else if (!firstList.isEmpty && secondList.isEmpty) {
      1
    } else if (firstList.head != secondList.head) {
      if (firstList.head > secondList.head) 1 else -1
    } else {
      compareList(firstList.tail, secondList.tail)
    }
  }

  test("Should return 0 for both empty list") {
    assert(compareList(List(), List()) == 0)
  }

  test("Should return 1 for second empty list") {
    assert(compareList(List('g'), List()) == 1)
  }

  test("Should return -1 for first empty list") {
    assert(compareList(List(), List('g')) == -1)
  }

  test("Should return 1 for first greater list") {
    assert(compareList(List('g', 'e'), List('g')) == 1)
  }

  test("Should return -1 for second greater list") {
    assert(compareList(List('g'), List('g', 'e')) == -1)
  }
}
