$(document).ready(function () {
    $('#users-table').DataTable({
        ajax: "getAllUsers",
        dataSrc: '',
        columns: [
            {"data": "firstName"},
            {"data": "lastName"},
            {"data": "username"},
            {"data": "password"},
            {"data": "email"},
            {"data": "enabled"},
            {"data": "authorities[,].name"}
        ],
        language: {
            "loadingRecords": "&nbsp;",
            "processing": "Loading..."
        },
        sAjaxDataProp: "",
        paging: false,
        searching: false,
        info: false
    });
});

