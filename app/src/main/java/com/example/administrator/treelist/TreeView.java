package com.example.administrator.treelist;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leero on 2017/11/9.
 * email: myleero@qq.com
 */

public class TreeView extends LinearLayout {

    private Context mContext;
    private List<Node> allNodes = new ArrayList<>(); // 所有的节点
    private List<Node> nodeList = new ArrayList<>(); // 正确排序后的节点

    public TreeView(Context context) {
        super(context);
        init(context);
    }

    public TreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TreeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        this.mContext = context;
        setOrientation(LinearLayout.VERTICAL);

        List<Node> newNodes = sort();
        for (Node node : newNodes) {
            // new checkbox
            CheckBox checkBox = new CheckBox(context);
            checkBox.setText(node.getContent());
            checkBox.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
            // 设置外边距
            LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            int marginLeft = 0;
            int marginTop = dp2px(context, 10);
            if (node.getLevel() > 0) {
                marginLeft = dp2px(context, 32 * node.getLevel());
                checkBox.setButtonDrawable(R.drawable.insurance_check_box_bg);
            } else {
                checkBox.setButtonDrawable(R.drawable.insurance_radio_button_bg);
            }
            layoutParams.setMargins(marginLeft, marginTop, 0, 0); // 4个参数按顺序分别是左上右下
            checkBox.setLayoutParams(layoutParams);
            checkBox.setPadding(marginTop, 0, 0, 0);
            // 设置选中
            if (node.isCheck()) {
                checkBox.setChecked(true);
            }

            checkBox.setClickable(false);
            addView(checkBox);
        }
    }

    public void setDataSource(List<Node> data) {
        allNodes.clear();
        allNodes.addAll(data);
        init(mContext);
    }

    /**
     * px转换成dp
     */
    private int dp2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    /**
     * 获取正确顺序的node
     */
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

    /**
     * 递归获取子节点
     *
     * @param currentNode
     */
    private void addNode(Node currentNode) {
        for (Node node : allNodes) {
            if (currentNode.getId() == node.getpId()) {
                nodeList.add(node);
                addNode(node);
            }
        }
    }
}
