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

    import org.apache.spark.sql._

    case class ITunesArtist(
                             id: Option[Long],
                             export_date: Long,
                             export_mode: String,
                             artist_id: Long,
                             artist_type_id: Long,
                             is_actual_artist: Boolean,
                             name: String,
                             search_terms: String,
                             view_url: String)

    val artistItunesHDFS = spark.read.textFile(args(0)).filter(!_.startsWith("#")).flatMap(value => {
      val s = value.split("\u0001")
      //Row("export_mode", "EE")
      //(s(0), s(1), s(2))
      try {
        Some(ITunesArtist(None, s(0).toLong, "FULL", s(1).toLong, s(6).toLong, s(4).toBoolean, s(2), s(3), s(5)))
      } catch {
        case e: Exception => None
      }

    })
    artistItunesHDFS.show()

    val artistItunesJDBC = spark.read.jdbc(args(1), "itunes_artist", new java.util.Properties()) //.as(ITunesArtist)
    artistItunesJDBC.show()
  }

}
