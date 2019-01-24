package com.knoldus.connectors

import com.google.api.core.ApiFuture
import com.google.firebase.database.{DataSnapshot, DatabaseError, ValueEventListener}

trait FirebaseApi {

  def writeBeanToFirebase[T](bean: T, refPath: String, key: String): ApiFuture[Void] = {
    val ref = FirebaseConnection.ref(refPath).child(key)
    ref.setValueAsync(bean)
  }



}

object FirebaseApiImpl extends FirebaseApi
