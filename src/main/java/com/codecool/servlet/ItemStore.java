package com.codecool.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
            throws IOException, ServletException {

        request.setAttribute("itemPool", itemList);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/webshop.jsp");
        view.forward(request, response);

    }


}
