package com.sang.topic.common.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@JsonIgnoreProperties(value = {"id"})
public class TreeView {
    private Integer id;
    private String text;
    private List<TreeView> nodes;

    public void addNode(String paths, Integer id, String text) {
        List<Integer> list = new LinkedList<>();
        String[] pathArr = paths.split(",");
        for (String path : pathArr) {
            list.add(Integer.valueOf(path.trim()));
        }
        list.remove(0);
        TreeView node = findNode(this, list);
        node.setId(id);
        node.setText(text);
    }

    private static TreeView addNode(TreeView node) {
        TreeView childNode = new TreeView();
        if (node.nodes == null)
            node.nodes = new ArrayList<>();
        node.nodes.add(childNode);
        return childNode;
    }

    private static TreeView findNode(TreeView node, List<Integer> paths) {
        //到最后一个父目录,创建子节点
        if (paths.isEmpty()) {
            return addNode(node);
        }
        //下一个节点
        Integer pathId = paths.remove(0);
        //如果子节点如果不为空，在子节点中寻找下一个节点是否已经创建
        if (node.nodes != null) {
            for (TreeView n : node.nodes) {
                //如果在子节点中找到要下一个节点，进入
                if (pathId.equals(n.getId())) {
                    return findNode(n, paths);
                }
            }
        }
        //如果下一个节点不存在，创建并进入
        return findNode(addNode(node), paths);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<TreeView> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeView> nodes) {
        this.nodes = nodes;
    }
}
