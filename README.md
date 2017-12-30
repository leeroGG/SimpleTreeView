# SimpleTreeView（简单的树形图）
**效果图**
</br>
</br>
![image](https://github.com/leeroGG/SimpleTreeView/raw/master/result.png)
</br>
</br>
</br>
**实现原理**
* 创建节点实体类</br>
节点实体类中必须含有level（当前节点层级）和 pID（父级id）两个属性，用于节点排序，其他属性可以自由添加</br>
* 节点排序</br>
利用每节点的层级和记录的父级id，查找所有的一级节点，从一级节点出发，递归查找所有的子节点，每查找到一个节点就保存到结果list中。</br>
展示时直接顺序使用结果list里的节点进行展示即可。</br>
```
private List<Node> sort() {
    List<Node> rootNodes = new ArrayList<>();
    // 找到所有根节点
    for (Node node : allNodes) {
        if (node.getLevel() == 0) {
            rootNodes.add(node);
        }
    }

    // 从根节点开始，一个个节点添加到新的list中
    for (Node rootNode : rootNodes) {
        nodeList.add(rootNode);
        addNode(rootNode);
    }

    return nodeList;
}
```
</br>

```
private void addNode(Node currentNode) {
    for (Node node : allNodes) {
        if (currentNode.getId() == node.getpId()) {
            nodeList.add(node);
            addNode(node);
        }
    }
}
```
</br>

* 节点缩进</br>
根据节点层级level设置外边距（固定边距 * level）
