package com.kwl2.poc.sparkscala

import org.apache.spark.{SparkConf, SparkContext}

object Main {

  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf())

    val textFile = sc.textFile("/user/admin/shakespeare.txt")

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.saveAsTextFile("/user/livy/shakespeareWordCount");
  }

}
