# SpringBoard 게시판 만들기

**1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)**

=> 수정 API는 param을 통해 id 변수를 담고, body를 통해 수정 할 객체를 담아서 보내고 Controller에서 @PathVariable 과 @RequestBody를 통해 값을 전달 받았다.
   삭제 API는 param을 통해 id 변수를 담아서 보내고 Controller에서 @PathVariable을 통해 값을 전달 받았다.


**2. 어떤 상황에 어떤 방식의 request를 써야하나요?**

=> 주소에 포함된 변수를 담을 때는 Param을 사용하고,
   주소 바깥 이후의 변수를 담을 때는 query를 사용하고,
   XML, JSON, Multi Form등의 데이트를 담을 때는 body를 사용한다.


**3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?**

=> 조회, 저장, 수정, 삭제 기능을 RESTful한 API 설계를 했다. RESTful은 동적인 api이다. CRUD 작업은 전달 되는 자원에 따라서 동적인 화면이 만들어 지기 때문에 RESTful하다고 할 수 있다. 그러나, 단순 아무 값이 없는 정적인 html 화면 이동은 RESTful하지 않다고 할 수 있다.


**4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)**

=> Controller는 클라이언트에서의 요청을 받아 mapping해주고 Service에서 가져온 데이터를 다시 응답하는 연결고리 역할이고,
   Service는 Controller에서 받은 데이터를 통해 클라이언트 요청에 적절한 데이터를 만들기 위한 실질적인 로직이 수행되는 역할이고,
   Respository는 DB에서 내가 필요한 데이터를 꺼내오는 역할이다.
  
  
**5. 작성한 코드에서 빈(Bean)을 모두 찾아보세요!**

=> @RestController가 붙어있는 Controller 와 @Service가 붙어있는 Service가 빈 객체이다. 그리고 Repository 어노테이션이 붙어있지 않지만 빈 객체이다.


**6. API 명세서 작성 가이드라인을 검색하여 직접 작성한 명세서와 비교해보세요!**

|API 이름|URL 주소|오퍼레이션 유형|교환 데이터 포맷|기타|
|:---|:---:|:---:|:---:|:---|
|전체 게시글 목록 조회|/findAll|REST/GET|JSON| |
|게시글 작성|/save|REST/POST|JSON|body데이터 필요|
|게시글 조회|/findOne/{id}|REST/GET|JSON| |
|비밀번호 확인|/pwdCheck/{id}/{pwd}|REST/GET|JSON| |
|게시글 수정|/update/{id}|REST/PUT|JSON|body데이터 필요 |
|게시글 삭제|/delete/{id}|REST/DELETE|JSON| |
