package org.zhuyb.tree.organize;

import java.util.ArrayList;
import java.util.List;

/**
 * @user zyb
 * @date 2019/2/22
 */
public abstract class AbstractLostChild<K> implements LostChild<K> {
    private List<LostChild<K>> children;
    private LostChild<K> parent;
    protected K id;
    protected K parentId;


    @Override
    public K parentId() {
        return parentId;
    }

    @Override
    public K id() {
        return id;
    }

    @Override
    public void setChildren(List<LostChild<K>> lostChildren) {
        this.children = lostChildren;
    }

    @Override
    public void setParent(LostChild<K> parent) {
        this.parent = parent;
    }


    @Override
    public boolean addChild(LostChild<K> child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children.add(child);
    }

    public List<LostChild<K>> getChildren() {
        return children;
    }

    public LostChild<K> getParent() {
        return parent;
    }

    /**
     * 设置ID
     *
     * @param id
     */
    public abstract void setId(K id);

    /**
     * 设置父节点ID
     *
     * @param parentId
     */
    public abstract void setParentId(K parentId);
}

