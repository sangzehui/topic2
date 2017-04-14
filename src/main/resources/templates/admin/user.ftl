<#import "lib/component.ftl" as c>

<@c.baseHtml contentTitle="用户管理">
<div class="box">
	<!-- /.box-header -->
	<div class="box-body">
		<table class="table table-bordered">
			<thead>
			<tr>
				<th style="width: 10px">#</th>
				<th>用户名</th>
				<th>角色</th>
				<th>创建时间</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
                <#list users as user>
				<tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>
                        <#if user.roleId==1>
							超级管理员
                        <#elseif user.roleId==2>
							管理员
                        <#elseif user.roleId==3>
							普通用户
                        </#if>
						</select>
					</td>
					<td>${user.createTime}</td>
					<td>
						<button class="btn btn-sm btn-primary" onclick="showUserDetail(${user.id})">查看详情</button>
					</td>
				</tr>
                </#list>
			</tbody>
		</table>
	</div>
<#--<!-- /.box-body &ndash;&gt;-->
<#--<div class="box-footer clearfix">-->
<#--<ul class="pagination pagination-sm no-margin pull-right">-->
<#--<li><a href="#">«</a></li>-->
<#--<li><a href="#">2</a></li>-->
<#--<li><a href="#">»</a></li>-->
<#--</ul>-->
<#--</div>-->
</div>
<script>
	function showUserDetail(userId) {
		var url = "${basePath}/admin/rest/u/" + userId;
		$.get(url, {}, function (result) {
			var user = result.data.user;
			var modalId = "showUserDetail";
			var title = "用户详情";
			var body = '\
                <form id="userDetailForm">\
                	<input type="hidden" name="_method" value="put">\
                	<input type="hidden" name="id">\
                    <div class="form-group">\
                        <label class="" for="">用户名</label>\
                        <div class="col-md-10 pull-right">\
                            <input type="text" class="form-control" disabled name="username">\
                        </div>\
                    </div>\
                    <div class="form-group">\
                        <label class="" for="">角色</label>\
                        <div class="col-md-10 pull-right">\
						<select name="roleId" class="form-control">\
                            <option value="1">超级管理员</option>\
                            <option value="2">管理员</option>\
                            <option value="3">普通用户</option>\
                        </select>\
                        </div>\
                    </div>\
                </form>\
                ';
			var footer = '<button type="button" class="btn btn-primary" onclick="saveUser(' + user.id + ')">保存</button>';
			var $div = topicModal(modalId, title, body, footer);
			$div.modal();
			$("#userDetailForm [name='id']").val(user.id);
			$("#userDetailForm [name='username']").val(user.username);
			$("#userDetailForm [name='roleId']").val(user.roleId);
		});
	}
	function saveUser(userId) {
		var url = "${basePath}/admin/rest/u/" + userId;
		$.post(url, $("#userDetailForm").serialize(), function (result) {
			if (result.status == 0) {
				topicAlert({
					result: "success",
					message: '保存成功',
					$parent: $("#userDetailForm"),
					success: function () {
						location.reload();
					}
				});
			} else {
				topicAlert({result: "danger", message: result.message, $parent: $("#userDetailForm")});
			}
		});
	}
</script>
</@c.baseHtml>
