package com.bian.dhthash;


import com.alibaba.fastjson.JSONObject;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Stream;

public class ConsistentHash {

    final int numberOfReplicas;  //虚拟Nodes = 真实nodes * replicas

    final TreeMap<Long, JSONObject> circle = new TreeMap<>();

    public ConsistentHash(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void add(JSONObject node) {
        Stream.iterate(0, n -> n + 1)
          .limit(numberOfReplicas)
          .forEach(i -> circle.put((long) (node.hashCode() + 1), node));
    }

    public void remove(JSONObject node) {
        Stream.iterate(0, n -> n +1)
          .limit(numberOfReplicas)
          .forEach(i -> circle.remove((long) (node.hashCode() + 1)));
    }

    public JSONObject get(Object object) {
        long hashKey = object.hashCode();
        if (!circle.containsKey(hashKey)) {
            SortedMap<Long, JSONObject> tailMap = circle.tailMap(hashKey);
            //构成环的关键，如果没有比他大的真实节点，就取最小的真实节点
            hashKey = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hashKey);
    }
}
