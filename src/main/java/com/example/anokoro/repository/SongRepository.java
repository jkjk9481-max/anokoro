package com.example.anokoro.repository;

import com.example.anokoro.entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByMood(String mood);
    List<Song> findByReleaseYear(Integer releaseYear);
    List<Song> findByMoodAndReleaseYear(String mood, Integer releaseYear); // 핵심 쿼리
    List<Song> findByGenre(String genre);

    @Query("SELECT s FROM Song s WHERE s.mood = :mood AND s.releaseYear BETWEEN :startYear AND :endYear")
    List<Song> findByMoodAndYearRange(
            @Param("mood") String mood,
            @Param("startYear") int startYear,
            @Param("endYear") int endYear
    );
}