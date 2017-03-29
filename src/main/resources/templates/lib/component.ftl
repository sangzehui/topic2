<#macro baseHtml title="topic2">
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>${title}</title>
	<link rel="stylesheet" href="${basePath}/module/bootstrap/css/bootstrap.min.css">
	<srcipt src="${basePath}/module/jquery/jquery-1.9.1/jquery.min.js"></srcipt>
	<srcipt src="${basePath}/module/bootstrap/js/bootstrap.min.js"></srcipt>
	<srcipt src="${basePath}/module/vue/vue.min.js"></srcipt>
	<style>
	</style>
</head>
<body>
<div>
	<div id="header">
        <@BSnav navs=topNav/>
	</div>
	<div id="main">
        <#nested>
	</div>
	<div id="footer">
		<div class="container">
			<a href="https://github.com/sggzh/topic2"><h4>GitHub</h4></a>
		</div>
	</div>
</div>
</body>
</html>
</#macro>

<#-- 带标签的input,label:显示内容 name:name -->
<#macro BSinput label name type="text">
<div class="form-group">
	<label>${label}</label>
	<input type="${type}" class="form-control" name="${name}" id="" placeholder="">
</div>
</#macro>

<#-- 一级导航,navs:Topic列表,topicId:topicId -->
<#macro BSnav navs>
<nav class="navbar-default">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${basePath}/">Topic2</a>
		</div>
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
                <#list topNav as nav>
					<li class=""><a href="${basePath}/t/${nav.id}">${nav.name}</a></li>
                </#list>
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