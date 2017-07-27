
export SPARK_MAJOR_VERSION=2 

spark-submit --class com.kwl2.poc.sparkscala.Main --master yarn --deploy-mode cluster hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/admin/spark-scala-poc-assembly-1.0.jar hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/admin/shakespeare.txt hdfs://ec2-34-209-76-48.us-west-2.compute.amazonaws.com:/user/spark/shakespeareWordCount