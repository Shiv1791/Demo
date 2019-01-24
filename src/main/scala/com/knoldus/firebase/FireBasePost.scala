package com.knoldus.firebase
import com.knoldus.models._
import com.knoldus.connectors.FirebaseConnection
import com.google.api.core.ApiFuture

class FireBasePost {


  var myData = MyData("H","Not","male")
  def post(myData:MyData, refPath: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(myData.personId)
    ref.setValueAsync(myData.toBean)
  }
  private def parseAsMyData(myData: MyData): MyData = {
    MyData(myData.personId, myData.personName, myData.personGender)
  }
  val MyDataBean = parseAsMyData(myData)
  post(MyDataBean, "personDetails")

}