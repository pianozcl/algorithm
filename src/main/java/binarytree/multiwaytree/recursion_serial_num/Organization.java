package binarytree.multiwaytree.recursion_serial_num;

import java.util.List;

/**
 * @author : chenliangzhou
 * create at:  2021/4/19  11:28 PM
 * @description: 组织
 **/
public class Organization {
    private String id;
    private String parentId;

    private String seq;

    private List<Organization> childrens;

    public Organization(String id, String parentId) {
        this.id = id;
        this.parentId = parentId;
    }

    public Organization() {
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Organization> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Organization> childrens) {
        this.childrens = childrens;
    }
}
