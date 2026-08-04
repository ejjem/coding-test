/*
    3세대의 대장균의 ID(ID) 를 출력
    이때 결과는 대장균의 ID 에 대해 오름차순 정렬해주세요.
    
    PARENT_ID가 NULL -> 1세대, 얘네만 따로 찾아놓음
    1세대를 PARENT_ID로 가진 애들 -> 2세대
    2세대를 PARENT_ID로 가진 애들 -> 3세대
    
    
    
*/
select ID
from ECOLI_DATA d3
where PARENT_ID in (
    select ID
    from ECOLI_DATA d2
    where PARENT_ID in (
        select ID
        from ECOLI_DATA d1
        where PARENT_ID is null
    )
)
order by ID asc;


