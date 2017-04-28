package week4;

/**
 * Created by sheeran on 2017/3/29.
 */
public class UnOrderSymbolTable <Key,Value>{
    private ST<Key,Value> node;
    private class ST<Key,Value>{
        Key key;
        Value value;
        ST prev;
    }
    public void put(Key key,Value value){
        ST<Key,Value> old=node;
        node.key=key;
        node.value=value;
        node.prev=old;
    }
    public Value get(Key key){
        if(key==null) throw new IllegalArgumentException();
        if(node==null) return null;
        ST<Key,Value> st=node;
        while(st.prev!=null){
            if(st.key.equals(key))
                break;
            st=node.prev;
        }
        if(st.value!=null) return st.value;
        return null;
    }
}
