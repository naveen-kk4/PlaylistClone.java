
import java.util.*;
import java.io.*;

public class PlayList {
    private String Name;
    private List<Song> songs;
    boolean wasNext = false;
    ListIterator<Song> itr;

    public PlayList(String name) {
        Name = name;
        this.songs = new ArrayList<>();
        itr = songs.listIterator();
    }
    public Optional<Song> songPresent(Album alb , String s){
        for(Song song : songs){
            if(song.getName().equals(s) && song.getArtist().equals(alb.getArtist()))return Optional.of(song);
        }
        return Optional.empty();
    }
    public String addSongFromAlbum(Album alb , String s){
        Optional<Song> a = alb.getSong(s);
        if(a.isPresent()){
            Optional<Song> exists = songPresent(alb,s);
            if(exists.isPresent()){
                return "song already exists";
            }
            songs.add(a.get());
            itr = songs.listIterator();
            return "song added succesfully";
        }
        return "song not present";
    }
    public String deleteSong(Album alb , String s) {
        Optional<Song> exists = songPresent(alb,s);
        if(exists.isPresent()){
            songs.remove(exists.get());
            return "song removed successfully";
        }
       return "song not present";
    }
    public String playNext(){
        if(!wasNext){
            wasNext = true;
            itr.next();
        }
        if(itr.hasNext()){
            wasNext = true;
            return "the next song is" + itr.next();

        }
        return "reached end of playlist";
    }
    public String playPrevious(){
        if(wasNext){
            wasNext = false;
            itr.previous();
        }
        if(itr.hasPrevious()){
            wasNext = false;
            return "the previous song is" + itr.previous();

        }
        return "at the beginning of the playlist";
    }
    public String currentSong(){
        if(wasNext){
            wasNext = false;
            return "the current song is" + itr.previous();
        }
        wasNext = true;
        return "the current song is" + itr.next();
    }

}
