package list;

import java.util.Arrays;

public class MyArrayList implements List {
    private int[] array=null;
    private int size=0;
    public void ensureCapacity(){
        //如果容量足够,直接返回
        if(array!=null&&size<array.length){
            return;
        }
        //计算新的容量大小
        int capacity;
        if(array==null){
            capacity=10;
        }else{
            capacity=2*array.length;
        }
        //申请新的空间-搬家-发朋友圈
        if(array!=null){
            array= Arrays.copyOf(array,capacity);
        }else{
            array=new int[capacity];
        }
    }

    @Override
    public boolean add(int element) {
        array[size++]=element;
        return false;
    }

    @Override
    public boolean add(int index, int element) {
        //下标检查
        if(index<0||index>size){
            System.out.println("下表错误");
            return false;
        }
        //确保空间够用
        ensureCapacity();
        //为index下标,腾位置出来
        System.arraycopy(array,index,array,index+1,size-index);
        //插入
        array[index]=element;
        //变更长度
        size++;
        return true;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public int set(int index, int val) {
        return array[index]=val;
    }

    @Override
    public int remove(int index) {
        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];
        }
        size--;
        return array[index];
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
