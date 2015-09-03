package com.algo.scala.misc

import org.scalatest.FunSuite

import scala.io.Source


class MobileDictionaryScalaTest extends FunSuite {

  val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

  val words = in.getLines().toList filter (str => str forall (ch => ch.isLetter))

  val mnemonics = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  def charCode: Map[Char, Char] = {
    for ((digit, string) <- mnemonics; ch <- string) yield ch -> digit
  }

  def wordCode(word: String): String = {
    word.toUpperCase map charCode
  }

  def wordsForNum: Map[String, Seq[String]] = {
    words groupBy wordCode withDefaultValue Seq()
  }

  def encode(number: String): Set[List[String]] = {
    if (number.isEmpty) Set(List[String]())
    else {
      for {
        split <- 1 to number.length
        word <- wordsForNum(number take split)
        rest <- encode(number drop split)
      } yield word :: rest
    }.toSet
  }

  test("java word code") {
    assert(wordCode("Java") === "5282")
  }

  test("words for num") {
    assert(wordsForNum.size != 0)
  }

  test("encode") {
    assert(encode("7225247386").contains(List("Scala","is","fun")))
  }

}
