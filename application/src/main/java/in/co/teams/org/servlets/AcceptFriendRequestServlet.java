package in.co.teams.org.servlets;
import in.co.teams.org.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.hsbc.dao.UserDao;
import com.hsbc.dao.UserDaoImpl;

public class AcceptFriendRequestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		String userName1 = request.getParameter("userName1");  //reciever
		String userName2=request.getParameter("userName2");  //sender
		System.out.println(userName1 + userName2);
		UserDao user = new UserDaoImpl();
		int userId1 = user.getUserId(userName1);
		int userId2 = user.getUserId(userName2);
		System.out.println(userId1 +"---" +userId2);
		

	String msg=	user.acceptFriendRequest(userId1, userId2);
		
	if(msg.equals("Success")) {
		msg="Successful";
		}else {
			msg="Unsuccessful";
	}
		JSONObject obj = new JSONObject();
		obj.put("message", msg);
		
		System.out.println(obj.toJSONString());
		pw.println(obj.toJSONString());
		pw.close(); 
	}

}
