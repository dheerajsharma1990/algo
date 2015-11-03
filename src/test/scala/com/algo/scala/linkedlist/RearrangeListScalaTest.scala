package com.algo.scala.linkedlist

import org.scalatest.FunSuite


class RearrangeListScalaTest extends FunSuite {

  def rearrangeList(list: List[Char]): List[Char] = {
    def reverseLastHalf(list: List[Char]) = list.splitAt((list.length + 1) / 2)
    match {
      case (first, second) => (first, second.reverse)
    }

    def merge(pair: (List[Char], List[Char])): List[Char] = {
      pair match {
        case (first, List()) => first
        case (a :: ax, second) => a :: merge(second, ax)
      }
    }
    merge(reverseLastHalf(list))
  }

  test("Should return empty list for empty list") {
    assert(rearrangeList(List()) == List())
  }

  test("Should return same list for single element list") {
    assert(rearrangeList(List('g')) == List('g'))
  }

  test("Should return same list for two elements list") {
    assert(rearrangeList(List('g', 'a')) == List('g', 'a'))
  }

  test("Should rearrange 3 element list") {
    assert(rearrangeList(List('g', 'e', 'k')) == List('g', 'k', 'e'))
  }

  test("Should rearrange 4 elements list") {
    assert(rearrangeList(List('g', 'e', 'e', 'k')) == List('g', 'k', 'e', 'e'))
  }
}
