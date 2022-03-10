//Pratik Mohare
package com.dao;
import com.bean.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import com.bean.StudentBean;

public class StudentDAO {
    private String firstname;
    private String lastname;
    private String studentID;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String data;
    private String phone;
    private String url;
    private String dsurvey;
    private String likes;
    private String interest;
    private String comments;
    private String gradmonth;
    private String gradyear;
    private String recommend;
    
    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }
    
    public String getFirstName() {
        return this.firstname;
    }
    
    public void setLastName(String lastname) {
        this.lastname = lastname;
    }
    public String getLastName() {
        return this.lastname;
    }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public String getStudentID() {
        return this.studentID;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet() {
        return this.street;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public String getState() {
        return this.state;
    }
    
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public String getZip() {
        return this.zip;
    }
    
    public void setData(String data) {
        this.data = data;
    }
    
    public String getData() {
        return this.data;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setURL(String url) {
        this.url = url;
    }
    
    public String getURL() {
        return this.url;
    }
    
    public void setDate(String dsurvey) {
        this.dsurvey = dsurvey;
    }
    
    public String getDate() {
        return this.dsurvey;
    }
    
    public void setLikes(String likes) {
        this.likes = likes;
    }
    
    public String getLikes() {
        return this.likes;
    }
    
    public void setInterest(String interest) {
        this.interest = interest;
    }
    
    public String getInterest() {
        return this.interest;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    public String getComments() {
        return this.comments;
    }
    
    public void setGradMonth(String gradmonth) {
        this.gradmonth = gradmonth;
    }
    
    public String getGradMonth() {
        return this.gradmonth;
    }
    
    public void setGradYear(String gradyear) {
        this.gradyear = gradyear;
    }
    
    public String getGradYear() {
        return this.gradyear;
    }
    
    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }
    
    public String getRecommend() {
        return this.recommend;
    }
    
    
    public List<String> storedata() {
        String url_c = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        String uname = "sdashor";
        String pass = "juthavyf";
        ArrayList<String> si = new ArrayList<String>();
        System.out.println("Inside StoreData");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url_c, uname, pass);
            PreparedStatement pstmt = con.prepareStatement("insert into Students values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, this.firstname);
            pstmt.setString(2, this.lastname);
            pstmt.setString(3, this.studentID);
			pstmt.setString(4, this.street);
            pstmt.setString(5, this.city);
            pstmt.setString(6, this.state);
            pstmt.setString(7, this.zip);
			pstmt.setString(8, this.phone);
            pstmt.setString(9, this.email);          
            pstmt.setString(10, this.url);
            pstmt.setString(11, this.dsurvey);
            pstmt.setString(12, this.likes);
            pstmt.setString(13, this.interest);
			pstmt.setString(14, this.recommend);
            pstmt.setString(15, this.gradmonth);
            pstmt.setString(16, this.gradyear);
            pstmt.setString(17, this.comments);
			pstmt.setString(18, this.data);
            pstmt.executeUpdate();
            pstmt.close();

            pstmt = con.prepareStatement("select StudentID from Students");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                si.add(rs.getString("StudentID"));
            }
            pstmt.close();
            con.close();
            return si;
        }
        catch (Exception e) {
        	System.out.println("Connection Error");
        	System.out.println(e);
        	
            e.printStackTrace();
            return null;
        }
    }
    
    public StudentBean getStudentData(String stdid) {
        String url_c = "jdbc:oracle:thin:@artemis.vsnet.gmu.edu:1521/vse18c.vsnet.gmu.edu";
        String uname = "sdashor";
        String pass = "juthavyf";

		StudentBean sb = new StudentBean();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url_c, uname, pass);
			PreparedStatement pstmt = con.prepareStatement("select * from Students where StudentID=?");
			System.out.println("STDID is:"+stdid);
			pstmt.setString(1, stdid);
			ResultSet results = pstmt.executeQuery();
			int i = 0;
			while (results.next()) {
				++i;
				sb.setFirstName(results.getString("firstname"));
				sb.setLastName(results.getString("lastname"));
				sb.setStudentID(results.getString("studentID"));
				sb.setStreet(results.getString("street"));
				sb.setCity(results.getString("city"));
				sb.setState(results.getString("state"));
				sb.setZip(results.getString("zip"));
				sb.setPhone(results.getString("phone"));
				sb.setEmail(results.getString("email"));
				sb.setURL(results.getString("url"));
				sb.setDate(results.getString("dsurvey"));
				sb.setLikes(results.getString("likes"));
				sb.setInterest(results.getString("interest"));
				sb.setRecommend(results.getString("recommend"));
				sb.setGradMonth(results.getString("gradmonth"));
				sb.setGradYear(results.getString("gradyear"));
				sb.setComments(results.getString("comments"));
				sb.setData(results.getString("data"));   
			}
			pstmt.close();
			con.close();
			if (i > 0) {
				return sb;
			}
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
   	}
}