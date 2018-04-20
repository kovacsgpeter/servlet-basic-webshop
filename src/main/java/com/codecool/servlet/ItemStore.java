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
@WebServlet(name = "ItemStore", urlPatterns = {"/itemstore"}, loadOnStartup = 2)
public class ItemStore extends HttpServlet {
    public static ArrayList<Item> itemList = new ArrayList<>();
    //private

    public static float getSum() {
        float sum = 0;
        for (Item item: itemList) {
            sum += item.getPrice();
        }
        return sum;
    }

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
        request.setAttribute("sum", getSum());
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/itemstore.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isOnItemStore = false;

            ItemStore.removeFromItemList(Utils.returnItem(request.getParameter("buttonhd"), itemList));




        request.setAttribute("sum", getSum());
        request.setAttribute("itemPool", itemList);
        request.getRequestDispatcher("WEB-INF/templates/itemstore.jsp").forward(request, response);
    }


}
