package scala

import java.sql.{Connection, DriverManager, PreparedStatement, ResultSet}


object ScalaJdbcConnect {
  def main(args: Array[String]): Unit = {
    B()
    A()
  }

  /**
    * cha
    */
  def A(): Unit ={
    var resultSet:ResultSet=null
    val sql="select * from a"
    val db1=new DBHelper(sql)
    try{
      resultSet=db1.preparedStatement.executeQuery()
      while(resultSet.next()){
        val id=resultSet.getString("id")
        val name=resultSet.getString("name")
        println("name="+name+" "+"id="+id)
      }
    }catch{
      case e:Exception =>e.printStackTrace
    }finally {
      db1.connection.close()
      db1.preparedStatement.close()
    }
  }

  /**
    *
    */
  def B(): Unit ={
    val sql="insert into a(id,name) values(null,'lisi')"
    val db1=new DBHelper(sql)
    try{
      val i=db1.preparedStatement.executeUpdate()
     if(i>0){
       println("success")
     }
    }catch{
      case e:Exception =>e.printStackTrace
    }finally {
      db1.connection.close()
      db1.preparedStatement.close()
    }
  }


  class DBHelper {
    val driver:String="com.mysql.jdbc.Driver"
    val url:String="jdbc:mysql://localhost:3306/testDatabases"
    val username:String="root"
    val password:String="123456"
    var connection:Connection=null
    var preparedStatement: PreparedStatement = null

    def this(sql:String){
      this()
        try {
          Class.forName(driver)
          connection=DriverManager.getConnection(url,username,password)
          preparedStatement=connection.prepareStatement(sql)
        }catch{
          case e:Exception =>e.printStackTrace
        }
    }



  }

}
