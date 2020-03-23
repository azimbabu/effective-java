package chapter4.item20.song;

public interface SingerSongwriter extends Singer, SongWriter {
  AudioClip strum();

  void actSensitive();
}
