package com.vivo.spring.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/23 9:09
 **/
@Setter
@Getter
@ToString
public class TreeNode {
    private String valueS;
    private int valueI = 0;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(){}

    public TreeNode(int valueI) {
        this.valueI = valueI;
    }
}
