package com.codecool.servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//@WebServlet(name = "simpleServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class ServletWithAnnotations extends HttpServlet{
    /*private List<Item> itemPool = new ArrayList<>();

    public void init() {

        itemPool.add(new Item("Apple MBP", 500));
        itemPool.add(new Item("Dell Inspiron", 200));
        itemPool.add(new Item("Lenovo U510", 100));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "GET method with parameters to display";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n"
        );
        for (Item item: itemPool){
            out.println("<p>"+item.toString() + "</P>");
        }

        out.println("</ul>\n" +
                "<div>Visit another servlet: <a href=\"/another\">Visit the other servlet</a></div>" +
                "</body></html>");
    }
*/
}
