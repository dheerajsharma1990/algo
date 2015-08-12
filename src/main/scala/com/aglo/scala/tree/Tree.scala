package com.aglo.scala.tree

trait Tree {

  def invert: Tree

  def isEmpty: Boolean

  def isEqual(tree: Tree): Boolean

  def left: Tree

  def right: Tree

  def value: Int

}
