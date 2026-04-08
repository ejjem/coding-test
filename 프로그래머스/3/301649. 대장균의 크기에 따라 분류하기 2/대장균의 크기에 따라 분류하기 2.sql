-- 코드를 작성해주세요
SELECT ID,
       CASE
           WHEN RN <= CNT * 0.25 THEN 'CRITICAL'
           WHEN RN <= CNT * 0.50 THEN 'HIGH'
           WHEN RN <= CNT * 0.75 THEN 'MEDIUM'
           ELSE 'LOW'
       END AS COLONY_NAME
FROM (
    SELECT ID,
           ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RN,
           COUNT(*) OVER () AS CNT
    FROM ECOLI_DATA
) T
ORDER BY ID ASC;