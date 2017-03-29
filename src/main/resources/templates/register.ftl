<#import "lib/component.ftl" as c>

<@c.baseHtml title="用户注册">
<div class="container">
	<div class="panel panel-default">
        <div class="panel-body">
	        <div class="col-md-4 col-md-offset-4">
                <div class="text-center">
	                <h1>用户注册</h1>
                </div>
		        <form id="">
                    <@c.BSinput name="username" label="用户名" />
                    <@c.BSinput name="pasword" type="password" label="密码" />
                    <button class="btn btn-default pull-right" type="button">注册</button>
		        </form>
	        </div>
        </div>
	</div>
</div>
</@c.baseHtml>
