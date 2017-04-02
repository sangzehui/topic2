<#macro baseHtml contentTitle desc="">
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Topic2控制台</title>

	<link href="${basePath}/module/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${basePath}/module/AdminLTE/css/AdminLTE.min.css" rel="stylesheet">
	<link href="${basePath}/module/AdminLTE/css/skins/skin-blue.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

	<script src="${basePath}/module/jquery/jquery-2.2.3.min.js"></script>
	<script src="${basePath}/module/jquery.cookie/jquery.cookie.js"></script>
	<script src="${basePath}/module/bootstrap/js/bootstrap.min.js"></script>

	<script src="${basePath}/module/AdminLTE/js/app.js"></script>
</head>

<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <@adminHeader/>
    <@adminSidebar/>
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
                ${contentTitle}
				<small>${desc}</small>
			</h1>
		</section>
		<!-- Main content -->
		<section class="content">
            <#nested>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
    <@adminFooter/>
</div>

<script>
</script>

</body>
</html>
</#macro>

<#macro adminHeader>
<header class="main-header">
	<a href="#" class="logo">
		<span class="logo-mini"><b>T</b>2</span>
		<!-- logo for regular state and mobile devices -->
		<span class="logo-lg"><b>Topic</b>2</span>
	</a>

	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
			<span class="sr-only">Toggle navigation</span>
		</a>
		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button -->
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<!-- The user image in the navbar-->
						<img src="${basePath}/module/AdminLTE/img/avatar5.png" class="user-image"
						     alt="User Image">
						<!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">Admin</span>
					</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header">
							<img src="${basePath}/module/AdminLTE/img/avatar5.png" class="img-circle"
							     alt="User Image">
							<p>
                                Admin
							</p>
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="#" class="btn btn-default btn-flat">个人信息</a>
							</div>
							<div class="pull-right">
								<a href="#" class="btn btn-default btn-flat">注销</a>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	</nav>
</header>
</#macro>

<#macro adminSidebar>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="active">
				<a href="#">
					<i class="fa fa-link"></i>
					<span>仪表板</span>
				</a>
			</li>
			<li class="treeview">
				<a href="#"><i class="fa fa-link"></i> <span>话题管理</span>
					<span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
				</a>
				<ul class="treeview-menu">
					<li><a href="#">Link in level 2</a></li>
					<li><a href="#">Link in level 2</a></li>
				</ul>
			</li>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>
</#macro>

<#macro adminFooter>
<footer class="main-footer">
	<div class="pull-right hidden-xs">
	</div>
	<strong>sggzh &copy; 2016 <a href="https://github.com/sggzh/topic2">Github</a></strong>.
</footer>
</#macro>