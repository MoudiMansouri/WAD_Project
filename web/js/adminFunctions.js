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

        alert("Hello");
        var data = new FormData($(this)[0]);
        // var ansOne = $("#var-answer-one").val();
        // var ansTwo = $("#var-answer-two").val();
        // var ansThree = $("#var-answer-three".val());
        // var ansFour = $("#var-answer-four").val();
        // data.append("one",ansOne);
        // data.append("two",ansTwo);
        // data.append("three",ansThree);
        // data.append("four",ansFour);
        // data.append("file",song);
        $.ajax({
            type : "POST",
            enctype : "multipart/form-data",
            processData : false,
            contentType : false,
            cache : false,
            url : "FileAdder",
            data : data,
            success: function (response) {
                if(response==="Invalid"){
                    alert("Invalid");
                }else{
                    alert("Valid");
                }
            }
        });
        event.preventDefault();
        alert("Sent");
    })
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
