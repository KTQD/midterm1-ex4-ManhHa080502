public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};

        // Tạo và khởi chạy luồng tính tổng
        Thread sumThread = new Thread(new SumThread(numbers));
        sumThread.start();

        // Tạo và khởi chạy luồng tìm phần tử lớn nhất
        Thread maxThread = new Thread(new MaxThread(numbers));
        maxThread.start();
    }
}

class SumThread implements Runnable {
    private int[] numbers;

    public SumThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Tồng các phần tử: " + sum);
    }
}

class MaxThread implements Runnable {
    private int[] numbers;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int max = Integer.MIN_VALUE;
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Phần tử lớn nhất: " + max);
    }
}
