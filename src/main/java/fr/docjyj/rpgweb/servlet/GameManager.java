package fr.docjyj.rpgweb.servlet;

import com.google.gson.Gson;
import fr.docjyj.rpgweb.beans.Stock.DataStock;
import fr.docjyj.rpgweb.beans.Stock.ObjectStock;
import fr.docjyj.rpgweb.beans.Stock.RoomStock;

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
    private String FILENAME = "C:\\Users\\jysl\\Desktop\\game\\GameStock.json";

    //BUG DU BOUTON CANCEL

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataStock dataStock = GSON.fromJson(new FileReader(FILENAME), DataStock.class);
        //EDIT
        if(request.getParameterMap().containsKey("edit")){
            request.getSession().getServletContext().setAttribute("type", request.getParameter("type"));
            request.getSession().getServletContext().setAttribute("id", request.getParameter("id"));

            if(request.getParameter("type").equals("room")){
                if(request.getParameter("id").equals("add")){
                    request.getSession().getServletContext().setAttribute("object", new RoomStock());
                }
                else{//
                    request.getSession().getServletContext().setAttribute("object", dataStock.getRooms().get(Integer.parseInt(request.getParameter("id"))));
                }
                request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/form-room.jsp").forward(request, response);
            }
            else{
                if(request.getParameter("id").equals("add")){
                    request.getSession().getServletContext().setAttribute("object", new ObjectStock());
                }
                else{
                    int id = Integer.parseInt(request.getParameter("id"));
                    ObjectStock object = null;
                    switch (request.getParameter("type")) {
                        case "player":
                            object = dataStock.getPlayers().get(id);
                            break;
                        case "mob":
                            object = dataStock.getMobs().get(id);
                            break;
                        case "weapon":
                            object = dataStock.getWeapons().get(id);
                            break;
                        case "object":
                            object = dataStock.getObject().get(id);
                            break;
                    }
                    request.getSession().getServletContext().setAttribute("object", object);
                }
                request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/form.jsp").forward(request, response);
            }
        }
        //REMOVE
        else if(request.getParameterMap().containsKey("remove")){
            request.getSession().getServletContext().setAttribute("type", request.getParameter("type"));
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
            map.put("item", dataStock.getWeapons());
            data.add(map);
            map = new TreeMap<>();
            map.put("name", "object");
            map.put("item", dataStock.getObject());
            data.add(map);
            request.getSession().getServletContext().setAttribute("data", data);
            request.getSession().getServletContext().setAttribute("rooms", dataStock.getRooms());
            request.getServletContext().getRequestDispatcher("/WEB-INF/app/game-manager/main.jsp").forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataStock dataStock = GSON.fromJson(new FileReader(FILENAME), DataStock.class);
        if(request.getParameterMap().containsKey("put")){
            if(request.getParameter("type").equals("room")){
                RoomStock room = new RoomStock();
                room.setName(request.getParameter("name"));
                room.setPicture(request.getParameter("picture"));
                room.setDescription(request.getParameter("description"));
                room.setColor(request.getParameter("color"));
                room.setX(Integer.parseInt(request.getParameter("x")));
                room.setY(Integer.parseInt(request.getParameter("y")));
                room.settX(Integer.parseInt(request.getParameter("tX")));
                room.settY(Integer.parseInt(request.getParameter("tY")));
                if(request.getParameter("id").equals("add")){
                    List<Integer> room2 = new ArrayList<>();
                    room.setMobs(room2);
                    room.setWeapons(room2);
                    room.setObjects(room2);
                    dataStock.getRooms().add(room);
                }
                else {
                    RoomStock room2 = dataStock.getRooms().get(Integer.parseInt(request.getParameter("id")));
                    room.setMobs(room2.getMobs());
                    room.setWeapons(room2.getWeapons());
                    room.setObjects(room2.getObjects());
                    dataStock.getRooms().set(Integer.parseInt(request.getParameter("id")), room);
                }
            }
            else {
                ObjectStock object = new ObjectStock();
                object.setName(request.getParameter("name"));
                object.setPicture(request.getParameter("picture"));
                object.setDescription(request.getParameter("description"));
                object.setColor(request.getParameter("color"));
                object.setHealth(Integer.parseInt(request.getParameter("health")));
                object.setSrength(Integer.parseInt(request.getParameter("srength")));
                object.setAgility(Integer.parseInt(request.getParameter("agility")));
                object.setFocus(Integer.parseInt(request.getParameter("focus")));
                object.setAttack(Integer.parseInt(request.getParameter("attack")));
                if (request.getParameter("id").equals("add")) {
                    switch (request.getParameter("type")) {
                        case "player":
                            dataStock.getPlayers().add(object);
                            break;
                        case "mob":
                            dataStock.getMobs().add(object);
                            break;
                        case "weapon":
                            dataStock.getWeapons().add(object);
                            break;
                        case "object":
                            dataStock.getObject().add(object);
                            break;
                    }
                } else {
                    switch (request.getParameter("type")) {
                        case "player":
                            dataStock.getPlayers().set(Integer.parseInt(request.getParameter("id")), object);
                            break;
                        case "mob":
                            dataStock.getMobs().set(Integer.parseInt(request.getParameter("id")), object);
                            break;
                        case "weapon":
                            dataStock.getWeapons().set(Integer.parseInt(request.getParameter("id")), object);
                            break;
                        case "object":
                            dataStock.getObject().set(Integer.parseInt(request.getParameter("id")), object);
                            break;
                    }
                }
            }
        }
        else if(request.getParameterMap().containsKey("remove")){
            switch (request.getParameter("type")) {
                case "player":
                    dataStock.getPlayers().remove(Integer.parseInt(request.getParameter("id")));
                    break;
                case "mob":
                    dataStock.getMobs().remove(Integer.parseInt(request.getParameter("id")));
                    break;
                case "weapon":
                    dataStock.getWeapons().remove(Integer.parseInt(request.getParameter("id")));
                    break;
                case "object":
                    dataStock.getObject().remove(Integer.parseInt(request.getParameter("id")));
                    break;
                case "room":
                    dataStock.getRooms().remove(Integer.parseInt(request.getParameter("id")));
                    break;
            }
        }
        PrintWriter writer = new PrintWriter(FILENAME, "UTF-8");
        writer.print(GSON.toJson(dataStock));
        writer.close();
        response.sendRedirect("?");
    }
}
