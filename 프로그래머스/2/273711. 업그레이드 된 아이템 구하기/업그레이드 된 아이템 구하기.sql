-- 코드를 작성해주세요
SELECT child.ITEM_ID,
       child.ITEM_NAME,
       child.RARITY
FROM ITEM_TREE tree
JOIN ITEM_INFO child
    ON tree.ITEM_ID = child.ITEM_ID
JOIN ITEM_INFO parent
    ON tree.PARENT_ITEM_ID = parent.ITEM_ID
WHERE parent.RARITY = 'RARE'
ORDER BY child.ITEM_ID DESC;

