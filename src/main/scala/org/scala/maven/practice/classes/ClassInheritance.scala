package org.scala.maven.practice.classes

import java.time.LocalDateTime
import java.util.UUID

abstract class Account(id: UUID, name: String, date: LocalDateTime) {
  private var _id = id
  private var _name = name
  private var _date = date
  val _accountType: String

  def this(name: String) {
    this(UUID.randomUUID(), name, LocalDateTime.now())
  }

  def getId = _id
  def getName = _name
  def getDate = _date
  def setName(newName: String) = _name = newName


  def getAccountType = _accountType
}

class CreditCard(name: String) extends Account(name: String) {
  override val _accountType = "Credit"

}

class DebitCard(name: String) extends Account(name: String) {
  override val _accountType = "Debit"
}

object ClassInheritance extends App {

  val creditCard = new CreditCard("visa")
  val debitCard = new DebitCard("mc")

  println(s"credit obj $creditCard with elements id:${creditCard.getId}, name:${creditCard.getName}, date: ${creditCard.getDate} & type: ${creditCard.getAccountType}")
  println(s"debit obj $debitCard with elements id:${debitCard.getId}, name:${debitCard.getName}, date: ${debitCard.getDate} & type: ${debitCard.getAccountType}")
}
