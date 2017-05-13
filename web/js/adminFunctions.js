/**
 * Created by Moudi on 5/9/2017.
 */
function addArtist() {
    alert("hello");
    $("#artist-adder").submit(function (event) {
        alert("Hello");
        var artistName = $("#artist-name").val();
        $.ajax({
            type : "POST",
            url : "AddArtistController",
            data : {
                artistName : artistName
            },
            success: function (response) {
                if(response==="Invalid"){
                    alert("Invalid");
                }else{
                    alert("Valid");
                }
            }
        });
        alert("Sent");
        event.preventDefault();
    })
}

function addSong() {
    $("#song-adder").submit(function (event) {
        var errors = "";
        var $checkedElement = $('input[name=option]:checked');

        if($("#file-name").val() == ''){
            errors += "No file selected </br>";
        }

        if (! $checkedElement.length) {
            errors += "No correct answer was selected </br>";
        }

        if($("#var-answer-one").val() == ''){
            errors += "Answer one was left empty</br>";
        }
        if($("#var-answer-two").val() == ''){
            errors += " Answer two was left empty</br>";
        }
        if($("#var-answer-three").val() == ''){
            errors += " Answer three was left empty</br>";
        }

        if($("#var-answer-four").val() == ''){
            errors += "Answer four was left empty</br>";
        }

        if(errors === ""){
            var data = new FormData($(this)[0]);
            $.ajax({
                type : "POST",
                enctype : "multipart/form-data",
                processData : false,
                contentType : false,
                cache : false,
                url : "FileAdder",
                data : data,
                success: function (response) {
                    alert(response)
                    if(response==='"Success"'){
                        alert("yay");
                        $("#success").show();
                        $("#errors").hide();
                        $("#success").empty();
                        $("#success").append("Song added into the database successfully");
                    }else{
                        $("#errors").show();
                        $("#errors").empty();
                        $("#errors").append(errors);
                    }
                }
            });
        }else{
            $("#errors").show();
            $("#errors").empty();
            $("#errors").append(errors);
        }
        event.preventDefault();
    });
}



function showArtistAdder() {
    $("#artist-adder").toggle("fast",function () {
        if($(this).is(":visible")){
            $("#add-artist-button").text("Hide Artist Adder");
        }else {
            $("#add-artist-button").text("Add Artist");
        }
    });
}

function showSongAdder() {
    $("#song-adder").toggle("fast",function () {
        if($(this).is(":visible")){
            $("#add-song-button").text("Hide Song Adder");
        }else {
            $("#add-song-button").text("Add Song");
        }
    });
}
