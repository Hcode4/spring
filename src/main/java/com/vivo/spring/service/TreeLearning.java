package com.vivo.spring.service;

import com.vivo.spring.common.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

/**
 * @Author HYZ
 * @Describe
 * @Version 1.0
 * @since 2021/1/22 22:21
 **/
@Slf4j
public class TreeLearning {

    /**
     * @param preOrder  前序
     * @param postOrder 后续
     * @return void
     * @description 通过前序，后续构造二叉树。因为无法确定左子树，右子树的位置，所以可能会有多种结果
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 9:0
     **/
    public void prePostBuildTree(List<String> preOrder, List<String> postOrder) {

    }

    /**
     * @param preOrder    前序
     * @param mediumOrder 中序
     * @return void
     *  * @description 通过前序，中序构造二叉树
     *  * @author Yuanzhi Hu
     *  * @version v1.0
     *  * @since  2021/1/23 9:40
     *  
     **/
    public static TreeNode preMediumBuildTree(List<Integer> preOrder, List<Integer> mediumOrder) {

        if (!preOrder.isEmpty() && !mediumOrder.isEmpty()) {
            TreeNode nodeInsert = new TreeNode();
            nodeInsert.setValueI(preOrder.get(0));
            int indexMedium = mediumOrder.indexOf(preOrder.get(0));
            List<Integer> leftChild = mediumOrder.subList(0, indexMedium);
            List<Integer> rightChild = mediumOrder.subList(indexMedium + 1, mediumOrder.size());
            nodeInsert.setLeftChild(preMediumBuildTree(preOrder.stream().filter(leftChild::contains).collect(Collectors.toList()), leftChild));
            nodeInsert.setRightChild(preMediumBuildTree(preOrder.stream().filter(rightChild::contains).collect(Collectors.toList()), rightChild));
            return nodeInsert;
        } else {
            return null;
        }
    }

    /**
     * @param root       根节点
     * @param insertNode 需要插入的节点
     * @return com.vivo.spring.common.TreeNode
     *  * @description 插入节点后仍是二叉查找树
     *  * @author Yuanzhi Hu
     *  * @version v1.0
     *  * @since  2021/1/23 9:25
     *  
     **/
    public static TreeNode insertNode(TreeNode root, TreeNode insertNode) throws Exception {
        if (root == null) {
            root = insertNode;
        } else {
            if (root.getValueI() > insertNode.getValueI()) {
                root.setLeftChild(insertNode(root.getLeftChild(), insertNode));
            } else if (root.getValueI() < insertNode.getValueI()) {
                root.setRightChild(insertNode(root.getRightChild(), insertNode));
            } else {
                throw new Exception();
            }
        }
        return root;
    }

    /**
     * @param node 需要统计节点
     * @param countNumber 需要统计数据
     * @param traceRecord 路径记录
     * @return void
     * @description 打印出某个路径等于某个值
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 10:33
     **/
    public static void printCountExactNumber(TreeNode node, int countNumber, List<Integer> traceRecord) {
        if (node != null) {
            traceRecord.add(node.getValueI());
            if (traceRecord.stream().reduce(Integer::sum).orElse(0) == countNumber) {
                log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                        traceRecord.toString()));
            }
            printCountExactNumber(node.getLeftChild(), countNumber, new ArrayList<>(traceRecord));
            printCountExactNumber(node.getRightChild(), countNumber, new ArrayList<>(traceRecord));
        }
    }

    /**
     * @param node 当前需要遍历节点
     * @param fromValue 下限
     * @param toValue 上限
     * @return void
     * @description 获取二叉树某个区间所有节点, 通过升序进行打印
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 10:37
     **/
    public static void printRangeNode(TreeNode node, int fromValue, int toValue) {
        if(node != null) {
            printRangeNode(node.getLeftChild(), fromValue, toValue);
            if(node.getValueI() > fromValue && node.getValueI() < toValue) {
                log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                        node.toString()));
            }
            printRangeNode(node.getRightChild(), fromValue, toValue);
        }
    }

    /**
     * @param root 需要遍历的根节点
     * @return void
     * @description 层级遍历
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 10:49
     **/
    public static void levelScanTree(TreeNode root) {
        Queue<TreeNode>dealData = new LinkedBlockingDeque<>();
        if(root != null) {
            dealData.add(root);
            while(!dealData.isEmpty()) {
                TreeNode node = dealData.poll();
                if(node != null) {
                    log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                            node.toString()));
                    Optional.ofNullable(node.getLeftChild()).ifPresent(dealData::add);
                    Optional.ofNullable(node.getRightChild()).ifPresent(dealData::add);
                }
            }
        }
    }

    /**
     * @param dealArray 需要处理数组
     * @return boolean 判断是否为后序遍历
     * @description
     * @author Yuanzhi Hu
     * @version v1.0
     * @since  2021/1/23 11:13
     **/
    public static boolean isPastOrder(List<Integer>dealArray) {
        if(dealArray.isEmpty()) {
            return true;
        }
        List<Integer>leftChild = new ArrayList<>();
        int root = dealArray.get(dealArray.size() - 1);
        int i;
        for(i = 0; i < dealArray.size() - 1; i++) {
            if(dealArray.get(i) < root) {
                leftChild.add(dealArray.get(i));
            } else {
                break;
            }
        }
        List<Integer> rightChild = new ArrayList<>(dealArray.subList(i, dealArray.size() - 1));
        return rightChild.stream().noneMatch(value -> value < root) && isPastOrder(leftChild) && isPastOrder(rightChild);
    }

    public static void main(String[] args) throws Exception {
        List<Integer> preOrder = Arrays.asList(7, 5, 4, 6, 9);
        List<Integer> mediumOrder = Arrays.asList(4, 5, 6, 7, 9);
        TreeNode root = preMediumBuildTree(preOrder, mediumOrder);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s", Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getLineNumber(),
                root));

        List<Integer> pastOrder = Arrays.asList(4, 6, 5, 8, 9, 7);
        boolean isPastOrder = isPastOrder(pastOrder);
        log.info(String.format("方法：%s 第：%s, 其他信息：%s",Thread.currentThread().getStackTrace()[1].getMethodName(),Thread.currentThread().getStackTrace()[1].getLineNumber(),
                isPastOrder));
    }
}
