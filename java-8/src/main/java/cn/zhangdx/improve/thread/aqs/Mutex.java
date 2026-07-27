package cn.zhangdx.improve.thread.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 自定义同步组件Mutex。
 * 实现Lock接口，内部基于AQS基础同步组件实现
 * @author ZDX
 * @date 2025/10/27 12:13
 */
public class Mutex implements Lock {

    private boolean isShareLock;

    private final Sync sync;

    public Mutex() {
        sync = new Sync(0);
    }

    public Mutex(boolean isShareLock, int shareCount) {
        this.isShareLock = isShareLock;
        sync = new Sync(shareCount);
    }

    private static class Sync extends AbstractQueuedSynchronizer {

        private Sync(int count) {
            this.setState(count);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if (getState() == 0) {
                throw new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean tryAcquire(int arg) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            int s = getState();
            if (s == 0) {
                return -1;
            }
            return compareAndSetState(s, s - arg) ? 1 : -1;
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            int s = getState();
            boolean b = compareAndSetState(s, s + arg);
            return b;
        }

        Condition newCondition() {
            return new ConditionObject();
        }
    }

    @Override
    public void lock() {
        if (isShareLock) {
            sync.acquireShared(1);
        } else {
            sync.acquire(1);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1, unit.toNanos(time));
    }

    @Override
    public void unlock() {
        if (isShareLock) {
            sync.releaseShared(1);
        } else {
            sync.release(1);
        }
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
