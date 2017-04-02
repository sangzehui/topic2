<#import "../lib/component.ftl" as c>

<@c.baseHtml>
<style>
	.list-title a {
		color: #555555;
		font-size: 18px;
	}

	.nav2-bg {
		background: #ddd;
		border-radius: 0.4rem;
	}

	.wrapper {
		padding: 2rem 1rem;
		float: left;
	}

	.column {
		padding: 3rem 0;
		background: #fff;
	}
</style>
<div class="container">
	<div id="main" class="wrapper col-md-9">
		<div class="nav2-bg"><@c.BSnav2 navs=nav2 topicId=topicId/></div>
		<div class="list-group">
            <#list posts as post>
				<li class="list-group-item">
					<div class="list-title">
						<a href="${basePath}/p/${post.id}">${post.title}</a>
					</div>
					<div class="pull-right"><span class="badge">${post.commentNumber}</span></div>
					<div class="post-bottom">
						作者：<a href="/u/${post.userId}">${post.username}</a>
						创建时间：${post.createTime}
						最后回复时间：${post.updateTime}
					</div>
				</li>
            </#list>
		</div>
		<div><@c.BSpage page=page url=url/></div>
	</div>
	<div class="wrapper col-md-3">
        <#if Session.sessionUser?? && topicId??>
			<div class="column">
				<div class="text-center">
					<button type="button" class="btn btn-default" onclick="topicPost(${topicId})">发表新话题</button>
				</div>
			</div>
        </#if>
	</div>
</div>
</@c.baseHtml>