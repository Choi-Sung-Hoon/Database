<%@page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="model.model_Members"%>
<%@page import="model.model_Competition"%>
<%@page import="model.model_Internship"%>
<%@page import="model.model_Volunteer"%>
<%@page import="model.model_Rest"%>
<%@page import="model.model_MultipleMajor"%>
<%@page import="model.model_PassedCompany"%>
<%@page import="model.model_InterviewQuestion"%>
<%@page import="model.model_Took"%>
<%@page import="model.model_Participating"%>
<%@page import="model.model_Has"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>KNU Folio</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">KNU Folio</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="index.jsp">Home</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="about.jsp">About</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/controller_Portfolio">Portfolios</a>
					</li>
					<%
						boolean flag = false;

						if (!session.isNew()) {
							try {
								flag = (boolean) session.getAttribute("flag");
							} catch (Exception e) {
								session = null;
							}
						}

						if (flag) {
					%>
					<li class="nav-item">
						<a class="nav-link" href="<%=request.getContextPath()%>/controller_MyPage">${id}</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/controller_Logout">Logout</a>
					</li>
					<%
						} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
					</li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('img/about-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="page-heading">
						<h1>About KNU Folio</h1>
						<span class="subheading">See how the others built their careers.</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="fluid-container col-lg-8 col-md-10 mx-auto">
		<div class="panel-group accordian" id="accordian">
			<div class="panel panel-default">
					<div class="panel-body show">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Student Number</th>
									<th>Student Name</th>
									<th>Degree</th>
									<th>Major</th>
								</tr>
							</thead>
							<tbody>
							<%
								model_Members member = (model_Members)request.getAttribute("member");
							%>
								<tr>
									<td><%=member.getStudentName() %></td>
									<td><%=member.getStudentName() %></td>
									<td><%=member.getDegree() %>ÇÐ³â</td>
									<td><%=member.getMajorName() %></td>
								</tr>
							</tbody>
						</table>
					</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse2">Competition</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Competition Name</th>
									<th>Prize</th>
									<th>Competition Date</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Competition> list_Competition = (List<model_Competition>)request.getAttribute("list_Competition");
								
								for(model_Competition c : list_Competition)
								{
							%>
								<tr>
									<td><%=c.getCompetitionName() %></td>
									<td><%=c.getPrize() %></td>
									<td><%=c.getCompetitionDate() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse3">Internship</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Company Date</th>
									<th>Start Date</th>
									<th>End Date</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Internship> list_Internship = (List<model_Internship>)request.getAttribute("list_Internship");
								
								for(model_Internship i : list_Internship)
								{
							%>
								<tr>
									<td><%=i.getCompanyName() %></td>
									<td><%=i.getStartDate() %></td>
									<td><%=i.getEndDate() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>


			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse4">Volunteer</a>
					</h4>
				</div>
				<div id="collapse4" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Name</th>
									<th>Start Date</th>
									<th>End Date</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Volunteer> list_Volunteer = (List<model_Volunteer>)request.getAttribute("list_Volunteer");
								
								for(model_Volunteer v : list_Volunteer)
								{
							%>
								<tr>
									<td><%=v.getVolunteerName() %></td>
									<td><%=v.getStartDate() %></td>
									<td><%=v.getEndDate() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse5">Rest</a>
					</h4>
				</div>
				<div id="collapse5" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Start Date</th>
									<th>End Date</th>
								</tr>
							</thead>
							<tbody>
							<%
								model_Rest rest = (model_Rest)request.getAttribute("rest");
							
								if(rest != null)
								{
							%>
								<tr>
									<td><%=rest.getStartDate() %></td>
									<td><%=rest.getEndDate() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse6">Multiple Major</a>
					</h4>
				</div>
				<div id="collapse6" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Major Name</th>
								</tr>
							</thead>
							<tbody>
							<%
								model_MultipleMajor multipleMajor = (model_MultipleMajor)request.getAttribute("multipleMajor");
							
								if(multipleMajor != null)
								{
							%>
								<tr>
									<td><%=multipleMajor.getMajorName() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse7">Passed Company</a>
					</h4>
				</div>
				<div id="collapse7" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Company Name</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_PassedCompany> list_PassedCompany = (List<model_PassedCompany>)request.getAttribute("list_PassedCompany");
								
								for(model_PassedCompany p : list_PassedCompany)
								{
							%>
								<tr>
									<td><%=p.getCompanyName() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse8">Interview Questions</a>
					</h4>
				</div>
				<div id="collapse8" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Company Name</th>
									<th>Question</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_InterviewQuestion> list_InterviewQuestion = (List<model_InterviewQuestion>)request.getAttribute("list_InterviewQuestion");
								
								for(model_InterviewQuestion i : list_InterviewQuestion)
								{
							%>
								<tr>
									<td><%=i.getCompanyName() %></td>
									<td><%=i.getQuestion() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse9">Classes</a>
					</h4>
				</div>
				<div id="collapse9" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Class Code</th>
									<th>Class Name</th>
									<th>Grade</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Took> list_Took = (List<model_Took>)request.getAttribute("list_Took");
								
								for(model_Took t : list_Took)
								{
							%>
								<tr>
									<td><%=t.getCode() %></td>
									<td><%=t.getClassName() %></td>
									<td><%=t.getGrade() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse10">Clubs</a>
					</h4>
				</div>
				<div id="collapse10" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Club Name</th>
									<th>Start Date</th>
									<th>End Date</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Participating> list_Participating = (List<model_Participating>)request.getAttribute("list_Participating");
								
								for(model_Participating p : list_Participating)
								{
							%>
								<tr>
									<td><%=p.getClubName() %></td>
									<td><%=p.getStartDate() %></td>
									<td><%=p.getEndDate() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian"
							href="#collapse11">Licenses</a>
					</h4>
				</div>
				<div id="collapse11" class="panel-collapse collapse">
					<div class="panel-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>License Name</th>
									<th>Score</th>
								</tr>
							</thead>
							<tbody>
							<%
								@SuppressWarnings("unchecked")
								List<model_Has> list_Has = (List<model_Has>)request.getAttribute("list_Has");
								
								for(model_Has h : list_Has)
								{
							%>
								<tr>
									<td><%=h.getLicenseName() %></td>
									<td><%=h.getScore() %></td>
								</tr>
							<%
								}
							%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-twitter fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
						<li class="list-inline-item"><a href="#"> <span
								class="fa-stack fa-lg"> <i
									class="fas fa-circle fa-stack-2x"></i> <i
									class="fab fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; KNU Folio 2018</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Custom scripts for this template -->
	<script src="js/clean-blog.min.js"></script>

</body>

</html>
