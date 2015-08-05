package com.aglo.scala.linkedlist

class ListNode(val value: Int) {

  override def toString = value.toString

  def canEqual(other: Any): Boolean = other.isInstanceOf[ListNode]

  override def equals(other: Any): Boolean = other match {
    case that: ListNode =>
      (that canEqual this) &&
        value == that.value
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(value)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }
}
