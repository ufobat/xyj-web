function on_pretty_clicked() {
    var text_area = $("textarea");
    var code      = $("code");

    $.ajax({
        type:        'POST',
        url:         '/upload',
        data:        JSON.stringify( {"content": text_area.val()} ), // text_area.val() but later... .text?
        dataType:    'json',
        contentType: "application/json; charset=utf-8",
        success:     function(data) {
            // console.log("done " + data.content);
            code.text(data.content); // but this is text, why?
            code.show();
            hljs.highlightBlock( code.get(0) ); // get(0) access the raw dom object form the jquery object
            text_area.hide();
        }
    });
}

$("button[name='pretty']").on('click', on_pretty_clicked );

