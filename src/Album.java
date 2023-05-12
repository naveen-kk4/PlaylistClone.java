
import java.util.*;
import java.io.*;
public class Album {
    private String song;
    private String artist;
    private List<Song> songs;

    public Album(String song, String artist, List<String> songs) {
        this.song = song;
        this.artist = artist;

    }
    public Album(String song , String artist){
        this.song = song;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    public boolean findSong(Song s){
        for(Song song:songs){
            if(song.getName()==s.getName() && song.getArtist()==s.getArtist())return true;

        }
        return false;
    }
    public Optional<Song> getSong(String s){
        for(Song song:songs){
            if(song.getName().equals(s) )return Optional.of(song);

        }
        return Optional.empty();
    }
    public String addSong(Song s){
        if(findSong(s)){
            return "song already exists";
        }
        this.songs.add(s);
        return "song successfully added";
    }

}
