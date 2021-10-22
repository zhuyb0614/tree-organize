package org.zhuyb.tree.organize;

import java.util.List;

/**
 * @user zyb
 * @date 2019/2/22
 */
public interface LostChild<K> {
    /**
     * 关联子节点
     * @param children
     */
    void setChildren(List<LostChild<K>> children);

    /**
     * 关联父节点
     * @param parent
     */
    void setParent(LostChild<K> parent);

    /**
     * 获取父ID
     * @return
     */
    K parentId();

    /**
     * 添加子节点
     * @param child
     * @return
     */
    boolean addChild(LostChild<K> child);

    /**
     * 获取ID
     * @return
     */
    K id();
}
