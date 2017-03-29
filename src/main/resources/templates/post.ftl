<#import "lib/component.ftl" as c>

<@c.baseHtml>
<style>
	.bg {
		background: #ccc;
	}

	#content {
		padding-top: 2rem;
		width: 70%;
		padding-bottom: 2rem;
	}
</style>
<div class="bg">
	<div class="container">
		<div id="content">
			<div class="panel panel-default">
				<div class="panel-heading">
					<span>${post.title}</span>
                    <span class="navbar-right">
                        创建时间：${post.createTime}
                        来自: <a href="${basePath}/u/${post.userId}">${post.username}</a>
                    </span>
				</div>
				<div class="panel-body">
                    <div class="pre">${post.content}</div>
				</div>
			</div>
			<ul class="list-group">
                <#list comments as comment>
					<li class="list-group-item">
						<a href="${basePath}/u/${comment.userId}">${comment.username}</a>:
						发表时间：${comment.createTime}
						<div class="pre">${comment.content}</div>
					</li>
                </#list>
			</ul>
		</div>
	</div>
</div>
</@c.baseHtml>