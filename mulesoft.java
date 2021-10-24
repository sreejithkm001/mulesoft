
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class mulesoft 
{

    
    private Connection connect()
     {
        
        String url = "jdbc:sqlite:C://sqlite/db/test.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) 
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }

   
    public void insert(String movie_name, String actor, String actress,String director,String year_of_release)
     {
        String sql = "INSERT INTO details(movie_name,actor,actress,director,year_of_release) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) 
                {
            pstmt.setString(1, movie_name);
            pstmt.setString(2, actor);
            pstmt.setString(3, actress);
            pstmt.setString(4,director);
            pstmt.setString(5, year_of_release);
            pstmt.executeUpdate();
                 } 

          public void selectAll()
          {
        String sql1 = "SELECT movie_name,actor,actress,director,year_of_release FROM details";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql1))
             {
            
            while (rs.next()) 
            {
                System.out.println(rs.getString("movie_name") +  "\t" +  rs.getString("actor") + "\t" + rs.getString("actress")+ "\t" + rs.getString("director") +  "\t" + rs.getString("year_of_release")  );
            }
           catch (SQLException e) 
           {
            System.out.println(e.getMessage());
           }
    }

   
    public static void main(String[] args) 
    {

        mulesoft app = new mulesoft();
       
        app.insert("jilla","vijay","thamanna","jose","2000");
        app.insert("ayan","surya","thrisha","laljose","2001" );
        app.insert("kathi","ajith","deepthi","krishna","2002");
        app.insert("vivegam","sharukh","diya","jayan","2003");
        app.insert("sura","mohanlal","diana","sudu","2004");
        app.insert("pokkiri","mammootty","deepika","ram","2005");
    }

}