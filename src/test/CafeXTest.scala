package test


import org.junit.Test
import org.coffee.house.CafeX

class CafeXTest {
  @Test
  def testConstructor(){
    assert(!CafeX.getAvailableItems.isEmpty)
  }

}