package com.hooview.api.dto;

/**
 * @auther lee
 * @createTime 2018年01月31日 16时07分
 * @discription
 */
public class HotLiveDTO {
    private Long liveId;
    private Integer watchingCount;

    public Long getLiveId() {
        return liveId;
    }

    public void setLiveId(Long liveId) {
        this.liveId = liveId;
    }

    public Integer getWatchingCount() {
        return watchingCount;
    }

    public void setWatchingCount(Integer watchingCount) {
        this.watchingCount = watchingCount;
    }
}
