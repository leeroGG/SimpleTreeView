package com.example.administrator.treelist;

/**
 * Created by Leero on 2017/11/9.
 * email: myleero@qq.com
 */

public class Node {

    private int id;
    private String content;

    /**
     * 父节点id，默认根节点id为0
     */
    private int pId = 0;

    /**
     * 节点层级
     */
    private int level;

    private boolean isCheck;

    public Node(int id, int pId, int level, String content, boolean isCheck) {
        this.id = id;
        this.pId = pId;
        this.level = level;
        this.content = content;
        this.isCheck = isCheck;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
