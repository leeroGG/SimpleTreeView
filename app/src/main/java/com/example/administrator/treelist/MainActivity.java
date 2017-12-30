package com.example.administrator.treelist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(1, 0, 0, "交强险", false));
        nodes.add(new Node(2, 0, 0, "商业险", true));
        nodes.add(new Node(3, 2, 1, "基本险", true));
        nodes.add(new Node(4, 2, 1, "附加险", true));
        nodes.add(new Node(35, 3, 2, "第三方责任险", false));
        nodes.add(new Node(46, 3, 2, "全车盗抢险", true));
        nodes.add(new Node(7, 3, 2, "车上人员责任险", true));
        nodes.add(new Node(8, 4, 2, "不计免赔特约险", false));
        nodes.add(new Node(9, 4, 2, "玻璃碎险", false));
        nodes.add(new Node(100, 4, 2, "自然险", true));
        nodes.add(new Node(111, 4, 2, "划痕险", false));
        nodes.add(new Node(12, 4, 2, "涉水险", false));
        nodes.add(new Node(13, 4, 2, "发动机特别损失险", true));

        TreeView treeView = new TreeView(this);
        treeView.setDataSource(nodes);
        container = (FrameLayout) findViewById(R.id.frameLayout);
        container.addView(treeView);
    }
}
