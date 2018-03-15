package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月25日 17时45分
 * @discription
 */
@SuppressWarnings({"unchecked", "unused"})
public class RecommendDTO {

    //财经资讯id
    private Long financeInfoId;
    //标题
    private String title;

    public Long getFinanceInfoId() {
        return financeInfoId;
    }

    public void setFinanceInfoId(Long financeInfoId) {
        this.financeInfoId = financeInfoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
