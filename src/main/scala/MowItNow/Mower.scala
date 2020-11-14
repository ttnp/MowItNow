/**
 * MowItNow: Un programme de tondeuse à gazon automatique, écrit en Scala.
 * An automatic lawnmower program, written in Scala.
 * https://github.com/tnp1606/IMSD/tree/master/Scala
 *
 * ꧁꧂ DEME Saidatouna Aichatou & TRAN Thi Ngoc Phung ꧁꧂
 *
 * Master IMSD 2020
 */

package MowItNow

class Mower(limit:Array[Int], startPosition:Array[Int],startDirection:String) {
  // Creating variables
  private val cardinalAbbrev = List("E" , "N" , "W" , "S")
  private val cardinalNames = Array("East" , "North" , "West" , "South")

  private val maxSize = limit
  private var position = startPosition
  private var orientation : Int = this.cardinalAbbrev.indexOf(startDirection)

  // Handling position output
  override def toString: String = s"${this.position.mkString(" ")} ${cardinalAbbrev(orientation)} \nThe mower is currently at (${this.position.mkString(", ")}), facing ${cardinalNames(orientation)}."

  // Handling rotation orders (D & G)
  def rotate(turn:Char , verbose: Boolean = false): Unit ={
    val newCardinal : Int = this.orientation + {if (turn == 'D') -1 else 1}
    this.orientation = (newCardinal + 4) % 4
    if (verbose) println(s"${this.cardinalNames(this.orientation)}.")
  }

  // Handling moving orders (A)
  def move(verbose: Boolean =false): Unit ={
    val nextSquare = this.position
    val movement = {if (this.orientation < 2) 1 else -1}
    val axis = this.orientation % 2
    nextSquare(axis) += movement

    // Before assigning the new position, verify that the position is valid.
    if (0 <= nextSquare(axis) & nextSquare(axis) <= this.maxSize(axis)){
      this.position = nextSquare
      if (verbose) println(s"The mower has moved to ${this.cardinalNames(this.orientation)}.")
    } else if (verbose) println("The mower cannot move there.")
  }
}

