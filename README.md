あのころ — AnoKoro
🎵 그 시절, 그 기분의 노래를 찾아드려요
🔗 https://anokoro.onrender.com


💡 프로젝트 소개
AnoKoro는 사용자의 기분과 추억의 연도를 기반으로 애니 OST와 JPOP을 추천해주는 웹 서비스입니다.
5가지 질문에 순서대로 답하면 그에 맞는 곡을 추천하고, 유튜브 영상을 카드 안에서 바로 재생할 수 있습니다.

"오늘 기분이 우울해" → "2018년 감성" → 딱 맞는 노래 추천 🎶


🛠 기술 스택
분류기술BackendJava 17, Spring Boot 3.5, Spring Data JPADatabasePostgreSQL (Supabase)FrontendThymeleaf, HTML, CSS, JavaScript배포Render, Docker버전 관리Git, GitHub



✨ 주요 기능
기능설명온보딩 질문 flow기분 → 장르 → 애니 → 연도 → 분위기 순서로 질문곡 추천선택한 조건에 맞는 곡 필터링 후 추천유튜브 재생카드 내 재생 버튼 클릭 시 유튜브 영상 바로 재생좋아요곡별 좋아요 수 기록REST API곡 등록 / 수정 / 조회 API 제공



🏗 아키텍처
사용자 (브라우저)
      ↓
  Thymeleaf (HTML/CSS/JS)
      ↓
  Controller (REST API)
      ↓
  Service (비즈니스 로직)
      ↓
  Repository (JPA)
      ↓
  PostgreSQL (Supabase)

  

📋 API 명세
MethodURL설명GET/api/songs전체 곡 조회POST/api/songs곡 등록POST/api/songs/bulk곡 일괄 등록GET/api/songs/recommend기분 + 연도 추천GET/api/songs/filter다중 조건 필터 추천POST/api/songs/{id}/like좋아요PUT/api/songs/{id}곡 수정PUT/api/songs/bulk-update곡 일괄 수정



📁 프로젝트 구조
src/main/java/com/example/anokoro
├── controller
│   ├── PageController.java      # 페이지 라우팅
│   └── SongController.java      # 곡 관련 REST API
├── entity
│   └── Song.java                # 곡 엔티티
├── repository
│   └── SongRepository.java      # JPA 레포지토리
├── service
│   └── SongService.java         # 비즈니스 로직
└── AnokoroApplication.java



⚙️ 로컬 실행 방법
bashgit clone https://github.com/jkjk9481-max/anokoro
cd anokoro
./gradlew build
java -jar build/libs/*.jar

📅 개발 기간
2026년 5월

👨‍💻 개발자
이름역할GitHub도윤백엔드 개발@jkjk9481-max
