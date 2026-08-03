/*
    CAR_RENTAL_COMPANY_RENTAL_HISTORY 테이블에서 
    1) 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시
    2) 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 
    3) 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문을 작성
    이때 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시해주시고 
    결과는 자동차 ID를 기준으로 내림차순 정렬해주세요.
*/
/*
select h1.CAR_ID, 
    case 
        when h2.CAR_ID is not null then '대여중'
        else '대여 가능'
    end as 'AVAILABILITY'
from CAR_RENTAL_COMPANY_RENTAL_HISTORY h1
left join (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where CAR_ID in (
        select distinct CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-10-16' and
            END_DATE >= '2022-10-16'
    )
) h2 on h1.CAR_ID = h2.CAR_ID
group by h1.CAR_ID
order by h1.CAR_ID desc;
*/

SELECT
    CAR_ID,
    CASE
        WHEN MAX(
            CASE
                WHEN START_DATE <= '2022-10-16'
                 AND END_DATE >= '2022-10-16'
                THEN 1
                ELSE 0
            END
        ) = 1
        THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;