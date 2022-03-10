//Pratik Mohare, Samriddhi Dashora, Hrishikesh Vibhute, Tomas Doherty
package com.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.DataBean;
import com.bean.StudentBean;
import com.dao.DataProcessor;
import com.dao.StudentDAO;

public class Mainservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Mainservlet() {}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO dao = new StudentDAO();
		dao.setFirstName(request.getParameter("firstname"));
		dao.setLastName(request.getParameter("lastname"));
		dao.setStudentID(request.getParameter("studentID"));
		dao.setStreet(request.getParameter("street"));
		dao.setCity(request.getParameter("city"));
		dao.setState(request.getParameter("state"));
		dao.setZip(request.getParameter("zip"));
		dao.setPhone(request.getParameter("phone"));
		dao.setEmail(request.getParameter("email"));
		dao.setURL(request.getParameter("url"));
		dao.setDate(request.getParameter("dsurvey"));
		String likevalues="";
		String vals[]=request.getParameterValues("likes");
		for(int i=0;i< vals.length;i++)
		{
			likevalues+= vals[i]+",";
		}
		dao.setLikes(likevalues);
		dao.setInterest(request.getParameter("interest"));
		dao.setRecommend(request.getParameter("recommend"));
		dao.setGradMonth(request.getParameter("gradmonth"));
		dao.setGradYear(request.getParameter("gradyear"));
		dao.setComments(request.getParameter("comments"));
		dao.setData(request.getParameter("data"));
		Object sids = dao.storedata();
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements()){
		 String paramName = params.nextElement();
		 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
		}
		if(sids!=null)
		{
			DataProcessor dp = new DataProcessor();
			DataBean dbean = dp.processNums(dao.getData());
			request.setAttribute("dataBean", dbean);
			request.setAttribute("stdids", sids);
			if(dbean.getMean() >= 90)
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/WinnerAcknowledgement.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("jsp/SimpleAcknowledgement.jsp");
				rd.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		StudentBean stdbean = dao.getStudentData(request.getParameter("param"));
	    if (stdbean != null) {
			HttpSession session = request.getSession();
			session.setAttribute("stdbean", stdbean);
			String values = stdbean.getLikes();
			
			String[] tokens = values.split(",");

			for(int i=0;i<tokens.length;i++)
			{
				session.setAttribute(tokens[i],"checked");
			}
			session.setAttribute(stdbean.getRecommend(),"selected");


			RequestDispatcher rd = request.getRequestDispatcher("jsp/StudentJSP.jsp");
			rd.include(request, response);
	    } 
		else {
			RequestDispatcher rd = request.getRequestDispatcher("jsp/NoStudent.jsp");
			rd.include(request, response);
	    }
	}
}