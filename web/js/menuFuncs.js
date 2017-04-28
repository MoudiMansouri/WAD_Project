/**
 * Created by Moudi on 4/19/2017.
 */



$(document).ready(function() {
    $(".artist").click(function(event) {
        var name = event.target.id;
        var number = $("#number").className;
        document.getElementById("artist_name").value = name;
        document.formm.submit();
    })
});




