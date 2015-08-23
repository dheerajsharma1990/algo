package com.algo.scala.linkedlist

import org.scalatest.FunSuite


class RunLengthEncodingTest extends FunSuite {

  def runLengthEncoding(list: List[Char]): List[(Char, Int)] = {
    def commons(list: List[Char]): List[List[Char]] = {
      list match {
        case Nil => Nil
        case x :: xs =>
          val (first, second) = list.span(y => y == x)
          first :: commons(second)
      }
    }
    commons(list).map(ls => (ls.head, ls.length))
  }

  test("Run length encoding of various elements") {
    assert(runLengthEncoding(List('a','a','a','b','c','c','a')) == List(('a',3),('b',1),('c',2),('a',1)))
  }

  test("Run length encoding of single element") {
    assert(runLengthEncoding(List('a')) == List(('a',1)))
  }

  test("Run length encoding of all similar elements") {
    assert(runLengthEncoding(List('a','a','a','a')) == List(('a',4)))
  }

  test("Run length encoding empty list") {
    assert(runLengthEncoding(List()) == List())
  }

}
