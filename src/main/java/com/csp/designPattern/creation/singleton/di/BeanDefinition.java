package com.csp.designPattern.creation.singleton.di;

import java.util.ArrayList;
import java.util.List;

/**
 * @author csp
 * @date 2022/9/24
 */
public class BeanDefinition {

    private String id;

    private String className;

    private List<ConstructorArg> constructorArgs = new ArrayList<>();

    private Scope scope = Scope.SINGLETON;

    private boolean lazyInit = false;

    public boolean isSingleton() {
        return scope == Scope.SINGLETON;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<ConstructorArg> getConstructorArgs() {
        return constructorArgs;
    }

    public void setConstructorArgs(List<ConstructorArg> constructorArgs) {
        this.constructorArgs = constructorArgs;
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope scope) {
        this.scope = scope;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public static class ConstructorArg {

        private boolean ref;

        private Class<?> type;

        private Object arg;

        public boolean isRef() {
            return ref;
        }

        public void setRef(boolean ref) {
            this.ref = ref;
        }

        public Class<?> getType() {
            return type;
        }

        public void setType(Class<?> type) {
            this.type = type;
        }

        public Object getArg() {
            return arg;
        }

        public void setArg(Object arg) {
            this.arg = arg;
        }
    }

    public enum Scope {
        SINGLETON, PROTOTYPE
    }

}
