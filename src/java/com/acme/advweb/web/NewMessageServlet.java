
package com.acme.advweb.web;


import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.sse.OutboundEvent;

@WebServlet("/newMessage")
public class NewMessageServlet extends HttpServlet{
    @Inject ParticipantList participantlists;
    
    @Resource(lookup="concurrent/myFirstPool")
    private ManagedScheduledExecutorService service;
    private String name;
    private Map<String,String> n;
    //private HttpSession s=new HttpSession() {};
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response){
        if(request.getParameter("name")!=null){
        name=request.getParameter("name");
        }
        System.out.println("WEATHER WONG "+name);
        String msg=request.getParameter("msg");
        String no=request.getParameter("no");
        
        
        System.out.println("NO>>>2"+new Date().getTime()+"attention"+no);
        service.submit(new BroadcastMessageTask(name,msg,participantlists,no));
        
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
