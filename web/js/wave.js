/**
 * Created by Moudi on 3/29/2017.
 */


var id=1;

var wavesurfer = Object.create(WaveSurfer);

wavesurfer.init({
    container: document.querySelector('.wave' + id),
    waveColor: 'violet',
    progressColor: 'purple',
    interact: false,
    hideScrollbar: true,
    mediaType: 'audio'
});

wavesurfer.on('ready', function () {
    wavesurfer.play();
});

var song = $("#song");
alert(song.attr('class'));
wavesurfer.load(song.attr('class'));



