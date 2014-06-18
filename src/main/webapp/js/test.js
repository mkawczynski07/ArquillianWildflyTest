(function() {

    $(document).ready(function() {
        $.getJSON("rest/test/ping", function(data) {
            if (data.success === true) {
                $('#ping').append('<span id="pong"> ...pong</span>');
            }
        });
    });

})();