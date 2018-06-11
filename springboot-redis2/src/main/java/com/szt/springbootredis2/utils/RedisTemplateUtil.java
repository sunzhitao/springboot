package com.szt.springbootredis2.utils;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisTemplateUtil {

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    public void set(final String key, final String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String get(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public String getset(final String key, final String value) {
        return redisTemplate.opsForValue().getAndSet(key, value);
    }

    public Long incr(final String key, final long delta) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public void setex(final String key, final int seconds, final String value) {
        redisTemplate.opsForValue().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public Boolean setnx(final String key, final String value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    public Boolean expire(final String key, final int seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public long ttl(final String key) {
        return redisTemplate.getExpire(key);
    }

    public void del(final String key) {
        redisTemplate.delete(key);
    }

    public void hset(final String key, final String field, final String value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public Boolean hasKey(final String key, final String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public Long hdel(String key, String hashKey) {
        return redisTemplate.opsForHash().delete(key, hashKey);
    }

    public Long hlen(final String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public Object hget(final String key, final String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public Map<Object, Object> hgetAll(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public Boolean zadd(final String key, final double score, final String member) {
        return redisTemplate.opsForZSet().add(key, member, score);
    }

    public Set<TypedTuple<String>> zrevrangeWithScores(final String key) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, 0, -1);
    }

    public Set<TypedTuple<String>> zrangeByScoreWithScores(final String key, final double min, final double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    public Set<String> zrevrange(final String key) {
        return redisTemplate.opsForZSet().reverseRange(key, 0, -1);
    }

    public Double zincrby(final String key, final Double score, final String member) {
        return redisTemplate.opsForZSet().incrementScore(key, member, score);
    }

    public Long zrem(final String key, Object... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    public Long zremRangeByScore(final String key, final double min, final double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    public Long llen(final String key) {
        return redisTemplate.opsForList().size(key);
    }

    public Long lpush(final String key, final String... strings) {
        return redisTemplate.opsForList().leftPushAll(key, strings);
    }

    /**
     * 移除并返回列表 key 的尾元素。
     *
     * @param key
     * @return
     */
    public String rpop(final String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    public String brpop(final String key) {
        return redisTemplate.opsForList().rightPop(key, 0, TimeUnit.SECONDS);
    }

    /**
     * 获取分布式锁
     *
     * @param lockKey  key
     * @param locktime 锁有效时间
     * @return
     */
    public boolean getLock(String lockKey, int locktime) {
        long expires = System.currentTimeMillis() + locktime * 1000 + 1;
        String expiresStr = String.valueOf(expires); // 锁到期时间
        if (this.setnx(lockKey, expiresStr)) {
            return true;
        }
        String currentValueStr = get(lockKey); // redis里的时间
        if (StringUtils.isNotEmpty(currentValueStr)
                && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {// 其他线程获取的锁超时
            // 获取上一个锁到期时间，并设置现在的锁到期时间
            // 只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
            String oldValueStr = getset(lockKey, expiresStr);
            if (StringUtils.isNotEmpty(oldValueStr) && oldValueStr.equals(currentValueStr)) {
                // 如果多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                return true;
            }
        }
        return false;
    }
}
