

var viewmodel = avalon.define({
    $id:"ajaxTestController",
    datalist:{},
    text:"请求数据",
    request:function () {
        $.ajax({
            type:"post",
            url:"trace/data",
            data:{},
            success:function (data) {
                $('button').removeClass("btn-danger").addClass("btn-success").attr('disable',true);
                viewmodel.datalist = data;
                viewmodel.text="successful";
            }
        })

    }
})