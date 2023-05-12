public class Song {
    private String name;
    private String Artist;
    private String duration;

    public Song(String name, String artist, String duration) {
        this.name = name;
        Artist = artist;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", Artist='" + Artist + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
