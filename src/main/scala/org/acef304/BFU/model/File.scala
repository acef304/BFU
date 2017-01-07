package org.acef304.BFU.model

import java.io.FileInputStream

/**
  * Created by acef304 on 27/11/2016.
  */
class File(name: String, conf: Conf) {
  def initHash: Unit = {
    val t = new FileInputStream(name)
    //val size = (new java.io.File(name)).length()
    //var count = 0L
    val buff = new Array[Byte](conf.bufSize)
    while (t.read(buff) != -1) {
      println(getChecksum(buff))
    }
  }

  def getChecksum(buff: Array[Byte]) = {
    val m = java.security.MessageDigest.getInstance(conf.digest)
    m.update(buff, 0, buff.length)
    new java.math.BigInteger(1, m.digest()).toString(16)
  }
}
