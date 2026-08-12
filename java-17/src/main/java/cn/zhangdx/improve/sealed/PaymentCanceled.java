package cn.zhangdx.improve.sealed;

/**
 * sealed修饰的子类，需要继续声明子类继承边界。
 * @author zhangdx
 * @date 2026/8/12 11:52
 */
public sealed class PaymentCanceled implements PaymentResult permits ProactivePaymentCanceled {
}
