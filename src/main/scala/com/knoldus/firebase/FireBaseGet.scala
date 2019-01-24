package com.knoldus.firebase

import com.google.firebase.database.{DataSnapshot, DatabaseError, ValueEventListener}
import com.knoldus.connectors.FirebaseConnection



class FireBaseGet {

  def getData() = {
    val ref = FirebaseConnection.ref("personDetails")
    ref.addValueEventListener(new ValueEventListener {
      override def onDataChange(snapshot: DataSnapshot): Unit = {
       print(snapshot.getValue(classOf[FireBaseGet]))
      }

      override def onCancelled(error: DatabaseError): Unit = ???
    })
  }


}
