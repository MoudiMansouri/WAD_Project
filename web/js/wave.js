/**
 * Created by Moudi on 3/29/2017.
 */


var id=1;

var wavesurfer = Object.create(WaveSurfer);

wavesurfer.init({
    container: document.querySelector('.wave' + id),
    waveColor: '#4717F6',
    progressColor: '#A239CA',
    interact: false,
    hideScrollbar: true,
    mediaType: 'audio'
});

wavesurfer.on('ready', function () {
    wavesurfer.play();
});

var song = $("#song");
wavesurfer.load(song.attr('class'));



