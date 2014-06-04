<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<title>View Alarms</title>
	<link rel="stylesheet" type=text/css href="<c:url value="/resources/css/style.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/jquery.dataTables.css" />">
	<script src="<c:url value="/resources/js/jquery-2.1.1.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.dataTables.js" />"></script>	


	<script>
		$(document).ready( function () {
			callme();
			
			$('#example').dataTable();

			var list = $('div.w-g-l > ul');
			list.children(':gt(7)').css( 'display', 'none' );

			var showingFull = false;
			$('<li><a>Show more features...</a></li>')
				.on( 'click', function (e) {
					e.preventDefault;

					if ( showingFull ) {
						list.children(':gt(7)').css( 'display', 'none' );
						list.children(':last').css( 'display', 'block' );
						$('a', this).html('Show more features...');
						showingFull = false;
					}
					else {
						list.find('li').css( 'display', 'block' );
						$('a', this).html('Show less');
						showingFull = true;
					}
				} )
				.appendTo( list );


			$.each( uniqueRand( 6, usedBy.length ), function (i, val) {
				data = usedBy[ val ];
				$('#usedBy').append(
					'<div class="unit one-sixth center">'+
						'<a href="'+data[0]+'"><img src="/media/images/used_by/'+data[1]+'" alt="DataTables is used by '+data

[2]+'"></a>'+
					'</div>'
				);
			} );
		} );

		$( "#Major" ).on( 'click', function( event ) {
			  console.log( 'clicked');
			});
		
		$( "#Minor" ).on( 'click', function( event ) {
			  console.log( 'clicked');
			});
		
		
		
	</script>
</head>
<body>
	<header id="css_header">
 		<div id="Layer1">
			<img src="<c:url value="/resources/Images/cbnl_logo.png" />" style="height:70px; margin:5px">
		</div>

		<div id="heading">
			<div id="Layer2">
				<label style="margin: 10px 10px 10px 10px;">VectaStar Network Management System</label>
			</div>

			<div id="Layer3" align="right">
				<label><a href="#">User: Username</a></label>
				<br/>
				<label id="datetime"></label>
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


	<div id="menu">
		<ul>
			<li><a href="#">Alarms</a>
				<ul>
					<li><a href="Alarm_Summary">Alarm Summary</a></li>
					<li><a href="View Alarms">View Alarms</a></li>
					<li><a href="Alarm_Statistics">Alarm Statistics</a></li>
				</ul>
			</li>
			<li><a href="#">Events</a></li>
			<li><a href="#">Outages</a></li>
			<li><a href="#">Priority Classes</a></li>
			<li><a href="#">Availabilty</a></li>
		</ul>
	</div>

	<section id="content">
		<label>
			<span class="label_alarm">View Alarms</span>
		</label>
		<br>
		<span class="alarm_link">
			<a href="">Advanced Search</a>  <label style="padding: 20px 20px 0px 20px"><a href="">Severity Legend</a>
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

	<p><table id="example">
	<thead>
	<tr id="heading">
		<th>Select</th>
		<th>AlarmID</th>
		<th>Severity</th>
		<th>Source</th>
		<th>Date/Time</th>
		<th>Message</th>
	</tr>
	</thead>
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
	
	<script>
function callme(){
	$.ajax({
	type:"get",
	url:"/vnms2/alarms",
	async:   false,
	data:{},
	dataType:"json",
	success:function(data){
<!--	alert("In success"); -->
	var list=data.longkey;
	var temparr=list.split("~");
	var len=temparr.length;
	var severity;
	for(i=1;i<len;i+=5)
	{
		switch(temparr[i+1])
		{
			case "1":
				severity="Cleared";
				break;
			case "2":
				severity="Normal";
				break;
			case "3":
				severity="Intermediate";
				break;
			case "4":
				severity="Warning";
				break;
			case "5":
				severity="Minor";
				break;
			case "6":
				severity="Major";
				break;
			case "7":
				severity="Critical";
				break;
			
		}
	var tempstr="<tr class = " + severity +">" + "<td>" + '<input type="checkbox">' + "</td>"+ "<td>"+ temparr[i] + "</td>"+'<td class="Severity">'+ severity+ ' [<a href="#" class="plus">+</a>]'+ ' [<a href="#">-</a>] '+ ' [<a href="#"><</a>] '+ ' [<a href="#">></a>] '+"</td>"+"<td>"+temparr[i+2]+ ' [<a href="#">+</a>] '+ ' [<a href="#">-</a>] '+ "</td>"+"<td>"+temparr[i+3]+ ' [<a href="#"><</a>] '+ ' [<a href="#">></a>] '+"</td>"+"<td>"+temparr[i+4]+"</td>"+"</tr>";
	$("#example").append(tempstr);
	}
/* alert("Invalid URL"); */
	}, 

});
}
			



</script>
</html>