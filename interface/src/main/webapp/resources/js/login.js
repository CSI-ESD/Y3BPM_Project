$(document).ready(function () {

    $(".alert").alert();
//    window.setTimeout(function () {
//        $(".alert").fadeTo(1500, 0).slideUp(500, function () {
//            $(this).remove();
//        });
//    }, 3000);
    if ($('#register-variable').val() === 'true') {
        $('#registerModal').modal('show');
    }


});