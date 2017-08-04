name := "kwl-processor-itunes"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= {
  val sparkVer = "2.1.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources(),
    "org.postgresql" %% "postgresql" % "42.1.1"
  )
}