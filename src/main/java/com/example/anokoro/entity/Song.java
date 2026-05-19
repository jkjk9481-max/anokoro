package com.example.anokoro.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;        // 곡 제목
    private String artist;       // 아티스트
    private String animeName;    // 애니 이름 (JPOP이면 null 가능)
    private Integer releaseYear; // 발매 연도
    private String mood;         // 기분 태그 (예: 신남, 우울, 설렘, 감동)
    private String genre;        // 장르 (애니OST, JPOP)
    private String youtubeUrl;   // 유튜브 링크
    private Integer likeCount;   // 좋아요 수
}