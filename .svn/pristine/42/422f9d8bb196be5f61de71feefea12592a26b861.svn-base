<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title> In-principle Leasing Permission to be issued</title>
<style type="text/css">	
body {font-family:trebuchet ms; font-size:10.5pt;}
.printReceipt {font-family:trebuchet ms; font-size:10.5pt; padding:10px; width:750px; margin:0 auto; line-height:22px; height:auto; padding-bottom:25px;}
.printData {margin-bottom:20px; margin-top:20px;}
.printData th{padding:4px; border:1px #ccc solid; border-collapse:separate; }
.printData td{padding:4px; border:1px #ccc solid; }
.printReceipt .title {text-align:center;}
.printReceipt .title strong {text-align:center; font-size:15px; line-height:20px;}
.printReceipt p {margin-bottom:20px; text-align:justify;}
.printReceipt .subject {text-align:left;}
.printReceipt .mainsub {text-align:center; font-size:15px; text-decoration:underline; margin-top:30px;}
.printReceipt .content {text-align:justify; font-size:13px;}
.printReceipt h2, h3{text-align:center; margin-bottom:20px; font-size:16px; font-weight:bold; margin:0;}
.printReceipt a{color:#000; text-decoration:underline;}
P.breakhere {page-break-before: always}
.romanbullet {margin:10px 10px 20px 24px; padding:0;}
.romanbullet li {list-style:lower-roman outside; margin-bottom:15px; line-height:22px; text-align:justify;}
.alphabullet {margin:10px 10px 20px 24px; padding:0;}
.alphabullet li {list-style:lower-alpha outside; margin-bottom:15px; line-height:22px; text-align:justify;}
.discBullet {margin:10px 10px 20px 24px; padding:0;}
.discBullet li{list-style:disc outside; margin-bottom:15px; line-height:22px; text-align:justify;}
.topMargin {margin-top:50px;}
ol {margin:0 0 0 24px; padding:0;}
ol li{margin-bottom: 0.4in; text-align:justify; line-height:22px; }
 @media screen {
        div.divFooter {
            display:none;
			        }
			        tfoot { display: none; }
    }
     
    @media print {
   	@page {margin:1in 1in 0.8in 1.5in;}
	.printReceipt {width:100% !important; padding:0; margin:0;} 
        div.divFooter {
			display:block;
            position: fixed;
            bottom:0px;
			border-top:3px solid #9C9; width:100%;
			overflow:visible;
    width: 100%;
    height:auto;
        }
        	
#print-foot {
  display: block;
  position: fixed;
  bottom: 0px;;
  right:0px;
  font-size: 12px;
  float:right;
   width:150px;
   text-align:right;
  }

#print-foot:after {
 content: counter(page);
  counter-increment:page;
  }
   tfoot { display:table-footer-group; height:25px; visibility:hidden;}
   #printBut{display:none;}
   
    }
	
.clear {clear:both;}
.rightText {float:left; width:30%; font-size:12px; font-family:Arial, Helvetica, sans-serif; clear:both;}


.date {width:40%; text-align:center; float:left;}
table thead {display: table-header-group;}
table tbody { display: table-row-group;}


table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}

</style>
<script>

function print1(){	
	document.getElementById("printBut").style.display='none';
	window.print();
	document.getElementById("printBut").style.display='block';
}
</script>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
</head>

<body>
<div class="printReceipt">
<br />
<p class="title"><strong>HARYANA STAFF SELECTION COMMISSION</strong>
<br/>
<br /><span style="text-decoration:underline;">Panchkula</span></p>
<br/>
<p style="padding-left:15px">
<strong >Name of the Post:-</strong> ${examObj.nameOfPost}<br/>
<strong>Advt. No.:-</strong> ${examObj.advtNo} <br/>
<strong>Cat. No.:-</strong> ${examObj.catNo}<br/>
<strong>Date of Examination :- </strong><fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${examObj.examDate}"/><br/>
<strong>Time:- </strong> ${examObj.examTime}<br/>
</p>
<br />
<table style="width:95%;margin:0px 10px 0px 15px">
   <thead>
      <tr>
      <th>CR. No.</th>
      <th>Centre Name</th>
      <th>Name & Designation </th>
      <th>Department</th>
      <th>Session</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach items="${examObj.allcationList}" var="tag" varStatus="loop">
     <tr>
      <td>${loop.index+1}</td>
      <td>${tag.allotedExamCenterName}</td>
      <td>${tag.invigilatorName}</td>
      <td></td>
      <td></td>
     </tr>
     </c:forEach>
   </tbody>
</table>
<br />
<br />
<p style="float:right;padding-right:15px">Under Secretary Examination,<br />
for secretary , Haryana Staff selection Commission,  <br />
<strong>Panchkula</strong><br />
</p>
</div>
</body></html>