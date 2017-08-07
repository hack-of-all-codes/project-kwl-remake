package com.kwl2.harvester.itunes.artist

import org.apache.spark.sql.SparkSession

/**
  * Loads artist file from HDFS to Kafka
  */
object ArtistProcessor {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession
      .builder()
      .appName("Artist Processor V1")
      .getOrCreate()

    val artistItunesHDFS = spark.read.textFile(args(0)).filter(!_.startsWith("#"))
    artistItunesHDFS.show()

    val artistItunesJDBC = spark.read.jdbc(args(0), "itunes_artist", new java.util.Properties())
    artistItunesJDBC.show()
  }

}
