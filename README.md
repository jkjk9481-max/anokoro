あのころ (AnoKoro)

그 시절, 그 기분의 노래를 찾아드려요 🎵

<br>
📌 프로젝트 소개
AnoKoro는 사용자의 기분과 추억의 연도를 기반으로 애니 OST와 JPOP을 추천해주는 웹 서비스입니다.
5가지 질문에 답하면 그에 맞는 곡을 추천하고, 유튜브 영상을 카드 안에서 바로 재생할 수 있습니다.
<br>
🔗 배포 URL
https://anokoro.onrender.com
<br>
🛠 기술 스택
분류기술BackendJava 17, Spring Boot 3.5, Spring Data JPADatabasePostgreSQL (Supabase)FrontendThymeleaf, HTML / CSS / JavaScriptDeployRender, DockerVersion ControlGit, GitHub
<br>
✨ 주요 기능

온보딩 질문 flow (기분 → 장르 → 애니 → 연도 → 분위기)
조건에 맞는 곡 추천
유튜브 영상 카드 내 바로 재생
좋아요 기능
곡 데이터 관리 REST API

<br>
🏗 아키텍처
Client (Thymeleaf)
      ↓
Controller
      ↓
Service
      ↓
Repository
      ↓
PostgreSQL (Supabase)
<br>
📋 API 명세
MethodURL설명GET/api/songs전체 곡 조회POST/api/songs곡 등록POST/api/songs/bulk곡 일괄 등록GET/api/songs/recommend기분 + 연도 추천GET/api/songs/filter필터 추천POST/api/songs/{id}/like좋아요PUT/api/songs/{id}곡 수정PUT/api/songs/bulk-update곡 일괄 수정
<br>
📁 프로젝트 구조
src
└── main
    ├── java/com/example/anokoro
    │   ├── controller
    │   │   ├── PageController.java
    │   │   └── SongController.java
    │   ├── entity
    │   │   └── Song.java
    │   ├── repository
    │   │   └── SongRepository.java
    │   ├── service
    │   │   └── SongService.java
    │   └── AnokoroApplication.java
    └── resources
        ├── templates
        │   └── index.html
        └── application.properties
<br>
⚙️ 실행 방법
bashgit clone https://github.com/jkjk9481-max/anokoro
cd anokoro
./gradlew build
java -jar build/libs/*.jar
<br>
📅 개발 기간
2026년 5월
<br>
👨‍💻 개발자

GitHub: https://github.com/jkjk9481-max
