BEGIN
    -- 定义标签接收变量
    DECLARE newsLabelId BIGINT;
    DECLARE newsLabelName VARCHAR(250);
    DECLARE newsLabelKey VARCHAR(200);
    DECLARE newsLabelParentId BIGINT;

    -- 定义新闻资讯接收变量
		DECLARE newsId BIGINT;
    DECLARE newsTitle VARCHAR(200);
    DECLARE newsContent text;
    DECLARE sourceUrl VARCHAR(255);

    -- 定义特殊网站接收变量
    DECLARE specialUrl VARCHAR(255);
    DECLARE originContent VARCHAR(200);
    DECLARE replaceContent VARCHAR(200);

    -- 定义政策接收字段
    DECLARE policySortId BIGINT;
    DECLARE policySortKeyword text;

		DECLARE policyTitle VARCHAR(200);
		DECLARE policyShowTime VARCHAR(200);
		DECLARE policySort BIGINT;
		DECLARE newsSource VARCHAR(200);
		DECLARE policySourceUrl VARCHAR(255);
		DECLARE policyContent text;
		DECLARE policycreateTime VARCHAR(200);

    DECLARE labelId BIGINT;
    DECLARE content text;
		DECLARE isUpdate SMALLINT;
		DECLARE otherId BIGINT;

    -- 定义游标
    DECLARE done int;
    DECLARE lehuo_news_label CURSOR FOR select id,keyword,label_name,parent_id from lh_news_label WHERE label_name !='其他' ORDER BY id; 
    DECLARE lehuo_news CURSOR FOR select id,news_title,news_content,source_url from lh_news where news_label_id = 0;
    DECLARE lehuo_special_site CURSOR FOR select special_url,origin_content,replace_content from lh_special_site;
    DECLARE lehuo_policy CURSOR FOR select id,keyword from lh_policy_sort;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
    SET otherId = -1;
    -- 循环没有标签的新闻
    open lehuo_news;
    out_loop:LOOP
        FETCH lehuo_news INTO newsId,newsTitle,newsContent,sourceUrl;

        IF done = 1 THEN
            LEAVE out_loop;
        END IF;
        
        SET content=null;
        -- 循环特殊网站处理
        open lehuo_special_site;
        inner_loop0:LOOP
        FETCH lehuo_special_site INTO specialUrl,originContent,replaceContent;
        IF done = 1 THEN
            LEAVE inner_loop0;
        END IF;
        IF ((sourceUrl REGEXP specialUrl)>0 ) THEN
            SET content=replace(newsContent,originContent,replaceContent);
            LEAVE inner_loop0;
        END IF;
        SET done=0;
        END LOOP inner_loop0;
        CLOSE lehuo_special_site;
        IF content is null THEN
            SET content=newsContent;
        END IF;
        -- 循环特殊网站处理
        SET done=0;
        SET isUpdate = 0;
        -- 循环标签匹配新闻开始
        open lehuo_news_label;
        inner_loop1:LOOP
        FETCH lehuo_news_label INTO newsLabelId,newsLabelKey,newsLabelName,newsLabelParentId;
        IF done = 1 THEN
            LEAVE inner_loop1;
        END IF;
        IF ((newsContent REGEXP newsLabelName)>0) THEN
            IF (newsLabelParentId IS NULL) THEN 
                -- 更新新闻
                SET labelId = newsLabelId;
            ELSE
                SET labelId = newsLabelParentId;
            END IF;
            -- 更新热词
            INSERT INTO lh_finance_hotword(finance_date,news_label,total) VALUES (NOW(),newsLabelName,1) ON DUPLICATE KEY UPDATE total=total+1;
            SET isUpdate=1;
            LEAVE inner_loop1;
        END IF;
		 SET done=0;
        END LOOP inner_loop1;
        CLOSE lehuo_news_label;

		open lehuo_news_label;
        inner_loop1:LOOP
        FETCH lehuo_news_label INTO newsLabelId,newsLabelKey,newsLabelName,newsLabelParentId;
        IF done = 1 THEN
            LEAVE inner_loop1;
        END IF;
        IF ((newsTitle REGEXP newsLabelName)>0) THEN
            IF (newsLabelParentId IS NULL) THEN 
                -- 更新新闻
                SET labelId = newsLabelId;
            ELSE
                SET labelId = newsLabelParentId;
            END IF;
            -- 更新热词
            INSERT INTO lh_finance_hotword(finance_date,news_label,total) VALUES (NOW(),newsLabelName,1) ON DUPLICATE KEY UPDATE total=total+1;
            SET isUpdate=1;
            LEAVE inner_loop1;
        END IF;
		 SET done=0;
        END LOOP inner_loop1;
        CLOSE lehuo_news_label;
        IF isUpdate=1 THEN
            UPDATE lh_news SET news_label_id = labelId,news_content=newsContent where id=newsId;
        ELSE
            UPDATE lh_news SET news_label_id = otherId,news_content=newsContent where id = newsId;
        END IF;
        -- 循环标签匹配新闻结束
        -- 金融资讯过滤政策开始
        SET done=0;
        open lehuo_policy;
        inner_loop2:LOOP
        FETCH lehuo_policy INTO policySortId,policySortKeyword;
        IF done = 1 THEN
            LEAVE inner_loop2;
        END IF;
        IF (newsTitle REGEXP policySortKeyword)>0 THEN
            -- 插入政策
        SELECT news_title,show_time,policySortId,news_source,source_url,news_content,create_time INTO policyTitle,policyShowTime,policySort,newsSource, policySourceUrl,policyContent ,policycreateTime from lh_news where id = newsId;    
		  insert into lh_policy(`policy_title`, `show_time`, `policy_sort_id`, `policy_source`, `source_url`, `policy_content`,`policy_from`, `policy_type`, `status`, `del_flag`, `create_time`,
			`is_banner`,`banner_url`,`create_user`) VALUES(policyTitle,policyShowTime,policySort,newsSource,policySourceUrl,policyContent,2,1,1,0,policycreateTime,0,'','admin') ON DUPLICATE KEY UPDATE `policy_content`=values(policy_content);
            LEAVE inner_loop2;
        END IF;
		SET done=0;
        END LOOP inner_loop2;
        CLOSE lehuo_policy;
        -- 金融资讯过滤政策结束
        SET done=0;
    END LOOP out_loop;
  CLOSE lehuo_news;
END