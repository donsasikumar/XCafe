package org.coffee.house

import scala.collection.mutable.MutableList
import scala.collection.immutable.Map
import scala.collection.Iterator
import scala.collection.immutable.List
import java.lang.Boolean

object CafeX {

  def openCafe() {
    val availableItems = getAvailableItems
    println(availableItems)
    var priceLookup = getItemPrices
    var items = fillBasket
    //currying
    var total = items.map(priceLookup.get(_)).map(_.get).sum
    total = applyServiceCharge(items, availableItems, total)
    println("Total = " + total)
  }

  def getAvailableItems(): Map[Int, String] = {
    Map(1 -> "Cola Cold",
      2 -> "Coffee Hot",
      3 -> "Cheese Sandwich Cold)",
      4 -> "Steak Sandwich Hot")

  }

  def getItemPrices(): Map[Int, Double] = {
    Map(1 -> 0.50,
      2 -> 1.00,
      3 -> 2.00,
      4 -> 4.50);
  }

  def fillBasket(): MutableList[Int] = {
    var continue = true;
    var item = 0
    var items = MutableList(0)
    items.clear
    while (continue) {
      println("Enter Item number[1-4] or Checkout[0]:")
      item = readInt
      if (item == 0) {
        continue = false
      } else {
        items.++=(List(item))
      }
    }
    items
  }

  def applyServiceCharge(items: MutableList[Int], availableItems: Map[Int, String], total: Double): Double = {
    var serviceCharge = 0.0
    for (item <- items) {
      if (availableItems.get(item).toString().contains("Hot")) {
        serviceCharge = total + (total * 20 / 100)
        println("Total after 20% Service Charge = " + serviceCharge)
        return serviceCharge
      }
    }
    for (item <- items) {
      if (availableItems.get(item).toString().contains("Sandwich")) {
        serviceCharge = total + (total * 10 / 100)
        println("Total after 10% Service Charge = " + serviceCharge)
        return serviceCharge
      }
    }
    serviceCharge
  }
}