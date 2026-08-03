/*
    리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
    회원 이름, 리뷰 텍스트, 리뷰 작성일이 출력되도록 작성
    결과는 리뷰 작성일을 기준으로 오름차순, 리뷰 작성일이 같다면 리뷰 텍스트를 기준으로 오름차순 정렬
*/
SELECT
    p.MEMBER_NAME,
    w1.REVIEW_TEXT,
    w1.REVIEW_DATE
FROM MEMBER_PROFILE p
JOIN REST_REVIEW w1
    ON p.MEMBER_ID = w1.MEMBER_ID
JOIN (
    SELECT MEMBER_ID, COUNT(*) AS REVIEW_COUNT
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
) w2
    ON p.MEMBER_ID = w2.MEMBER_ID
WHERE w2.REVIEW_COUNT = (
    SELECT MAX(REVIEW_COUNT)
    FROM (
        SELECT COUNT(*) AS REVIEW_COUNT
        FROM REST_REVIEW
        GROUP BY MEMBER_ID
    ) counts
)
ORDER BY w1.REVIEW_DATE ASC, w1.REVIEW_TEXT ASC;