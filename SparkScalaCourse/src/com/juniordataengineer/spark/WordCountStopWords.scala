package com.juniordataengineer.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object WordCountStopWords extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]", "WordCountStopWords")
  
  val inputFile = sc.textFile("../book.txt")
  
  val stopWordsInput = sc.textFile("../stopwords.txt")
  
  val totalWords = inputFile.flatMap(x => x.split("\\W+"))
  
  val stopWords = stopWordsInput.flatMap(x => x.split("\\W+"))
  
  val broadcastStopWords = sc.broadcast(stopWords.collect.toSet)
  
  val lowerTotalWords = totalWords.map(x => x.toLowerCase())
  
  val cleanWords = lowerTotalWords.filter(!broadcastStopWords.value.contains(_))
  
  val wordCount = cleanWords.map(x => (x, 1)).reduceByKey((x,y) => x+y)
  
  val wordsCountSorted = wordCount.map(x => (x._2, x._1)).sortByKey()
  
  val results = wordsCountSorted.collect()
  
  for (result <- results) {
    val count = result._1
    val word = result._2
    println(s"$word : $count")
  }
}