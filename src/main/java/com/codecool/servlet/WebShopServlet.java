package com.codecool.servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "simpleServlet", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet{
    private List<Item> itemPool = new ArrayList<>();

    public void init() {

        itemPool.add(new Item("Apple MBP", 500));
        itemPool.add(new Item("Dell Inspiron", 200));
        itemPool.add(new Item("Lenovo U510", 100));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "";
        String pathVar = getServletContext().getRealPath("/") + "css/style.css";

        //head
        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>\n");
        //links
        out.println("<link rel='stylesheet' type='text/css' href='/styles/style.css' />");
        out.println("</head>\n");


        out.println(
                        "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n"
        );
        //table
        out.println("<table>");
         for (Item item: itemPool){
             out.println("<tr><td>"+item.nameToString() + "</td><td>" + item.priceToString() + "</td></tr>");
         }
        out.println("</table>");

        out.println("</ul>\n" +
                "<div>Visit another servlet: <a href=\"/ItemStore\">Item Cart</a></div>" +
                "</body></html>");
    }

}


