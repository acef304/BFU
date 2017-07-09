name := "BFU"

version := "0.0.1"

scalaVersion := "2.12.0"

oneJarSettings

mainClass := Some("org.acef304.BFU.Launcher")

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test" ,
  "com.lihaoyi" %% "upickle" % "0.4.4"
)
    
