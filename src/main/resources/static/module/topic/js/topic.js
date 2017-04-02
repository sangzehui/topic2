function logout() {
    var url = basePath + "/rest/logout";
    $.post(url, {}, function (result) {
        if (result.status == 0) {
            topicAlert({
                result: "success", message: "注销成功", success: function () {
                    location.reload();
                }
            });
        }
    });
}
/**
 * 提示信息框,添加在#main之前
 */
function topicAlert(parameters) {
    var result = parameters.result;
    var message = parameters.message;
    var success = parameters.success;
    var $parent = parameters.$parent;
    if ($parent == undefined) {
        $parent = $("#header");
    }
    var div = '\
        <div class="alert alert-' + result + '" role="alert" style="margin-bottom: 0">\
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">\
                <span aria-hidden="true">&times;</span>\
            </button>\
            <div class="container">\
                ' + message + '\
            </div>\
        </div>';
    var $div = $(div);
    $parent.append($div);
    setTimeout(function () {
        $div.fadeToggle({
            complete: function () {
                if (success != undefined)
                    success();
            }
        });
    }, 1000);
}

/**
 * 返回模态窗口，一个id只构建一次
 * @param modalId
 * @param title
 * @param body
 * @param footer
 * @returns {*|jQuery|HTMLElement}
 */
function topicModal(modalId, title, body, footer) {
    var $modal = $("#" + modalId);
    if ($modal.length > 0) {
        return $modal;
    }
    var div = '\
        <div class="modal fade" id="' + modalId + '" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">\
            <div class="modal-dialog">\
                <div class="modal-content">\
                    <div class="modal-header">\
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>\
                        <h4 class="modal-title">' + title + '</h4>\
                    </div>\
                    <div class="modal-body">\
                    ' + body + '\
                    </div>\
                    <div class="modal-footer">\
                        <button type="button" class="btn btn-default pull-left" data-dismiss="modal">关闭</button>\
                        ' + footer + '\
                    </div>\
                </div>\
            </div>\
        </div>\
        ';
    var $div = $(div);
    $("body").append($div);
    return $div;
}

/**
 * 发表话题
 * @param topicId
 */
function topicPost(topicId) {
    var modalId = "postModal";
    var title = "发表新文章";
    var body = '\
        <form id="postForm">\
            <input type="hidden" name="topicId" value="' + topicId + '">\
            <div class="form-group">\
                <label for="">标题</label>\
                <input type="text" class="form-control" name="title">\
            </div>\
            <div class="form-group">\
                <label for="">内容</label>\
                <textarea name="content" class="form-control" rows="5"></textarea>\
            </div>\
        </form>\
        ';
    var footer = '<button type="button" class="btn btn-primary" onclick="doTopicPost()">发表</button>';
    var $modal = topicModal(modalId, title, body, footer);
    $modal.modal();
}

function doTopicPost() {
    var url = basePath + "/rest/p";
    $.post(url, $("#postForm").serialize(), function (result) {
        if (result.status == 0) {
            topicAlert({
                result: "success",
                message: "发表成功",
                $parent: $("#postModal .modal-body"),
                success: function () {
                    window.location.href = basePath + "/p/" + result.data.post.id;
                }
            });
        } else {
            topicAlert({
                result: "danger",
                message: result.message,
                $parent: $("#postModal .modal-body")
            });
        }
    });
}

/**
 * 评论话题
 */
function topicComment(postId) {
    var modalId = "commentModal";
    var title = "评论";
    var body = '\
        <form id="commentForm">\
            <input type="hidden" name="postId" value="' + postId + '">\
            <div class="form-group">\
                <label for="">内容</label>\
                <textarea name="content" class="form-control" rows="5"></textarea>\
            </div>\
        </form>\
        ';
    var footer = '<button type="button" class="btn btn-primary" onclick="doTopicComment()">发表</button>';
    var $modal = topicModal(modalId, title, body, footer);
    $modal.modal();
}

function doTopicComment() {
    var url = basePath + "/rest/c";
    $.post(url, $("#commentForm").serialize(), function (result) {
        if (result.status == 0) {
            topicAlert({
                result: "success",
                message: "发表成功",
                $parent: $("#commentModal .modal-body"),
                success: function () {
                    location.reload();
                }
            });
        } else {
            topicAlert({
                result: "danger",
                message: result.message,
                $parent: $("#commentModal .modal-body")
            });
        }
    });
}
