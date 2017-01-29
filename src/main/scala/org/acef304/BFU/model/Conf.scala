package org.acef304.BFU.model

/**
  * Created by lesha on 27/11/2016.
  */
case class Conf(bufSize: Int = 4*1024*1024, bytesPerDigest: Int = 8, digest: String = "MD5")

object Conf {
  lazy val default = Conf()
  def apply: Conf = default
}