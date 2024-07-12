package leetcode.a800;

public class Pair<T1, T2> {

    T1 key;
    T2 value;

    public Pair(T1 i, T2 j) {
        key = i;
        value = j;
    }

    public T1 getKey() {
       return key;
    }

    public T2 getValue(){
        return value;
    }

}
