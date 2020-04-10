package com.juniordataengineer.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._

object CustomerTotalSpent extends App {
  
  def parseLines(line: String) = {
    val fields = line.split(",")
    val cust_id = fields(0).toInt
    val amount = fields(2).toFloat
    (cust_id, amount)
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[1]", "CustomerTotalSpent")
  
  val lines = sc.textFile("../customer-orders.csv")
  
  val customerAmount = lines.map(parseLines)
  
  val totalCustomerAmount = customerAmount.reduceByKey((x, y) => (x + y)).map(x => (x._2, x._1))
  
  val results = totalCustomerAmount.sortByKey()
  
  for (result <- results) {
    println(s"customerID: ${result._2} total amount: ${result._1}")
  }
  
}