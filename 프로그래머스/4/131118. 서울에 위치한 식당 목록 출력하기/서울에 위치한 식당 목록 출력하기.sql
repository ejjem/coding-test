-- REST_INFO와 REST_REVIEW 테이블에서 서울에 위치한 식당들의 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수를 조회하는 SQL문을 작성해주세요. 
-- 이때 리뷰 평균점수는 소수점 세 번째 자리에서 반올림 해주시고 결과는 평균점수를 기준으로 내림차순 정렬해주시고, 평균점수가 같다면 즐겨찾기수를 기준으로 내림차순 정렬해주세요.


SELECT r1.REST_ID, r1.REST_NAME, r1.FOOD_TYPE, r1.FAVORITES, r1.ADDRESS, ROUND(AVG(r2.REVIEW_SCORE), 2) as `SCORE`
from REST_INFO r1
join REST_REVIEW r2
    on r1.REST_ID = r2.REST_ID
where r1.ADDRESS like '서울%'
group by r1.REST_ID
order by `SCORE` DESC, r1.FAVORITES DESC;