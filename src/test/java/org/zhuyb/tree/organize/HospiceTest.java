package org.zhuyb.tree.organize;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @user zyb
 * @date 2019/2/26
 */
public class HospiceTest {

    @Test
    public void childJoin() throws Exception {
        Hospice<Long> hospice = new Hospice<>(3000);
        List<AbstractLostChild<Long>> longLostChildren = new ArrayList<>();
        for (long i = 1; i < 3000; i++) {
            LongLostChild longLostChild = new LongLostChild(i, i / 10);
            longLostChildren.add(longLostChild);
            hospice.childJoin(longLostChild);
        }
        for (AbstractLostChild<Long> longLostChild : longLostChildren) {
            printChildren(longLostChild);
        }
    }

    private void printChildren(AbstractLostChild<Long> parent) {
        List<LostChild<Long>> lostChildren = parent.getChildren();
        if (lostChildren != null) {
            StringBuffer childrenId = new StringBuffer();
            for (LostChild<Long> lostChild : lostChildren) {
                childrenId.append(lostChild.id()).append(",");
            }
            System.out.printf("parent %d children{%s}%n", parent.id(), childrenId.toString());
        } else {
            System.out.printf("parent %d no children%n", parent.id());
        }
    }

    public static class LongLostChild extends AbstractLostChild<Long> {
        public LongLostChild(Long id, Long parentId) {
            setId(id);
            setParentId(parentId);
        }

        @Override
        public void setId(Long id) {
            this.id = id;
        }

        @Override
        public void setParentId(Long parentId) {
            this.parentId = parentId;
        }
    }

}
