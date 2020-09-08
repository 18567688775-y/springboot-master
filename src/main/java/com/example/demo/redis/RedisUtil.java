package com.example.demo.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 *  Redis 工具类
 */
@Component
public final class RedisUtil {

  @Autowired
  private RedisTemplate<String,Object> redisTemplate;


  /**
   * 指定缓存失效时间
   * @Param key 键
   * @Param time 时间（秒）
   */
  public boolean expire(String key,long time){
    try {
      if(time>0){
        redisTemplate.expire(key,time, TimeUnit.SECONDS);
      }
      return true;
    }catch(Exception e){
      e.printStackTrace();
      return false;
    }
  }

  /**
   *    获取过期时间
   * @param key  键
   * @return
   */
  public long getExpire(String key){
    return redisTemplate.getExpire(key,TimeUnit.SECONDS);
  }

  /**
   *  判断key是否存在
   * @param key  键
   * @return
   */
  public boolean hasKey(String key){
    try {
      return redisTemplate.hasKey(key);
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }

  /**
   * 删除缓存
   * @param key 可以传一个值或者多个
   */
  @SuppressWarnings("unchecked")
  public void del(String... key){
    if(key != null && key.length > 0){
      if(key.length==1){
        redisTemplate.delete(key[0]);
      }else{
        redisTemplate.delete(CollectionUtils.arrayToList(key));
      }
    }
  }

  //========================== String ================================

  /**
   *普通缓存获取
   * @param key 键
   * @return 值
   */
  public Object get(String key){
    return key ==null?null:redisTemplate.opsForValue().get(key);
  }

  /**
   *  普通缓存放入
   * @param key   键
   * @param value  值
   * @return
   */
  public boolean set(String key,Object value){
    try{
      redisTemplate.opsForValue().set(key,value);
      return true;
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }
  }
}
