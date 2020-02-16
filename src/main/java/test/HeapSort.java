package test;

/**
 * 注释:堆排序
 *
 * @Author moinros
 * @Date 2020/2/16 3:00
 * @Verison 1.0
 */
public class HeapSort {

    /*返回父节点*/
    int parent(int i) {
        return (int) ((i - 1) / 2);
    }

    /*返回左孩子节点*/
    int left(int i) {
        return (2 * i + 1);
    }

    /*返回右孩子节点*/
    int right(int i) {
        return (2 * i + 2);
    }

    /*对以某一节点为根的子树做堆调整(保证最大堆性质)*/
    void HeapAdjust(int A[], int i, int heap_size) {
        int l = left(i);
        int r = right(i);
        int largest;
        int temp;
        if (l < heap_size && A[l] > A[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r < heap_size && A[r] > A[largest]) {
            largest = r;
        }
        if (largest != i) {
            temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;
            HeapAdjust(A, largest, heap_size);
        }
    }

    /*建立最大堆*/
    void BuildHeap(int A[], int heap_size) {
        for (int i = (heap_size - 2) / 2; i >= 0; i--) {
            HeapAdjust(A, i, heap_size);
        }
    }

    /*输出结果*/
    void print(int A[], int heap_size) {
        for (int i = 0; i < heap_size; i++) {
            System.out.printf("%d ", A[i]);
        }
        System.out.printf("\n");
    }

    /*堆排序*/
    void sort(int A[], int heap_size) {
        BuildHeap(A, heap_size);
        int temp;
        for (int i = heap_size - 1; i >= 0; i--) {
            temp = A[0];
            A[0] = A[i];
            A[i] = temp;
            HeapAdjust(A, 0, i);
        }
        print(A, heap_size);
    }

    public static void main(String[] args) {
        int[] A = {19, 1, 10, 14, 16, 4, 7, 9, 3, 2, 8, 5, 11};
        HeapSort h = new HeapSort();
        h.sort(A, A.length);
    }
}
