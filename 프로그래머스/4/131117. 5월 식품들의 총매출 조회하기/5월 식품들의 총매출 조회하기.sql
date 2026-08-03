/*
    생산일자가 2022년 5월인 식품들의 식품 ID, 식품 이름, 총매출을 조회하는 SQL문을 작성해주세요.
    총 매출: price * totalAmount
    총매출을 기준으로 내림차순 정렬, 총매출이 같다면 식품 ID를 기준으로 오름차순 정렬
*/
select p.PRODUCT_ID, p.PRODUCT_NAME, (p.PRICE * o.`TOTAL_AMOUNT`) as `TOTAL_SALES`
from FOOD_PRODUCT p
join (
    select PRODUCT_ID, SUM(AMOUNT) as `TOTAL_AMOUNT`
    from FOOD_ORDER
    where PRODUCE_DATE >= '2022-05-01' and PRODUCE_DATE < '2022-06-01'
    group by PRODUCT_ID
) o on p.PRODUCT_ID = o.PRODUCT_ID
order by `TOTAL_SALES` desc, p.PRODUCT_ID asc;
