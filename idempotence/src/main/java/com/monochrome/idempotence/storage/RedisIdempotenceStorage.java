package com.monochrome.idempotence.storage;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author monochrome
 * @date 2022/10/26
 */
public class RedisIdempotenceStorage implements IdempotenceStorage{

    private JedisCluster jedisCluster;

    /**
     * Constructor
     * @param redisClusterAddress the format is 128.91.12.1:3455;128.91.12.2:3452;289.13.2.12:8978
     * @param config should not be null
     */
    public RedisIdempotenceStorage(String redisClusterAddress, GenericObjectPoolConfig config) {
        Set<HostAndPort> redisNodes = parseHostAndPorts(redisClusterAddress);
        this.jedisCluster = new JedisCluster(redisNodes, config);
    }

    protected Set<HostAndPort> parseHostAndPorts(String redisClusterAddress) {
        String[] addressArray= redisClusterAddress.split(";");
        Set<HostAndPort> redisNodes = new HashSet<>();
        for (String address : addressArray) {
            String[] hostAndPort = address.split(":");
            redisNodes.add(new HostAndPort(hostAndPort[0], Integer.valueOf(hostAndPort[1])));
        }
        return redisNodes;
    }

    /**
     *  Save { @idempotenceId } into storage if it does not exist.
     * @param idempotenceId 幂等ID
     * @return true if the { @idempotenceId } is saved, otherwise return false
     */
    @Override
    public boolean saveIfAbsent(String idempotenceId) {
        long result = jedisCluster.setnx(idempotenceId, "1");
        return 1 == result;
    }

    @Override
    public void delete(String idempotenceId) {
        jedisCluster.del(idempotenceId);
    }
}
