/*
    REST_INFO 테이블에서 
    음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
    이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.
*/
select FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from REST_INFO
where (FOOD_TYPE, FAVORITES) in (
    select FOOD_TYPE, MAX(FAVORITES)
    from REST_INFO
    group by FOOD_TYPE
)
order by FOOD_TYPE desc;