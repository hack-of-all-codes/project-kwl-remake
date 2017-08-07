name := "kwl-processor-itunes"

version := "1.0"

scalaVersion := "2.11.11"

libraryDependencies ++= {
  val sparkVer = "2.1.1"
  Seq(
    "org.apache.spark" %% "spark-core" % sparkVer % "provided" withSources(),
    "org.apache.spark" %% "spark-sql" % sparkVer % "provided" withSources()
  )
}

libraryDependencies += "org.postgresql" % "postgresql" % "42.1.1"