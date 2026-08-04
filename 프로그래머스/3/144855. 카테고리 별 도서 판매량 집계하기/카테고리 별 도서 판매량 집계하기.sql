/*
    2022년 1월의 카테고리 별 도서 판매량을 합산하고, 카테고리(CATEGORY), 총 판매량(TOTAL_SALES) 리스트를 출력
    
    결과는 카테고리명을 기준으로 오름차순 정렬해주세요.
*/

select b.CATEGORY, SUM(s.`SALES_PER_BOOK`) as `TOTAL_SALES`
from BOOK b
join (
    select BOOK_ID, SUM(SALES) as `SALES_PER_BOOK`
    from BOOK_SALES
    where SALES_DATE >= '2022-01-01' and SALES_DATE < '2022-02-01'
    group by BOOK_ID
) s on b.BOOK_ID = s.BOOK_ID
group by b.CATEGORY 
order by b.CATEGORY asc;