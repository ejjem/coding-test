/*
CAR_RENTAL_COMPANY_CAR : 차 종류
CAR_RENTAL_COMPANY_RENTAL_HISTORY : 대여 기록
CAR_RENTAL_COMPANY_DISCOUNT_PLAN : 대여 옵션

출력 조건
    1) 자동차 종류가 '세단' or 'SUV'
    2) 2022년 11월 1일부터 2022년 11월 30일까지 대여 가능
        -> END_DATE가 11월 1일 전인거
    3) 30일간의 대여 금액이 50만원 이상 200만원 미만
출력 대상
  자동차 ID, 자동차 종류, 대여 금액(컬럼명: FEE) 리스트
출력 형식
    1) 대여 금액을 기준으로 내림차순 정렬
    2) 대여 금액이 같은 경우 자동차 종류를 기준으로 오름차순 정렬
    3) 자동차 종류까지 같은 경우 자동차 ID를 기준으로 내림차순 정렬
*/
select distinct car.CAR_ID, car.CAR_TYPE, ( (car.DAILY_FEE * (100 - plan.DISCOUNT_RATE) / 100 ) * 30 ) as `FEE`
from CAR_RENTAL_COMPANY_CAR car
join (
    select CAR_ID
    from CAR_RENTAL_COMPANY_CAR
    where CAR_ID not in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where START_DATE <= '2022-11-30'
          and END_DATE >= '2022-11-01'
    )
)history
    on car.CAR_ID = history.CAR_ID
join (
    select CAR_TYPE, DISCOUNT_RATE
    from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE = '30일 이상'
)plan
    on car.CAR_TYPE = plan.CAR_TYPE
where car.CAR_TYPE in ('세단', 'SUV')
  and (car.DAILY_FEE * (100 - plan.DISCOUNT_RATE) / 100) * 30 >= 500000
  and (car.DAILY_FEE * (100 - plan.DISCOUNT_RATE) / 100) * 30 < 2000000
order by `FEE` desc, car.CAR_TYPE asc, car.CAR_ID desc;
    

