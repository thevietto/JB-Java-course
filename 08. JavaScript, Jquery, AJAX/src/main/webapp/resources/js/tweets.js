$(document).ready(function () {
    if('${isAuthorizeAny}' == false){
        return
    }

    updateTweets();

    $("#js-sendtweet").on("click", function () {
        sendTweet();
    });

});

function updateTweets() {
    $.ajax({
        url: "/tweets/all",
        type: "POST",
        data: {},
        dataType: "html",
        success: function (data) {
            $("#js-tweets").html(data);
        }
    });
}

function sendTweet() {
    $input = $("#js-tweet-text");
    var text = $input.val();
    if (text.length <= 0) {
        return
    }
    $.ajax({
        url: "/tweets/add",
        type: "POST",
        data: {
            text: text,
            user: 117
        },
        success: function () {
            updateTweets();
        }
    });
}