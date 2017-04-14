<#macro baseHtml title="topic2">
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${title}</title>

	<link href="${basePath}/module/bootstrap/css/bootstrap.min.css" rel="stylesheet">

	<script>
		var basePath = "${basePath}";
	</script>
	<script src="${basePath}/module/jquery/jquery-1.12.3.min.js"></script>
	<script src="${basePath}/module/jquery.cookie/jquery.cookie.js"></script>
	<script src="${basePath}/module/bootstrap/js/bootstrap.min.js"></script>
	<script src="${basePath}/module/topic/js/topic.js"></script>
	<style>
		#content {
			background: #ccc;
		}
	</style>
</head>
<body>
<div>
	<div id="header">
        <@BSnav navs=topNav/>
	</div>
	<div id="content">
        <#nested>
	</div>
	<div id="footer">
		<div class="container">
			<h4><span><a href="https://github.com/sggzh/topic2">GitHub</a></span></h4>
		</div>
	</div>
</div>
</body>
</html>
</#macro>

<#-- 带标签的input,label:显示内容 name:name -->
<#macro BSinput label name type="text" id="">
<div class="form-group">
	<label for="${id}">${label}</label>
	<input type="${type}" class="form-control" id="${id}" name="${name}">
</div>
</#macro>

<#-- 一级导航,navs:Topic列表,topicId:topicId -->
<#macro BSnav navs>
<nav class="navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${basePath}/">Topic2</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
                <#list navs as nav>
					<li class=""><a href="${basePath}/t/${nav.id}">${nav.name}</a></li>
                </#list>
			</ul>
			<ul class="nav navbar-nav navbar-right">
                <#if Session.sessionUser??>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
						   aria-expanded="false">
                        ${Session.sessionUser.username}
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${basePath}/u/${Session.sessionUser.id}">个人信息</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="javascript:;" onclick="logout()">注销</a></li>
						</ul>
					</li>
                <#else>
					<li><a href="${basePath}/login">登录</a></li>
					<li><a href="${basePath}/register">注册</a></li>
                </#if>
			</ul>
		</div>
	</div>
</nav>
</#macro>

<#-- 二级导航,navs:Topic列表,topicId:topicId -->
<#macro BSnav2 navs topicId=0>
<ul class="nav nav-pills">
    <#list navs as nav>
        <#if nav?index gte 6><#break></#if>
		<li role="presentation" <#if nav.id == topicId>class="active"</#if>>
			<a href="${basePath}/t/${nav.id}">${nav.name}</a>
		</li>
    </#list>
</ul>
</#macro>

<#-- 路径导航 -->
<#macro BSnav3 navs>
<ol class="breadcrumb" style="margin: 0; padding: 0.5rem 1rem">
    <#list navs as nav>
		<li><a href="${basePath}/t/${nav.id}">${nav.name}</a></li>
    </#list>
</ol>
</#macro>

<#-- 页码,url:无参路径,page:分页模型 -->
<#macro BSpage url page>
<ul class="pagination">
	<li>
		<a href="${url}?page=${page.prePage}" aria-label="Previous">
			<span aria-hidden="true">&laquo;</span>
		</a>
	</li>
    <#list page.startPage..<page.page as p >
		<li>
			<a class="active" href="${url}?page=${p}">${p}</a>
		</li>
    </#list>
    <#list page.page..page.endPage as p >
		<li <#if page.page == p>class="active"</#if>>
			<a href="${url}?page=${p}">${p}</a>
		</li>
    </#list>
	<li>
		<a href="${url}?page=${page.nextPage}" aria-label="Next">
			<span aria-hidden="true">&raquo;</span>
		</a>
	</li>
</ul>
</#macro>

