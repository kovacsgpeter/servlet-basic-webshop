package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "ItemStore", urlPatterns = {"/ItemStore"}, loadOnStartup = 2)
public class ItemStore extends HttpServlet {
    private static List<Item> itemList = new ArrayList<>();
    //private


    public static void addToItemList(Item item) {
        ItemStore.itemList.add(item);
    }

    public static void removeFromItemList(Item item) {
        ItemStore.itemList.remove(item);
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "Item Store";

        out.println(
                "<html>\n" +
                        "<head><title>" + title + "</title>\n");
        out.println("<link rel='stylesheet' type='text/css' href='/styles/style.css' />");
        out.println("</head>\n");

        out.println(
                "<body>\n" +
                        "<h1 align = \"center\">" + title + "</h1>\n" +
                        "<ul>\n"
        );

        out.println("<table>");
        for (Item item: itemList){
            out.println("<tr><td>"+item.nameToString() + "</td><td>" + item.priceToString() + "</td></tr>");
        }
        out.println("</table>");
        out.println("</ul>\n" +
                "<div>Visit another servlet: <a href=\"/ItemStore\">Visit the other servlet</a></div>" +
                "</body></html>");
    }


}
