<#macro baseHtml contentTitle desc="">
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Topic2控制台</title>

	<link href="${basePath}/module/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="${basePath}/module/AdminLTE/css/AdminLTE.min.css" rel="stylesheet">
	<link href="${basePath}/module/AdminLTE/css/skins/_all-skins.min.css" rel="stylesheet">
	<link href="${basePath}/module/bootstrap-treeview/bootstrap-treeview.min.css" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

	<script src="${basePath}/module/jquery/jquery-2.2.3.min.js"></script>
	<script src="${basePath}/module/jquery.cookie/jquery.cookie.js"></script>
	<script src="${basePath}/module/bootstrap/js/bootstrap.min.js"></script>
	<script src="${basePath}/module/bootstrap-treeview/bootstrap-treeview.min.js"></script>
	<script src="${basePath}/module/AdminLTE/js/app.js"></script>

	<script src="${basePath}/module/topic/js/topic.js"></script>
	<script src="${basePath}/module/topic/js/topic-admin.js"></script>
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

<#macro BSinput label name type="text" id="" attr="">
<div class="form-group">
	<label for="${id}" class="col-md-3 control-label">${label}</label>
	<div class="col-md-8">
		<input type="${type}" class="form-control" id="${id}" name="${name}" ${attr}>
	</div>
</div>
</#macro>

<#macro BScheckbox name text value="">
<div class="checkbox">
	<label>
		<input name="${name}" type="checkbox" value="${value}" >
		${text}
	</label>
</div>
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
				<li class="dropdown">
					<a href="${basePath}/" target="_blank">首页</a>
				</li>
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
				<a href="${basePath}/admin/">
					<i class="fa fa-link"></i>
					<span>仪表板</span>
				</a>
			</li>
			<li>
				<a href="${basePath}/admin/u">
					<i class="fa fa-link"></i>
					<span>用户管理</span>
				</a>
			</li>
			<li>
				<a href="${basePath}/admin/t">
					<i class="fa fa-link"></i>
					<span>目录管理</span>
				</a>
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