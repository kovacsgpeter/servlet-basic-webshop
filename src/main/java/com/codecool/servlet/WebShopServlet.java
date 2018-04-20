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

@WebServlet(name = "simpleServlet", urlPatterns = {"/webshop"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet{
    private static List<Item> itemPool = new ArrayList<>();
    private static List<String> itemPoolStrings = new ArrayList<>();
    public void init() {

        itemPool.add(new Item("Apple MBP", 500));
        itemPool.add(new Item("Dell Inspiron", 200));
        itemPool.add(new Item("Lenovo U510", 100));

        for (Item item: itemPool){itemPoolStrings.add(item.nameToString());}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        request.setAttribute("itemPool", itemPool);
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/templates/webshop.jsp");
        view.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println(itemPool.size());
        //System.out.println(request.getParameter("buttonhd"));
        ItemStore.addToItemList(returnItem(request.getParameter("buttonhd")));
        itemPool.remove(returnItem(request.getParameter("buttonhd")));
        System.out.println(itemPool.size());
        request.setAttribute("itemPool", itemPool);
        request.getRequestDispatcher("WEB-INF/templates/webshop.jsp").forward(request, response);
    }

    private static Item returnItem(String elName) {
        Item it = null;
        for (Item item : itemPool) {
            if (item.nameToString().equals(elName)) {
                it= item;
                System.out.println(it.nameToString());
            }
            }
        return it;
    }

}


