function on_pretty_clicked() {
    var text_area = $("textarea");
    var code = $("code");
    var content = text_area.val(); // this is val

    // copy the value
    // this needs to get it from the web service
    code.text(content); // but this is text, why?

    var on_pretty_printed = function() {

    };
    $.post('/upload', content, on_pretty_printed);


    hljs.highlightBlock( code.get(0) ); // get(0) access the raw dom object form the jquery object
    code.show();
    text_area.hide();
}

$("button[name='pretty']").on('click', on_pretty_clicked );

