package org.zhuyb.tree.organize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @user zyb
 * 收容所
 * @date 2019/2/22
 */
public class Hospice<K> {
    private HashMap<K, LostChild<K>> lostChildren;

    private HashMap<K, List<LostChild<K>>> orphanage;

    public Hospice(int childrenCount) {
        int initialCapacity = (int) (childrenCount / 0.75 + 1);
        lostChildren = new HashMap<>(initialCapacity);
        orphanage = new HashMap<>(initialCapacity);
    }

    /**
     * 迷路的孩子进入收容所认亲
     *
     * @param lostChild
     */
    public void childJoin(LostChild<K> lostChild) {
        lookParent(lostChild);
        lookChildren(lostChild);
        lostChildren.put(lostChild.id(), lostChild);
    }

    /**
     * 查找自己的父节点如果父节点还没来就加入孤儿院
     *
     * @param lostChild
     */
    private void lookParent(LostChild<K> lostChild) {
        K parentId = lostChild.parentId();
        LostChild parent = lostChildren.get(parentId);
        if (parent == null) {
            List<LostChild<K>> orphans = this.orphanage.get(parentId);
            if (orphans == null) {
                orphans = new ArrayList<>();
                orphanage.put(lostChild.parentId(), orphans);
            }
            orphans.add(lostChild);
        } else {
            lostChild.setParent(parent);
            parent.addChild(lostChild);
        }
    }

    /**
     * 如果有一堆等待自己的孤儿就把他们认领
     *
     * @param lostChild
     */
    private void lookChildren(LostChild<K> lostChild) {
        List<LostChild<K>> orphans = orphanage.get(lostChild.id());
        if (orphans != null && orphans.size() > 0) {
            lostChild.setChildren(orphans);
            orphans.remove(lostChild.id());
        }
    }
}

