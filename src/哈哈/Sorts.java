package 哈哈;

import java.util.Arrays;

public class Sorts {
    public  static void insertSort(int[] array){  //插入排序
        for(int i=0;i<array.length-1;i++){
            //有序区间   [0,i]
            //无需区间   [i+1,array.length)
            //待插入的数据是array[i+1]
            //插入过程在有序区间内查找
            int key=array[i+1];
            int j;
            for(j=i;j>=0;j--){
                if(key>=array[j]){
                    break;
                }
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
    }
    public static void shellSort(int[] array){   //希尔排序
      for(int gap=array.length/2;gap>0;gap=gap/2) {
          for (int i = gap; i < array.length; i++) {
              int j=i;
              while(j-gap>=0&&array[j]<array[j-gap]){
                  swap(array,j,j-gap);
                  j-=gap;
              }
          }
      }
    }
    public static void radixSort(int[] array){//基数排序
        int max=0;
        for (int i=0;i<array.length-1;i++){
            if(array[i]>=max){
                max=array[i];
            }
        }
        System.out.println(max);
        int sum=0;
        while(max!=0){
            max=max/10;
            sum++;
        }
        int[] count=new int[10];//记录k位[0~9]每个的个数
        int[] bucket=new int[array.length];//"桶子" 记录按K位排序后的数组
        for(int k=1;k<=sum;k++){
            //保证下一次循环上一次的数据清空
            for(int i=0;i<10;i++){
                count[i]=0;
            }
            //记录k位[0~9]每个的个数
            for(int i=0;i<array.length;i++){
                count[func(array[i],k)]++;
            }
            //这个循环用来判断一个数在bucket中的位置,例如:k=1时,也就是个位,array{11,2,23,4}
            // 则count经过这次循环变为{0,1,2,3,4,0,0,0,0,0},用23作为例子,个位为3,对应count
            //下标为3,对应的值为3,则说明23在bucket中位于第三个数,这里我也理解了好一会儿
            for(int i=1;i<10;i++){
                count[i]+=count[i-1];
            }
            //这个循环用来按K位排序
            for(int i=0;i<array.length;i++){
                int j=func(array[i],k);
                bucket[count[j]-1]=array[i];
                count[j]--;
            }
            //赋给原数组
            for(int i=0,j=0;i<array.length;i++,j++){
                array[i]=bucket[j];
            }
        }
    }
    public static int func(int a,int k){//基数排序中判断一个数K位的数
        int[] b={1,10,100,1000,10000};
        return (a/(b[k-1]))%10;
    }
    public static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
    public static void selectSort(int[] array) {  //选择排序
       for(int i=0;i<array.length-1;i++){
          int min=i;
          for(int j=i+1;j<array.length-1;j++){
              if(array[j]<array[min]){
                  min=j;
              }
          }
          swap(array,i,min);
       }
    }
   public static void heapSort(int[] array){ //堆排序
        int size=array.length;
        createHeap(array,size);//建堆过程
        while(size>1){
            swap(array,0,size-1);//拆堆决定最大的数,放在堆最后
            size--;
            createHeap(array,size);//前面的数进行堆重构
        }
    }
    public static void createHeap(int[] arr,int size){//建堆
        for(int i=(size-2)/2;i>=0;i--){
            heapity(arr,size,i);
        }
    }
    public static void heapity(int[] arr,int size,int index){
        while(true){
            int left=2*index+1;
            int right=2*index+2;
            if(left>=size){return;}
            int max=left;
            if(right<size){
                if(arr[right]>arr[left]){
                    max=right;
                }
            }
            if (arr[index]>=arr[max]){return;}
            swap(arr,index,max);
            index=max;
        }
    }
    public static void bubbleSort(int[] array){  //冒泡排序
        for(int i=0;i<array.length-1;i++){
            //无序区间[0,array.length-i]
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                  swap(array,j,j+1);
                }
            }
        }
    }
    public static void quickSort(int[] array,int left,int right){//快速排序
          int low=left;
          int high=right;
            int povit=array[left];//用来做对的基数
            int flag=left;//基数坐标
            while(low<high){
                while(low<high&&array[high]>=povit){//基数定义在左边,应该让右边先走
                    high--;
                }
                while(low<high&&array[low]<=povit){
                    low++;
                }
                swap(array,low,high);
            }
            swap(array,flag,low);
        int pos=low;
        if(low-1>left){
            quickSort(array, left, pos - 1);
        }
        if(high+1<right){
            quickSort(array, pos + 1, right);
        }
    }


   public static void ensureCapacity(int[] array){
        int[] temp=new int[array.length];  //提前创建好新的数组保存数据,避免递归重复创建
        mergeSort(array,0,array.length-1,temp);

   }
    public static void mergeSort(int[] array,int left,int right,int[] temp){
        if(left<right){
            int mid=(left+right)/2;
            mergeSort(array,left,mid,temp);//左边归并排序
            mergeSort(array,mid+1,right,temp);//右边归并排序
            mergeInternal(array,left,mid,right,temp);//两边归并后拼接起来,并赋给原来的数组
        }
    }
    public static void mergeInternal(int[] array,int left,int mid,int right,int[] temp){
        int low=left;
        int high=mid+1;
        int t=0;
        while(low<=mid&&high<=right){//两个子序列的第一个元素进行比较,谁小谁进新创建的数组
            if(array[low]<array[high]){
                temp[t]=array[low];
                t++;
                low++;
            }else{
                temp[t]=array[high];
                t++;
                high++;
            }
        }
        while(low<=mid){//右边的元素先一步全进新建的数组,只剩下左边的元素
            temp[t]=array[low];
            t++;
            low++;
        }
        while(high<=right){//左边的元素先一步全进新建的数组,只剩下右边的元素
            temp[t]=array[high];
            t++;
            high++;
        }
        t=0;
        while(left<=right){
            array[left]=temp[t];
            left++;
            t++;
        }
    }
    public static void main(String[] args) {
        int[] arr={5,3,7,4,8};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
