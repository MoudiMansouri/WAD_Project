/**
 * Created by Moudi on 4/20/2017.
 */


$(document).ready(function() {
    $(".answer").click(function(event) {
        var answer = event.target.id;
        document.getElementById("answer_id").value = answer;
        var number = parseInt($("#number").attr('class'));
        var index = $("#number").attr('class');
        index++;
        alert(index);
        $.ajax({
            type: "get",
            url : "AnswerController",
            data : {
                option: answer,
                num : index
            },
            success: function (response) {
                alert("Score is : " + JSON.parse(response));
                wavesurfer.destroy();
                $("#score").removeClass("hidden").addClass("shown");
                $("#score").text("You scored " + response + " out of 10");
            }
        });
        $("#answers_furm".concat(number)).addClass('hidden').removeClass("show");
        number += 1;
        $("#number").removeClass().addClass(""+number+"");
        $("#song").removeClass().addClass(songsArray[number]);
        wavesurfer.load(song.attr('class'));
        $("#answers_furm".concat(number)).addClass('shown').removeClass("hidden");

    });
});

