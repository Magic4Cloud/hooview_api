package com.hooview.common.easemob;

import java.util.List;

public class MuteMembers {

    private List<String> usernames;

    private Long mute_duration;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public Long getMute_duration() {
        return mute_duration;
    }

    public void setMute_duration(Long mute_duration) {
        this.mute_duration = mute_duration;
    }
}
