<%@page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.List"%>
<%@page import="model.model_Article"%>
<%@page import="dao.dao_Article"%>

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

						if (session != null && !session.isNew()) {
							try {
								flag = (boolean) session.getAttribute("flag");
							} catch (Exception e) {
								session = null;
							}
						}

						if (flag) {
					%>
					<li class="nav-item"><a class="nav-link" href="mypage.jsp">${id}</a>
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
		style="background-image: url('img/home-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Portfolio Management</h1>
						<span class="subheading">by KNU Folio</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<%
		if(flag)
		{
    %>
	<div class="fluid-container col-lg-8 col-md-10 mx-auto">
		<div class="panel-group arccordian" id="accordian">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse1">Members</a>
					</h4>
				</div>
				<div id="collapse1" class="panel-collapse collapse">
					<div class="panel-body">
						<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Members" method="post" novalidate>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>���� �׸�</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
										<tr>
											<td>password:</td>
											<td><input type="password" placeholder="��й�ȣ�� �Է��ϼ���." name="password" class="form-control" required></td>
										</tr>
										<tr>
											<td>student_number:</td>
											<td><input type="number" placeholder="�й��� �Է��ϼ���." name="studentNumber" class="form-control" required></td>
										</tr>
										<tr>
											<td>student_name:</td>
											<td><input type="text" placeholder="�̸��� �Է��ϼ���." name="studentName" class="form-control" required></td>
										</tr>
										<tr>
											<td>degree:</td>
											<td><input type="number" placeholder="�г��� �Է��ϼ���." name="degree" class="form-control" required></td>
										</tr>
										<tr>
											<td>major:</td>
											<td><input type="text" placeholder="������ �Է��ϼ���." name="majorName" class="form-control" required></td>
										</tr>
										<tr>
											<td colspan="2">
												<input type="submit" value="���" class="pull-right btn-success btn" />
												<input type="reset" value="reset" class="pull-left btn-success btn" />
												<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio">
											</td>
										</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse2">Competition</a>
					</h4>
				</div>
				<div id="collapse2" class="panel-collapse collapse">
					<div class="panel-body">
						<form role="form" id="competitionForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Competition" method="post" novalidate>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>���� �׸�</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Competition Name:</td>
										<td><input type="text" placeholder="��ȸ �̸��� �Է��ϼ���." name="competitionName" class="form-control" required></td>
									</tr>
									<tr>
										<td>Prize :</td>
										<td><input type="text" placeholder="���� ����� �Է��ϼ���." name="prize" class="form-control" required></td>
									</tr>
									<tr>
										<td>Competition Date:</td>
										<td><input type="date" placeholder="��ȸ ��¥�� �Է��ϼ���." name="competitionDate" class="form-control" required></td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="submit" value="���" class="pull-right btn-success btn" />
											<input type="reset" value="reset" class="pull-left btn-success btn" />
											<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse3">Internship</a>
					</h4>
				</div>
				<div id="collapse3" class="panel-collapse collapse">
					<div class="panel-body">
						<form role="form" id="internshipForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Internship" method="post" novalidate>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>���� �׸�</th>
										<th>����</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>Company Name :</td>
										<td><input type="text" placeholder="ȸ���̸��� �Է��ϼ���." name="company_name" class="form-control" reuiqred></td>
									</tr>
									<tr>
										<td>Start Date :</td>
										<td><input type="date" placeholder="���� ��¥�� �Է��ϼ���." name="start_date" class="form-control" required></td>
									</tr>
									<tr>
										<td>End Date :</td>
										<td><input type="date" placeholder="���� ��¥�� �Է��ϼ���." name="end_date" class="form-control" required></td>
									</tr>
									<tr>
										<td colspan="2">
											<input type="submit" value="���" class="pull-right btn-success btn" />
											<input type="reset" value="reset" class="pull-left btn-success btn" />
											<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
										</td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse4">Volunteer</a>
					</h4>
				</div>
				<div id="collapse4" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Volunteer" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���." 
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Volunteer Name :</td>
									<td><input type="text" placeholder="����Ȱ�� ���� �Է��ϼ���." name = "volunteer_name"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Start Date :</td>
									<td><input type="text" placeholder="���� ��¥�� �Է��ϼ���." name = "start_date"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>End Date :</td>
									<td><input type="text" placeholder="���� ��¥�� �Է��ϼ���." name = "end_date"
										class="form-control" /></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="���"  class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse5">Rest</a>
					</h4>
				</div>
				<div id="collapse5" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Rest" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Start Date :</td>
									<td><input type="text" placeholder="���� ��¥�� �Է��ϼ���." name = "start_date"
										class="start_date" /></td>
								</tr>
								<tr>
									<td>End Date :</td>
									<td><input type="text" placeholder="���� ��¥�� �Է��ϼ���." name = "end_date"
										class="form-control" /></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="���" class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse6">Multiple Major</a>
					</h4>
				</div>
				<div id="collapse6" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_MultipleMajor" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Major Name :</td>
									<td><input type="text" placeholder="������ �Է��ϼ���." name = "major_name"
										class="form-control" /></td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="submit" value="���" class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse7">Passed Company</a>
					</h4>
				</div>
				<div id="collapse7" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_PassedCompany" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. " 
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Company Name :</td>
									<td><input type="text" placeholder="ȸ���̸��� �Է��ϼ���." name = "company_name"
										class="form-control" /></td>
								</tr>

								<tr>
									<td colspan="2">
										<input type="submit" value="���"  class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse8">Interview Questions</a>
					</h4>
				</div>
				<div id="collapse8" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_InterviewQuestions" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Company Name :</td>
									<td><input type="text" placeholder="ȸ���̸��� �Է��ϼ���." name = "company_name"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Question :</td>
									<td><input type="text" placeholder="���� ������ �Է��ϼ���." name = "question"
										class="form-control" /></td>
								</tr>

								<tr>
									<td colspan="2">
										<input type="submit" value="���"  class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse9">Classes</a>
					</h4>
				</div>
				<div id="collapse10" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Classes" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Class Code :</td>
									<td><input type="text" placeholder="���� �ڵ带 �Է��ϼ���." name = "class_code"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Class Name :</td>
									<td><input type="text" placeholder="���� �̸��� �Է��ϼ���." name = "class_name"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Grade :</td>
									<td><input type="text" placeholder="������ �Է��ϼ���." name = "grade"
										class="form-control" /></td>
								</tr>

								<tr>
									<td colspan="2">
										<input type="submit" value="���"  class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse11">Clubs</a>
					</h4>
				</div>
				<div id="collapse12" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Clubs" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>Club Name :</td>
									<td><input type="text" placeholder="���Ƹ� �̸��� �Է��ϼ���." name = "club_name"
										class="form-control" /></td>
								</tr>

								<tr>
									<td colspan="2">
										<input type="submit" value="���" class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>

							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>

			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 class="panel-title">
						<a data-toggle="collapse" data-parent="#accordian" href="#collapse12">Licenses</a>
					</h4>
				</div>
				<div id="collapse14" class="panel-collapse collapse">
					<div class="panel-body">
					<form role="form" id="MembersForm" class="needs-validation" action="<%=request.getContextPath()%>/controller_Licenses" method="post" novalidate>
						<table class="table table-hover">
							<thead>
								<tr>
									<th>���� �׸�</th>
									<th>����</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Student Number :</td>
									<td><input type="text" placeholder="�й��� �Է��ϼ���. "
										name="student_number" class="form-control" /></td>
								</tr>
								<tr>
									<td>License Name :</td>
									<td><input type="text" placeholder="�ڰ��� �̸��� �Է��ϼ���." name = "license_name"
										class="form-control" /></td>
								</tr>
								<tr>
									<td>Score :</td>
									<td><input type="text" placeholder="������ �Է��ϼ���." name = "score"
										class="form-control" /></td>
								</tr>

								<tr>
									<td colspan="2">
										<input type="submit" value="���"  class="pull-right btn-success btn" />
										<input type="reset" value="reset" class="pull-left btn-success btn" />
										<input type="button" value="�� �������... " class="pull-right btn-light btn" onclick="<%=request.getContextPath()%>/controller_Portfolio" />
									</td>
								</tr>
							</tbody>
						</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    <%
    	}
    %>


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

	<!-- validation script for registration -->
    <script src="js/registrationValidation.js"></script>
</body>

</html>
