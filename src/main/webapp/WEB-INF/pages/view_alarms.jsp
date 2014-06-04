<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Alarms</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="javascript:callme()">


<table class="table table-striped" id="mytab" >
  <caption>View Alarms table</caption>
  <thead>
   <tr>
    <th>Alarm ID</th>
    <th>Severity</th>
     <th>Source</th>
     <th>Date/Time</th>
     <th>Message</th>
   </tr>
  </thead>
  <tbody id="tablebody">
 
  
  </tbody>
 </table>
 
 
</body>
<script>
function callme(){

	$.ajax({
	type:"get",
	url:"/vnms2/alarms",
	data:{},
	dataType:"json",
	success:function(data){
	
	var list=data.longkey;
	var temparr=list.split("~");
	var len=temparr.length;
	for(i=1;i<len;i+=5)
	{
	var tempstr="<tr>"+"<td>"+temparr[i]+"</td>"+"<td>"+temparr[i+1]+"</td>"+"<td>"+temparr[i+2]+"</td>"+"<td>"+temparr[i+3]+"</td>"+"<td>"+temparr[i+4]+"</td>"+"</tr>";
	$("#mytab").append(tempstr);
	}
	}

});
			

}
</script>
</html>