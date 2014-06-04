<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header id="css_header">
		<div id="Layer1">
			<img src="cbnl_logo.png" style="height:70px; width:150px; margin:5px">
		</div>

		<div id="heading">
			<div id="Layer2">
				<label style="margin: 10px 10px 10px 10px;">VectaStar Network Management System</label>
			</div>

			<div id="Layer3" align="right">
				<label><a href="#">User: Username</a></label>
				<br/>
				<label id="datetime"> Date-Time</label>
				<br/>
				<label><a href="#">Log Out</a> &nbsp &nbsp <a href="#">Help</a> &nbsp &nbsp <a href="#">About Us </a></label>
			</div>
		</div>

	
		<div id="Layer4">
		<nav id="css_main_menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Fault</a></li>
				<li><a href="#">Configuration</a></li>
				<li><a href="#">Security</a></li>
				<li><a href="#">Performance</a></li>
			</ul>
		</nav>
		</div>
	</header>


	<nav id="css_menu">
		<ul>
			<li><a href="#">Alarms   <img src="desc.png" style="height:15px; width:20px;margin-top:0px;"></a>
				<ul>
					<li><a href="#">Alarms Summary</a></li>
					<li><a href="#">View Alarms</a></li>
					<li><a href="#">Alarm Statistics</a></li>
				</ul>
			</li>
			<li><a href="#">Events</a></li>
			<li><a href="#">Outages</a></li>
			<li><a href="#">Priority Classes</a></li>
			<li><a href="#">Availabilty</a></li>
		</ul>
	</nav>

	<section id="content">
		<label>
			<span class="label_alarm">View Alarms</span>
		</label>
		<br>
		<span class="alarm_link">
			<a href="">Advanced Search</a>  <label style="padding: 20px 20px 20px 20px"><a href="">Severity Legend</a>
		</span>
		
		<br>
		<br>
		
		<span class="alarm_link">
			<label>Alarm Text:
				<input type="text" name="textfield"/>
			</label>
		</span>
	
		<span class="alarm_link">
			<label>Time:
				<select style="height:22px">
					<option value="any">Any</option>
					<option value="this_hour">This Hour</option>
					<option value="last_one">Last 1 Hour</option>	
					<option value="last_two">Last 2 Hour</option>
					<option value="last_day">Last Day</option>
					<option value="last_week">Last Week</option>
				</select>
			</label>
		</span>

		<button type="button">Search</button> 
		<br>
		<span class="alarm_link">
			<label>Search Constraints:</label>
		</span>
	<br>
	<br>

	<p><table id="example" class="display" style={margin:10px 10px 10px 10px; cellspacing="0"; width="100%";}>
	<thead>
	<tr>
		<th>Select</th>
		<th>AlarmID</th>
		<th>Severity</th>
		<th>Source</th>
		<th>Date/Time</th>
		<th>Message</th>
	</tr>
	</thead>

	<tfoot>
	<tr>
		<th>Select</th>
		<th>AlarmID</th>
		<th>Severity</th>
		<th>Source</th>
		<th>Date/Time</th>
		<th>Message</th>
	</tr>
	</tfoot>

	<tbody>
	</tbody>
	</table>
	</p>

	<hr>
	<p id="action">
		Action:
		<select>
  			<option value="acknowledge">Acknowledge Alarms</option>
			<option value="clear">Clear Alarms</option>
			<option value="escalate">Escalate Alarms</option>
		</select>
	</action>

	<button type="button"> Go </button>	

</section>

<footer id="css_footer">
	<a href="#">Contact Us</a> |
	<a href="#">Site Map</a>
</footer>

</body>
</html>