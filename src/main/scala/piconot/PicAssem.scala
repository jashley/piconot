package piconot

class PicAssem {
    var stat = 0
    var surr = 0
    var dir = 0
    var ext = 0
    var cmprslt = 0
  
    val STAT = "stat"
    val SURR = "surr"
    val DIR = "dir"
    val EXT = "ext"
    val CMPRSLT = "cmprslt"
    
  
  def MOV(reg: String)(hexVal: Integer): Unit = {
      assert(hexVal >= 0)
      reg match {
        case "stat" => stat = {
          assert(hexVal <= 99)
          hexVal
        }
        case "surr" => surr = {
          assert(hexVal <= 15)
          hexVal
        }
        case "dir" => dir = {
          assert(hexVal <= 3)
          hexVal
        }
        case _ => assert(false) //Not sure what happened, gonna fail
      }
    }
    
  def AND(reg1: String)(reg2: String)(hexVal: Integer) {
    assert(hexVal <= 15)
    // user must place result of AND into EXT
    assert(reg1.equals("ext"))
    // user must compare SURR to hexVal
    assert(reg2.equals("surr"))
    ext = surr & hexVal
  }
  
  def CMP(reg: String)(hexVal: Integer) {
    // user must compare using ext
    assert(reg.equals("ext"))
    cmprslt = if (ext == cmprslt) 1 else 0
  }
  
  /*
   * We believe that the code above this will work with the picolib code.
   * They are all there to set vars so that, when we move to the next rule,
   * we know what our surroundings are.
   * 
   * The jump functions below were/are the meat of the work. JMP must be able
   * to move to the top of our rule set after picobot moves. JMPNE must move to
   * the next rule if the current one does not match. One would also have to
   * determine if we were hitting an infinite loop and break.
   * These functions would use the state variables to determine what our surroundings
   * and state are. We were unsure of how to
   * implement this, though we looked into using goto's and the like to jump to
   * various parts of our code. Ultimately, we decided the amount of time spent
   * would not be worth it, especially considering that this is already late.
   */
  
//  def JMP {
//    
//  }  
  
//  def JMPNE {
//    
//  }
}