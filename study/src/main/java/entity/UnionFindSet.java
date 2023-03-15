package entity;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

class Element<V> {
    V v;
    public Element(V v) {
        this.v = v;
    }
}
public class UnionFindSet<V> {
    public HashMap<V, Element<V>> elementMap;       //每个V都包一层
    public HashMap<Element<V>, Element<V>> fatherMap;  //key:某个元素, value:该元素的父元素
    public HashMap<Element<V>, Integer> sizeMap;    //key:记录每个集合代表元素， vale:该集合的大小
    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V v : list) {
            Element<V> element = new Element<>(v);
            elementMap.put(v, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }
    public Element<V> findHead(Element<V> element) {
        Stack<Element<V>> stack = new Stack<>();//记录一路的所有父节点
        while (element != fatherMap.get(element)) {//当前节点不等于父节点
            stack.push(element);//当前节点入栈
            element = fatherMap.get(element);//当前节点从新赋值为当前节点的父节点
        }
        while (!stack.isEmpty()) {
            fatherMap.put(stack.pop(), element);
        }
        return element;
    }
    public boolean isSameSet(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }
    public void union(V a, V b) {
        if (!elementMap.containsKey(a) || !elementMap.containsKey(b)) //如果a和b两个元素都不存在就不进行合并了
            return;
        Element<V> aF = findHead(elementMap.get(a));//找到a的顶端元素af
        Element<V> bF = findHead(elementMap.get(a));//找到b的顶端元素bf
        if (aF != bF) { //两个顶端元素不是同一个，说明是两个集合，合并
            Element<V> big = sizeMap.get(aF) >= sizeMap.get(bF) ? aF : bF;//找到长度更长的那个集合
            Element<V> small = big == aF ? bF : aF;
            fatherMap.put(small, big);//将小集合代表节点挂到大节点代表节点下
            sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));//更新大小
            sizeMap.remove(small);//删除小集合的大小
        }
    }
}

