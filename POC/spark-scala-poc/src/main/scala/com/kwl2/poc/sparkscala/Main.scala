package com.kwl2.poc.sparkscala

import org.apache.spark.{SparkConf, SparkContext}

object Main {

  /**
    * spark-submit
    * --class com.kwl2.poc.sparkscala.Main
    * --master yarn
    * --deploy-mode cluster
    *
    * hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/admin/spark-scala-poc-assembly-1.0.jar
    *
    * hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/admin/shakespeare.txt
    *
    * hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/livy/shakespeareWordCount
    *
    * @param args
    */
  def main(args: Array[String]) {
    val sc = new SparkContext(new SparkConf())

    val textFile = sc.textFile(args(0))

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.saveAsTextFile(args(1));
  }

}
