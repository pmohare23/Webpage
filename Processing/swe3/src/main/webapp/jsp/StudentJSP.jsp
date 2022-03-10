<%--Pratik Mohare--%>
<%@ page language="java" contentType="text/html"%>
<html>
<head>
<title>Student Data</title>
</head>
<body>
<h2> Saved Form Data</h2>	
	<form>
		<table align="center">
			<tr>
				<td><label>StudentID</label><br /> <input type="text"
					id="studentID" name="studentID" value="${stdbean.getStudentID()}" readonly /></td>
			
				<td><label>First Name</label><br /> <input type="text"
					id="firstname" name="firstname" value="${stdbean.getFirstName()}"
					readonly /></td>

				

				<td><label>Last Name</label><br /> <input type="text"
					id="lastname" name="lastname" value="${stdbean.getLastName()}" readonly/></td>


			</tr>
			<tr>
				<td><label>Street Address </label><br /> <input type="text"
					name="street" id="street" value="${stdbean.getStreet()}"
					readonly/></td>

				<td><label>Zipcode</label><br /> <input type="text" name="zip"
					id="zip" value="${stdbean.getZip()}" readonly /></td>

				<td><label>City</label><br /> <input type="text" name="city"
					id="city" value="${stdbean.getCity()}" readonly /></td>
			</tr>
			<tr>
				<td><label>State</label><br /> <input type="text" name="state"
					id="state" value="${stdbean.getState()}" readonly></td>
				<td><label>Telephone Number</label><br /> <input
					name="phone" id="phone" type="text"
					value="${stdbean.getPhone()}" readonly /></td>
				<td><label>Email</label><br /> <input type="text"
					name="email" id="email" value="${stdbean.getEmail()}"
					readonly/></td>

			</tr>
			<tr>
				<td><label>URL</label><br /> <input name="url" type="text"
					value="${stdbean.getURL()}" readonly /></td>
				<td><label>Date of Survey:</label><br /> <input type="text"
					name="dsurvey" id="dsurvey" value="${stdbean.getDate()}"
					readonly/></td>
				<td><label>Data entered </label><br /> <input type="text"
					name="data" value="${stdbean.getData()}" readonly /></td>
			<tr>
				<td><label>LikeMost</label><br /> <input name="likes"
					type="text" value="${stdbean.getLikes()}" readonly/></td>
				<td><label>Interest</label><br /> <input name="interest"
					type="text" value="${stdbean.getInterest()}" readonly />
				</td>
				<td><label>Recommend</label><br /> <input name="recommend"
					type="text" value="${stdbean.getRecommend()}" readonly /></td>

			</tr>
			
			<tr>
				<td><label>GradMonth</label><br /> <input type="text"
					name="gradmonth" value="${stdbean.getGradMonth()}" readonly /></td>
				<td><label>Year</label><br /> <input type="text" name="Year"
					value="${stdbean.getGradYear()}" readonly /></td>
					
					<td><label>Comments</label><br /> <input type="text" name="comments"
					value="${stdbean.getComments()}" readonly /></td>
			</tr>
		</table>
	</form>
</body>
</html>
