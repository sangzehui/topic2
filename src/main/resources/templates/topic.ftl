<#import "lib/component.ftl" as c>

<@c.baseHtml>
<style>
	.list-title * {
		color: #555555;
		font-size: 18px;
	}
	.bg {
		background: #ccc;
	}
    .bg2{
        background: #ddd;
        border-radius: 0.4rem;
    }
	#content {
		padding-top: 2rem;
        width: 70%;
	}
</style>
<div class="bg">
	<div class="container">
		<div id="content">
            <div class="bg2"><@c.BSnav2 navs=nav2 topicId=topicId/></div>
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
	</div>
</div>
</@c.baseHtml>