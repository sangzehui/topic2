<#import "../lib/component.ftl" as c>

<@c.baseHtml title="用户登录">
<style>
	.wrapper {
        margin-top: 1rem;
		padding: 2rem 1rem;
	}
</style>
<div class="container">
	<div id="main" class="wrapper">
		<div class="panel panel-default">
			<div class="panel-body">
				<div class="col-md-4 col-md-offset-4">
					<div class="text-center">
						<h1>用户登录</h1>
					</div>
					<form id="mainForm">
                        <@c.BSinput name="username" label="用户名" />
                        <@c.BSinput name="password" type="password" label="密码" />
						<div class="checkbox">
							<label><input type="checkbox" name="rememberPassword">记住密码</label>
						</div>
						<button class="btn btn-default pull-right" type="button" onclick="login()">登录</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
	$(function () {
		var rem = $.cookie("rememberPassword");
		if (rem != undefined) {
			$("input[name='username']").val($.cookie("username"));
			$("input[name='password']").val($.cookie("password"));
			$("input[name='rememberPassword']").attr("checked", "checked");
		}
	});
	function login() {
		var u = "${basePath}/rest/login";
		$.post(u, $("#mainForm").serialize(), function (result) {
			if (result.status == 0) {
				topicAlert({result: "success", message: "登录成功", success: successLogin});
			} else {
				topicAlert({result: "danger", message: result.message});
			}
		});
	}
	function successLogin() {
		$.removeCookie("username");
		$.removeCookie("password");
		if ($("input[name='rememberPassword']").is(":checked")) {
			$.cookie("rememberPassword", true);
			$.cookie("username", $("input[name='username']").val(), {expires: 30});
			$.cookie("password", $("input[name='password']").val(), {expires: 30});
		} else {
			$.removeCookie("rememberPassword");
		}
		window.location.href = "${basePath}/";
	}
</script>
</@c.baseHtml>
