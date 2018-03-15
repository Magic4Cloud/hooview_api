package com.hooview.api.dto;


import java.util.List;

public class MuteCharMembers {

    private String roomId;

    private List<String> usernames;

    private Long muteDuration;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public Long getMuteDuration() {
        return muteDuration;
    }

    public void setMuteDuration(Long muteDuration) {
        this.muteDuration = muteDuration;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }


}
