package com.csp.designPattern.struct.composite.template;

/**
 * @author csp
 * @date 2022/9/18
 */
public abstract class Component {
    /**
     * 增加成员
     *
     * @param component
     */
    protected abstract void add(Component component);

    /**
     * 删除成员
     *
     * @param component
     */
    protected abstract void remove(Component component);

    /**
     * 获取成员
     *
     * @param index
     * @return
     */
    protected abstract Component getChild(int index);

    /**
     * 业务方法
     */
    protected abstract void operation();
}
