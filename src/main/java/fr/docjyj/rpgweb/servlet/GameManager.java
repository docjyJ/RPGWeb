package fr.docjyj.rpgweb.servlet;

import com.google.gson.Gson;
import fr.docjyj.rpgweb.beans.Stock.DataStock;
import fr.docjyj.rpgweb.beans.Stock.ObjectStock;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet( name="GameManager", urlPatterns = "/game-manager" )
public class GameManager extends HttpServlet {
    private Gson GSON = new Gson();
    private String FILENAME = "C:\\Users\\jysl\\Desktop\\GameStock.json";

    //BUG DU BOUTON CANCEL

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataStock dataStock = GSON.fromJson(new FileReader(FILENAME), DataStock.class);
        //EDIT
        if(request.getParameterMap().containsKey("edit")){
            request.getSession().getServletContext().setAttribute("name", request.getParameter("type"));
            request.getSession().getServletContext().setAttribute("id", request.getParameter("id"));
            if(request.getParameter("id").equals("add")){
                request.getSession().getServletContext().setAttribute("object", new ObjectStock());
            }
            else{
                request.getSession().getServletContext().setAttribute("object", dataStock.getPlayers().get(Integer.parseInt(request.getParameter("id"))));
            }
            request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/form.jsp").forward(request, response);
        }
        //REMOVE
        else if(request.getParameterMap().containsKey("remove")){
            request.getSession().getServletContext().setAttribute("name", request.getParameter("type"));
            request.getSession().getServletContext().setAttribute("id", request.getParameter("id"));
            request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/remove.jsp").forward(request, response);
        }
        //ELSE
        else {
            List<Map<String,Object>> data = new ArrayList<>();
            Map<String,Object> map;
            map = new TreeMap<>();
            map.put("name", "player");
            map.put("item", dataStock.getPlayers());
            data.add(map);
            map = new TreeMap<>();
            map.put("name", "mob");
            map.put("item", dataStock.getMobs());
            data.add(map);
            map = new TreeMap<>();
            map.put("name", "weapon");
            map.put("item", dataStock.getWeapon());
            data.add(map);
            map = new TreeMap<>();
            map.put("name", "object");
            map.put("item", dataStock.getObject());
            data.add(map);
            //map = new TreeMap<>();
            //map.put("name", "room");
            //map.put("item", dataStock.getRoom());
            //data.add(map);
            request.getSession().getServletContext().setAttribute("data", data);
            request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/main.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataStock dataStock = GSON.fromJson(new FileReader(FILENAME), DataStock.class);
        if(request.getParameterMap().containsKey("put-player")){
            ObjectStock entity = SetObject(request);
            if(request.getParameter("id").equals("add")){
                dataStock.getPlayers().add(entity);
            }
            else {
                dataStock.getPlayers().set(Integer.parseInt(request.getParameter("id")), entity);
            }
        }
        else if(request.getParameterMap().containsKey("remove-player")){
            dataStock.getPlayers().remove(Integer.parseInt(request.getParameter("id")));
        }
        else if(request.getParameterMap().containsKey("put-mob")){
            ObjectStock entity = SetObject(request);
            if(request.getParameter("id").equals("add")){
                dataStock.getMobs().add(entity);
            }
            else {
                dataStock.getMobs().set(Integer.parseInt(request.getParameter("id")), entity);
            }
        }
        else if(request.getParameterMap().containsKey("remove-mob")){
            dataStock.getMobs().remove(Integer.parseInt(request.getParameter("id")));
        }
        else if(request.getParameterMap().containsKey("put-object")){
            ObjectStock object = SetObject(request);
            System.out.println(GSON.toJson(object));
            if(request.getParameter("id").equals("add")){
                dataStock.getObject().add(object);
            }
            else {
                dataStock.getObject().set(Integer.parseInt(request.getParameter("id")), object);
            }
        }
        else if(request.getParameterMap().containsKey("remove-object")){
            dataStock.getObject().remove(Integer.parseInt(request.getParameter("id")));
        }
        PrintWriter writer = new PrintWriter(FILENAME, "UTF-8");
        writer.print(GSON.toJson(dataStock));
        writer.close();
        response.sendRedirect("?");
    }

    private ObjectStock SetObject(HttpServletRequest request) {
        ObjectStock object = new ObjectStock();
        object.setName(request.getParameter("name"));
        object.setPicture(request.getParameter("picture"));
        object.setDescription(request.getParameter("description"));
        object.setHealth(Integer.parseInt(request.getParameter("health")));
        object.setSrength(Integer.parseInt(request.getParameter("srength")));
        object.setAgility(Integer.parseInt(request.getParameter("agility")));
        object.setFocus(Integer.parseInt(request.getParameter("focus")));
        object.setAttack(Integer.parseInt(request.getParameter("attack")));
        return object;
    }
}
