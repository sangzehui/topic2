function topicAlert2(parameters) {
    var result = parameters.result;
    var message = parameters.message;
    var success = parameters.success;
    var $parent = parameters.$parent;
    if ($parent == undefined) {
        $parent = $("body");
    }
    var div = '\
        <div class="modal" tabindex="-1" role="dialog">\
            <div class="modal-dialog">\
                <div class="alert alert-' + result + ' alert-dismissible">\
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>\
                    <h4><i class="icon fa fa-check"></i>提示!</h4>'
                    + message +
                '</div>\
            </div>\
        </div>';
    var $div = $(div);
    $parent.prepend($div);
    $div.modal();
    setTimeout(function () {
        $div.modal('hide');
        if (success != undefined)
            success();
    }, 1000);
}