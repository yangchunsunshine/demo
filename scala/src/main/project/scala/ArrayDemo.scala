package scala

object ArrayDemo {
  def main(args: Array[String]): Unit = {
    var array=Array(1,2,4,"4")
//    array.foreach(i=>println(i))

//    for(i<- array){
//      println(i)
//    }

//    for(i<- (0 to array.length-1)){
//      println(array(i))
//    }

//    for(i<- (0 until array.length)){
//        println("i="+array(i))
//    }
//
//    println(0 to 4)
//    println(0 until 4)

    var a1=Array(1,2,3,4)
    var a2=Array(5,6,7,8)
//    copy(src: AnyRef, srcPos: Int, dest: AnyRef, destPos: Int, length: Int)
    var a3=Array.copy(a1,2,a2,1,1)//(5,6,3,4,7,8)
    //println(a3.isInstanceOf)

  }

}
