<#import "lib/component.ftl" as c>

<@c.baseHtml>
<style>
	#main {
		padding-top: 2rem;
		width: 70%;
		padding-bottom: 2rem;
	}
</style>
<div class="container">
	<div id="main">
		<div>
			<@c.BSnav3 navs=parentTopic/>
		</div>
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
			<div class="panel-footer" style="padding: 0.1rem 1rem;">
				<div style="text-align: right">
                    <#if Session.sessionUser??>
						<button type="button" class="btn btn-default btn-sm" onclick="topicComment(${postId})">评论
						</button>
                    </#if>
				</div>

			</div>
		</div>
		<ul class="list-group">
            <#list comments as comment>
				<li class="list-group-item">
					#${comment.floor} - <a href="${basePath}/u/${comment.userId}">${comment.username}</a>:
					发表时间：${comment.createTime}
					<div class="pre">${comment.content}</div>
				</li>
            </#list>
		</ul>
        <@c.BSpage url=url page=page />
	</div>
</div>
</@c.baseHtml>