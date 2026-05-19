package com.example.anokoro.controller;

import com.example.anokoro.entity.Song;
import com.example.anokoro.service.SongService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
@RequiredArgsConstructor
public class SongController {

    private final SongService songService;

    // 전체 곡 조회
    @GetMapping
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    // 기분 + 연도로 추천 (핵심 기능)
    @GetMapping("/recommend")
    public List<Song> recommend(@RequestParam String mood ,@RequestParam Integer year) {
        return songService.getSongsByMoodAndYear(mood, year);
    }

    // 좋아요
    @PostMapping("/{id}/like")
    public ResponseEntity<Song> like(@PathVariable Long id) {
        return ResponseEntity.ok(songService.likeSong(id));
    }

    // 곡 등록
    @PostMapping
    public ResponseEntity<Song> addSong(@RequestBody Song song) {
        return ResponseEntity.ok(songService.addSong(song));
    }

    // 여러 곡 한번에 등록
    @PostMapping("/bulk")
    public ResponseEntity<List<Song>> addSongs(@RequestBody List<Song> songs) {
        List<Song> saved = songs.stream()
                .map(songService::addSong)
                .toList();
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/filter")
    public List<Song> filter(
            @RequestParam String mood,
            @RequestParam String genre,
            @RequestParam String anime,
            @RequestParam int era) {
        return songService.filterSongs(mood, genre, anime, era);
    }
}