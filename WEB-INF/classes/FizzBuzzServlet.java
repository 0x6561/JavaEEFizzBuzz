// Saved as "fizzbuzz\WEB-INF\classes\FizzBuzz.java".
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/fizzbuzz")
public class FizzBuzzServlet extends HttpServlet {

  // The doGet() runs once per HTTP GET request to this servlet.
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    // Set the MIME type for the response message
    response.setContentType("text/html");
    // Get a output writer to write the response message into the network socket
    PrintWriter out = response.getWriter();
    int fizzBuzzInt = 0;
    String fizzBuzzString;
    String output;

    try  // catch IOException
    {
      try // validate input
      {
        if(request.getParameter("number") != null){
          fizzBuzzString = request.getParameter("number");
          fizzBuzzInt = Integer.parseInt(fizzBuzzString); 
          output = fizzBuzz(fizzBuzzInt);
        }
        else{
          output = "Please enter an integer, such as 1, 2, 3 etc.";
        }
      }
      catch(NumberFormatException e)
      {
        output = "Please enter an integer, such as 1, 2, 3 etc.";
      }
      // Print an HTML page 
      out.println(createPage(output));
    } 
    finally {
      out.close();
    }
  }
  public String fizzBuzz(int i)
  {
    String fb = i + " = ";
    if(i == 0){
      fb = " " + i + " ";
    } else if(i%15 == 0){
      fb += " Fizz Buzz!";
    }else if(i%3 == 0){
      fb += " Fizz!";
    }else if(i%5 == 0){
      fb += " Buzz!";
    }else{
      fb = " " + i + " ";
    }
    return fb;
  }
  public String createPage(String content)
  {
    String page = new StringBuilder() 
      .append("<!doctype html>")
      .append("<html lang=\"en\">")
      .append("<head>")
      .append("<!-- Required meta tags -->")
      .append("<meta charset=\"utf-8\">")
      .append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">")
      .append("<!-- Bootstrap CSS -->")
      .append("<link rel=\"stylesheet\" href=\"/fizzbuzz/css/bootstrap.css\">")
      .append("<title>Fizz or Buzz?</title>")
      .append("</head>")
      .append("<body>")
      .append("<div class=\"container h-100\">")
      .append("<div class=\"row h-100 justify-content-center align-items-center\">")

      .append("<h1>Fizz or Buzz?</h1>")
      .append("<div class=\"jumbotron\">")
      .append("<h1 class=\"display-4\">" + content + "</h1>")
      .append("<hr class=\"my-4\">")
      .append("<a class=\"btn btn-primary btn-lg\" href=\"javascript:history.back()\" role=\"button\">Try again</a>")
      .append("</div>")
      .append("<!-- Optional JavaScript -->")
      .append("<!-- jQuery first, then Popper.js, then Bootstrap JS -->")
      .append("<script src=\"/fizzbuzz/js/jquery-3.3.1.js\"></script>")
      .append("<script src=\"/fizzbuzz/js/umd/popper.js\"></script>")
      .append("<script src=\"/fizzbuzz/js/bootstrap.js\"></script>")
      .append("</div></div>")
      .append("</body>")
      .append("</html>")
      .toString();
    return page;
  }
}//close FizzBuzzServlet class
