package com.algo.scala.linkedlist

import org.scalatest.FunSuite


class RepeatedDNAScalaTest extends FunSuite {

  def repeatedDNA(dna: String): Set[String] = {
    val allCombinations = for (i <- 0 to dna.length - 10) yield dna.substring(i, i + 10)
    allCombinations.groupBy(identity).collect { case (x, list) if (list.size > 1) => x}.toSet
  }

  test("Should return one repeated dna sequence") {
    assert(repeatedDNA("AAAAAAAAAAA") == Set("AAAAAAAAAA"))
  }

  test("Should return repeated dna sequences") {
    assert(repeatedDNA("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT") == Set("AAAAACCCCC", "CCCCCAAAAA"))
  }
}
