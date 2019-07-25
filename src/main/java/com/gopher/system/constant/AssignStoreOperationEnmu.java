package com.gopher.system.constant;

/**
 * @author 1500
 * @Date 2019/7/25.
 */
public enum AssignStoreOperationEnmu {
    /**
     * 分配
     */
    ASSIGN(1),
    /**
     * 取消
     */
    CANCEL(2);
    private Integer operation;

    AssignStoreOperationEnmu(Integer operation) {
        this.operation = operation;
    }

    /**
     * 根据code查询、验证操作是否正确
     * @param ope
     * @return
     */
    public static AssignStoreOperationEnmu getOperation(Integer ope) {
        if (ope == null) {
            return null;
        }
        for (AssignStoreOperationEnmu assignStoreOperationEnmu : AssignStoreOperationEnmu.values()) {
            if (assignStoreOperationEnmu.operation.equals(ope)) {
                return assignStoreOperationEnmu;
            }
        }
        return null;

    }

}
