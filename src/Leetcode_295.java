import java.util.*;

class App {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println("median of stream : "+medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println("median of stream : "+medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println("median of stream : "+medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println("median of stream : "+medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println("median of stream : "+medianFinder.findMedian());
    }
}
class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap;
    private PriorityQueue<Integer> rightMinHeap;
    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>((a,b)->b-a);
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(leftMaxHeap.isEmpty()) leftMaxHeap.offer(num);
        else if (num >= leftMaxHeap.peek()){//ascending sequence
            rightMinHeap.offer(num);
            if (rightMinHeap.size()>leftMaxHeap.size()) leftMaxHeap.offer(rightMinHeap.poll());
        }else {//descending sequence
            leftMaxHeap.offer(num);
            if (leftMaxHeap.size()-rightMinHeap.size() > 1) rightMinHeap.offer(leftMaxHeap.poll());
        }
    }

//    public void addNum(int num) {
//        leftMaxHeap.offer(num);
//        rightMinHeap.offer(leftMaxHeap.poll());
//        if (rightMinHeap.size() > leftMaxHeap.size())
//            leftMaxHeap.offer(rightMinHeap.poll());
//    }
    public double findMedian() {
        if(leftMaxHeap.size()>rightMinHeap.size()) return leftMaxHeap.peek();
        return (leftMaxHeap.peek()+ rightMinHeap.peek())/2.0;
    }
}
