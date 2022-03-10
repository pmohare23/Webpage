<%--Samriddhi Dashora --%>
<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.List" %>
<html>
<head>
<title>Simple Acknowledgement</title>
</head>
<body>
        <h2>Thank you for submitting the form !!!</h2>
        <h4>Mean :  ${dataBean.getMean()}</h4>
        <h4>Standard Deviation is: ${dataBean.getStd()}</h4>
		<h4> List of student ID's available in database:</h4>
        <ul>
            <%
                List<String> sids = (List<String>) request.getAttribute("stdids");
                for (String id : sids) {
            %>
            <li><b><a href="stddata?param=<%=id%>"><%= id %></a></b></li>
            <%
                }
            %>
        </ul>  
</body>
</html>