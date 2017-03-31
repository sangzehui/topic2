<#import "lib/component.ftl" as c>

<@c.baseHtml title="用户注册">
<style>
	.wrapper {
		margin-top: 1rem;
		padding: 2rem 1rem;
	}
</style>
<div class="container">
	<div class="wrapper">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-4 col-md-offset-4">
					<div class="text-center">
						<h1>用户注册</h1>
					</div>
					<form id="mainForm">
                        <@c.BSinput name="username" label="用户名" />
                        <@c.BSinput name="pasword" type="password" label="密码" />
						<button class="btn btn-default pull-right" type="button" onclick="register()">注册</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	function register() {
		var url = "${basePath}/rest/register";
		$.post(url, $("#mainForm").serialize(), function (result) {
			if (result.status == 0) {
				topicAlert({
					result: "success", message: "注册成功", success: function () {
						window.location.href = "${basePath}/";
					}
				});
			} else {
				topicAlert({result: "danger", message: result.message});
			}
		});
	}
</script>
</@c.baseHtml>
