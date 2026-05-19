package com.example.anokoro.service;

import com.example.anokoro.entity.Song;
import com.example.anokoro.repository.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SongService {

    private final SongRepository songRepository;

    // 전체 곡 조회
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    // 기분으로 추천
    public List<Song> getSongsByMood(String mood) {
        return songRepository.findByMood(mood);
    }

    // 연도로 추천
    public List<Song> getSongsByYear(Integer year) {
        return songRepository.findByReleaseYear(year);
    }

    // 기분 + 연도로 추천 (핵심 기능)
    public List<Song> getSongsByMoodAndYear(String mood, Integer year) {
        return songRepository.findByMoodAndReleaseYear(mood, year);
    }

    // 좋아요 기능
    public Song likeSong(Long id) {
        Song song = songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("곡을 찾을 수 없어요"));
        song.setLikeCount(song.getLikeCount() + 1);
        return songRepository.save(song);
    }

    // 곡 등록
    public Song addSong(Song song) {
        song.setLikeCount(0);
        return songRepository.save(song);
    }

    public List<Song> filterSongs(String mood, String genre, String anime, int era) {
        int startYear = era;
        int endYear = era + 3;

        List<Song> songs = songRepository.findByMoodAndYearRange(mood, startYear, endYear);

        // 장르 필터
        if (!genre.equals("all")) {
            songs = songs.stream()
                    .filter(s -> s.getGenre().equals(genre))
                    .toList();
        }

        // 애니 필터
        if (!anime.equals("all")) {
            songs = songs.stream()
                    .filter(s -> anime.equals(s.getAnimeName()))
                    .toList();
        }

        return songs;
    }

    public Song getSongById(Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("곡을 찾을 수 없어요"));
    }
}
