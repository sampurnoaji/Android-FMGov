package iot.android.fm.network.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("membercode")
    @Expose
    private String membercode;
    @SerializedName("isadmin")
    @Expose
    private Boolean isadmin;
    @SerializedName("levelid")
    @Expose
    private String levelid;
    @SerializedName("departmentid")
    @Expose
    private String departmentid;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("membername")
    @Expose
    private String membername;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("imageaddress")
    @Expose
    private String imageaddress;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("memberid")
    @Expose
    private String memberid;

    public String getMembercode() {
        return membercode;
    }

    public void setMembercode(String membercode) {
        this.membercode = membercode;
    }

    public Boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getLevelid() {
        return levelid;
    }

    public void setLevelid(String levelid) {
        this.levelid = levelid;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageaddress() {
        return imageaddress;
    }

    public void setImageaddress(String imageaddress) {
        this.imageaddress = imageaddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

}

