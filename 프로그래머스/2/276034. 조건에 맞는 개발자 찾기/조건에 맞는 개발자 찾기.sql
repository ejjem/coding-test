-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS
where SKILL_CODE & (select CODE from SKILLCODES where NAME = 'Python') or
    SKILL_CODE & (select CODE from SKILLCODES where NAME = 'C#')
order by ID asc;

/*
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE (
    SKILL_CODE & (
        SELECT SUM(CODE)
        FROM SKILLCODES
        WHERE NAME IN ('Python', 'C#')
    )
) != 0
ORDER BY ID ASC;
*/