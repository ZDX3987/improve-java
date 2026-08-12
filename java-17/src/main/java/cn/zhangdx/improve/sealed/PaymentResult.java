package cn.zhangdx.improve.sealed;

/**
 * 通过限制子类继承权限，让编译期知道类型的所以可能子类形态，知道子类能力边界。
 * 子类必须由final/sealed/non-sealed三种修饰。
 * @author zhangdx
 * @date 2026/8/12 11:40
 */
public sealed interface PaymentResult permits PaymentCanceled, PaymentFailure, PaymentSuccess {
}