package com.sam.lib.utils;

import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisUtils {
    private final RedisTemplate redisTemplate;

    public RedisUtils(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return boolean
     */
    public boolean existsKey(final Object key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 根据key获取key列表(key值可为模糊匹配---taskInfo:taskDetail:* <---> *代表任意字符)
     *
     * @param pattern
     * @return Set<Object>
     */
    public Set<Object> keys(final Object pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * 根据key删除对应的value
     *
     * @param key
     */
    public boolean delete(final Object key) {
        return redisTemplate.delete(key);
    }

    /**
     * 根据key获取个数
     *
     * @param key
     */
    public int count(final Object key) {
        return redisTemplate.keys(key).size();
    }

    /**
     * 批量删除key(key值可为模糊匹配---taskInfo:taskDetail:* <---> *代表任意字符)
     *
     * @param pattern
     */
    public long deletePattern(final Object pattern) {
        Set<Object> keys = redisTemplate.keys(pattern);
        if ((keys != null ? keys.size() : 0) > 0) {
            return redisTemplate.delete(keys);
        } else {
            return 0;
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void delete(final String[] keys) {
        for (String key : keys) {
            delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public long delete(final Set<Object> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 写入缓存(操作字符串)
     *
     * @param key
     * @param value
     * @return boolean
     */
    public boolean vSet(final Object key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存设置时效时间(操作字符串)
     *
     * @param key
     * @param value
     * @return boolean
     */
    public boolean vSet(final Object key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新写入缓存设置时效时间(操作字符串)
     *
     * @param key
     * @return boolean
     */
    public boolean vSetUpdate(final Object key, Long expireTime) {
        boolean result = false;
        try {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 读取缓存(操作字符串)
     *
     * @param key
     * @return Object
     */
    public Object vGet(final Object key) {
        Object result = null;
        ValueOperations<Object, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 哈希 添加(操作hash)
     *
     * @param key
     * @param hashKey
     * @param value
     */
    public void hmSet(Object key, Object hashKey, Object value) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key, hashKey, value);
    }

    /**
     * 哈希 添加(操作hash)
     *
     * @param key
     * @param map
     */
    public void hmSetAll(Object key, Map<Object, Object> map) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        hash.putAll(key, map);
    }

    /**
     * 哈希获取数据(操作hash)
     *
     * @param key
     * @return Map<Object, Object>
     */
    public Map<Object, Object> hmGet(Object key) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.entries(key);
    }

    /**
     * 哈希获取数据(操作hash)
     *
     * @param key
     * @param hashKey
     * @return Object
     */
    public Object hmGet(Object key, Object hashKey) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.get(key, hashKey);
    }

    /**
     * 哈希删除数据(操作hash)
     *
     * @param key
     * @param hashKey
     * @return Object
     */
    public Object hmDel(Object key, Object hashKey) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        return hash.delete(key, hashKey);
    }

    /**
     * 获取列表中个数
     *
     * @param k
     * @return long
     */
    public long lSize(Object k) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.size(k);
    }

    /**
     * 根据key获取获取List列表(操作list)
     *
     * @param k
     * @return Object
     */
    public Object lRange(Object k) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.range(k, 0, list.size(k));
    }

    /**
     * 根据key获取列表中第start至end的数据(操作list)
     *
     * @param k
     * @param start
     * @param end
     * @return List<Object>
     */
    public List<?> lRange(Object k, long start, long end) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.range(k, start, end);
    }

    /**
     * 通过其索引从列表获取第一个元素(操作list)
     *
     * @param k
     * @return Object
     */
    public Object lindexFirst(Object k) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.index(k, 0);
    }

    /**
     * 通过其索引从列表获取元素(操作list)
     *
     * @param k
     * @param index:索引位置,从0开始
     * @return Object
     */
    public Object lindex(Object k, long index) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.index(k, index);
    }

    /**
     * 从左向右添加列表(操作list)
     *
     * @param k
     * @param v
     */
    public void lLeftPush(Object k, Object v) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        list.leftPush(k, v);
    }

    /**
     * 从左向右添加列表(操作list);如果bool=true,会删除列表中已经存在的数据,然后再进行添加(仅针对字符串列表,其它待测)
     *
     * @param k
     * @param v
     * @param bool
     */
    public void lLeftPush(Object k, Object v, boolean bool) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        if (bool) {
            list.remove(k, list.size(k), v);
        }
        list.leftPush(k, v);
    }

    /**
     * 从左向右添加列表(操作list)
     *
     * @param k
     * @param lst
     */
    public void lLeftPushAll(Object k, List<Object> lst) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        list.leftPushAll(k, lst);
    }

    /**
     * 从右向左添加列表(操作list);如果bool=true,会删除列表中已经存在的数据,然后再进行添加(仅针对字符串列表,其它待测)
     *
     * @param k
     * @param v
     * @param bool
     */
    public void lRightPush(Object k, Object v, boolean bool) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        if (bool) {
            list.remove(k, list.size(k), v);
        }
        list.rightPush(k, v);
    }

    /**
     * 从右向左添加列表(操作list)
     *
     * @param k
     * @param v
     */
    public void lRightPush(Object k, Object v) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        list.rightPush(k, v);
    }

    /**
     * 从右向左添加列表(操作list)
     *
     * @param k
     * @param lst
     */
    public void lRightPushAll(Object k, List<Object> lst) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        list.rightPushAll(k, lst);
    }

    /**
     * 删除并获取列表中的第1个元素(操作list)
     *
     * @param k
     * @return Object
     */
    public Object lLeftPop(Object k) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.leftPop(k);
    }

    /**
     * 删除并获取列表中的最后1个元素(操作list)
     *
     * @param k
     * @return Object
     */
    public Object lRightPop(Object k) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.rightPop(k);
    }

    /**
     * 移除k中的count个,返回删除的个数；如果没有这个元素则返回0(操作list)
     *
     * @param k
     * @param count
     * @return long
     */
    public long lRemove(Object k, long count) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.remove(k, 0, null);
    }

    /**
     * 移除k中值为v的count个,返回删除的个数；如果没有这个元素则返回0(操作list)
     *
     * @param k
     * @param count
     * @param v
     * @return long
     */
    public long lRemove(Object k, long count, Object v) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.remove(k, count, v);
    }

    /**
     * 移除k中值为v的所有数据,返回删除的个数；如果没有这个元素则返回0(操作list)
     *
     * @param k
     * @param v
     * @param v
     * @return long
     */
    public long lRemove(Object k, Object v) {
        ListOperations<Object, Object> list = redisTemplate.opsForList();
        return list.remove(k, list.size(k), v);
    }

    /**
     * 集合添加
     *
     * @param key
     * @param value
     */
    public void sAdd(Object key, Object value) {
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        set.add(key, value);
    }

    /**
     * 集合获取
     *
     * @param key
     * @return Set<Object>
     */
    public Set<Object> sMembers(Object key) {
        SetOperations<Object, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     *
     * @param key
     * @param value
     * @param scoure
     */
    public void zAdd(Object key, Object value, double scoure) {
        ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
        zset.add(key, value, scoure);
    }

    /**
     * 有序集合获取
     *
     * @param key
     * @param scoure
     * @param scoure1
     * @return Set<Object>
     */
    public Set<Object> rangeByScore(Object key, double scoure, double scoure1) {
        ZSetOperations<Object, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * 将hashKey中储存的数字加上指定的增量值(操作hash)
     *
     * @param key
     * @param value
     * @return boolean
     */
    public void hmSetIncrement(Object key, Object hashKey, Long value) {
        HashOperations<Object, Object, Object> hash = redisTemplate.opsForHash();
        hash.increment(key, hashKey, value);
    }
}