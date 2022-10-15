package com.csp.designPattern.struct.composite.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/18
 */
public class Composite extends Component {

    private List<Component> list = new ArrayList<>();

    @Override
    protected void add(Component component) {

    }

    @Override
    protected void remove(Component component) {
        list.remove(component);
    }

    @Override
    protected Component getChild(int index) {
        return list.get(index);
    }

    @Override
    protected void operation() {
        // 递归调用成员构建的业务方法
        for (Component ct : list) {
            ct.operation();
        }
    }
}
