package com.weweibuy.framework.rocketmq.annotation;

import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO 支持配置文件信息
 *
 * @author durenhao
 * @date 2020/1/4 17:13
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface RocketListener {

    String name() default "";

    String topic();

    String group();

    boolean orderly() default false;

    long timeout() default 30000L;

    int maxRetry() default 16;

    int threadMin() default 10;

    int threadMax() default 10;

    int consumeMessageBatchMaxSize() default 1;

    /**
     * 消费模式
     *
     * @return
     */
    MessageModel messageModel() default MessageModel.CLUSTERING;
}
