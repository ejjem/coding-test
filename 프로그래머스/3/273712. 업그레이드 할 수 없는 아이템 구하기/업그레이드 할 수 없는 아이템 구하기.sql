-- 코드를 작성해주세요
-- 자식이 없는 거 찾기
select info.ITEM_ID, info.ITEM_NAME, info.RARITY
from ITEM_INFO info
left join ITEM_TREE tree
    on info.ITEM_ID = tree.PARENT_ITEM_ID 
where tree.ITEM_ID is null
order by info.ITEM_ID desc;