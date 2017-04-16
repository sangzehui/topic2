package com.sang.topic.common.model;

import com.sang.topic.util.TopicStringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//@JsonIgnoreProperties(value = {"id"})
public class TreeView {
    private Integer id;
    private String text;
    private List<TreeView> nodes;

    public void addNode(String paths, Integer id, String text) {
        List<Integer> list = new LinkedList<>(TopicStringUtils.toIntegerList(paths));
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
        if (paths.isEmpty()) {
            return addNode(node);
        }
        Integer pathId = paths.remove(0);
        if (node.nodes != null) {
            for (TreeView n : node.nodes) {
                if (pathId.equals(n.getId())) {
                    return findNode(n, paths);
                }
            }
        }
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
