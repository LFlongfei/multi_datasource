package com.longfei.multi_datasource.multi;

/**
 * @author wei
 * @date 2020/9/5 10:10 下午
 */
public class DynamicDataSourceContextHolder {

    /**
     * 使用ThreadLocal维护变量，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程
     * 都可以独立的改变自己的副本，而不会影响其他线程对应的副本
     */
    private static final ThreadLocal<String> CONTEXT_HOLDER = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dataSourceType 数据源类型
     */
    public static void setDataSourceType(String dataSourceType){
        System.out.printf("切换到数据源[%s]%n", dataSourceType);
        CONTEXT_HOLDER.set(dataSourceType);
    }

    /**
     * 获取数据源
     * @return
     */
    public static String getDataSourceType(){
        return CONTEXT_HOLDER.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }
}
