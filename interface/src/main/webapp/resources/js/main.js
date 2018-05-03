$(document).ready(function () {
    //$(".alex-main-container").hide();
    //  $(".alex-main-container").slideLeft('slow');

    $(".alex-transition-left")
            .animate(
                    {
                        'margin-left': '100px'
                    }, 1000,
                    function () {
                    }
            );

    $(".alert").alert();
    $.notify.defaults({globalPosition: 'bottom left'});
    window.setTimeout(function () {
        $(".alert").fadeTo(1500, 0).slideUp(500, function () {
            $(this).remove();
        });
    }, 3000);
});

var address = "ws://192.168.0.36:9999/"
var s;

var disconnectFromWS = function () {
    s.close(1000, "Try to Close");
}

var connectToWS = function () {
    try {
        s = new WebSocket(address);
        s.onopen = function (e) {
            $.notify("WebSocket open", "success");
        };
        s.onclose = function (e) {
            $.notify("WebSocket closed", "warning");
        };
        s.onmessage = function (e) {
            console.log(e.data);
            if (e.data.startsWith("temp1:")) {
                var number = parseFloat(e.data.split(':')[1]);
                babylonScene.setTemperature(number);
            }
//            $("#templog > li").removeClass("hightlight");
//            $("#templog").prepend('<li class="list-group-item hightlight"></li>');
//            $("#templog > li").first()
//                    .hide()
//                    .text(e.data + ' @ ' + (new Date()).toLocaleTimeString())
//                    .slideDown("slow");
        };
        s.onerror = function (e) {
            $.notify("Exception, please check console", "error");
            console.log(e);
        };
    } catch (ex) {
        $.notify("Exception, please check console", "error");
        console.log(ex);
    }
}

