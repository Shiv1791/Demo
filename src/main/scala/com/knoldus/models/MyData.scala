package com.knoldus.models

import scala.beans.BeanProperty
class MyDataBean() {
  @BeanProperty var personId: String = _
  @BeanProperty var personName: String = _
  @BeanProperty var personGender: String = _
  def toCase: MyData = {
    MyData(personId, personName, personGender)
  }
}
case class MyData(
                        personId: String,
                       personName: String,
                       personGender: String) {
  def toBean: MyDataBean = {
    val personData = new MyDataBean()
    personData.personId = personId
    personData.personName = personName
    personData.personGender = personGender
    personData
  }
}
