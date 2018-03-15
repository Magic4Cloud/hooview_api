BEGIN
    -- 定义标签接收变量
    DECLARE epTaxonomyId BIGINT;
    DECLARE epTaxonomyName VARCHAR(250);

    -- 定义企业信息接收变量
		DECLARE epId BIGINT;
    DECLARE epName VARCHAR(200);
    DECLARE epProfile text;
    DECLARE epType VARCHAR(40);

    DECLARE epLocationId BIGINT;
    DECLARE epTaxId BIGINT;
    DECLARE epLabel VARCHAR(32);
    DECLARE financeRound VARCHAR(10);

    -- 定义游标
    DECLARE done int;
    DECLARE lehuo_ep_taxonomy CURSOR FOR SELECT id,keyword FROM lh_ep_taxonomy ORDER BY id DESC; 
    DECLARE lehuo_ep CURSOR FOR select id,ep_name,ep_profile,ep_type from lh_ep WHERE taxonomy_id = 0 AND markup=0;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    -- 循环没有分类的企业，通过企业标题和简介区分企业类别
    open lehuo_ep;
    out_loop:LOOP
        FETCH lehuo_ep INTO epId,epName,epProfile,registeredAddress,epType;
        IF done = 1 THEN
            LEAVE out_loop;
        END IF;
        SET epLocationId=0;
        SET epTaxId=0;
        -- 循环分类匹配企业
        open lehuo_ep_taxonomy;
        inner_loop:LOOP
        FETCH lehuo_ep_taxonomy INTO epTaxonomyId,epTaxonomyName;
        IF done = 1 THEN
            LEAVE inner_loop;
        END IF;

				IF ((epName REGEXP '银行')>0 OR (epName REGEXP '证券')>0 OR (epName REGEXP '保险')>0) THEN
				SET epTaxId=-1;
				LEAVE inner_loop;
				END IF;
        IF ((epName REGEXP epTaxonomyName)>0 OR (epProfile REGEXP epTaxonomyName)>0) THEN
            SET epTaxId=epTaxonomyId;
            LEAVE inner_loop;
        END IF;
        END LOOP inner_loop;
        CLOSE lehuo_ep_taxonomy;
        IF epTaxId=0 THEN
            SET epTaxId=-1;
        END IF;
        -- 设定企业类型
        IF ((epType REGEXP '外国法人')>0) THEN
            SET epLabel='外资公司';
        ELSEIF ((epType REGEXP '上市')>0) THEN
            SET epLabel='上市公司';
        ELSEIF ((epType REGEXP '中外合资|港澳台合资|港台澳合资|台澳港合资|台港澳合资|澳台港合资|澳港台合资|外商合资')>0) THEN
            SET epLabel='合资公司';
        ELSE 
            SET epLabel='其他公司';
        END IF;
        -- 设定融资轮次
        SET financeRound=(SELECT round FROM lh_ep_financing WHERE ep_id = epId ORDER BY financing_date DESC LIMIT 1);
        IF financeRound IS NULL THEN
            SET financeRound='尚未融资';
        END IF;
        -- 更新数据
        UPDATE lh_ep SET taxonomy_id = epTaxId,ep_label=epLabel,finance_round=financeRound where id=epId;
        SET done=0;
    END LOOP out_loop;
  CLOSE lehuo_ep;
END