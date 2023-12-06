import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class LC_853 {
    // https://leetcode.com/problems/car-fleet/

    class Solution {
        class Car {
            private int position;
            private int speed;
            private float time;

            Car(int position, int speed, float time) {
                this.position = position;
                this.speed = speed;
                this.time = time;
            }

            public int getPosition() {
                return position;
            }

            public int getSpeed() {
                return speed;
            }

            public float getTime() {
                return time;
            }

            @Override
            public String toString() {
                return "(" + position + ", " + speed + ", " + time + ")";
            }
        }

        public <T> void print(T t) {
            System.out.println(t);
        }

        public void pushInStack(Car car, Deque<Car> stack) {
            if (stack.size() == 0)
                stack.push(car);
            else {
                if (stack.peekFirst().getTime() > car.getTime())
                    stack.push(car);
                else {
                    stack.pop();
                    pushInStack(car, stack);
                }
            }
        }

        public int carFleet(int target, int[] position, int[] speed) {
            List<Car> cars = new ArrayList<>();

            for (int i = 0; i < position.length; i++) {
                float time = (float) (target - position[i]) / (float) speed[i];
                cars.add(new Car(position[i], speed[i], time));
            }

            Collections.sort(cars, (a, b) -> a.getPosition() - b.getPosition());

            Deque<Car> stack = new ArrayDeque<>();

            for (Car car : cars) {
                pushInStack(car, stack);
            }

            return stack.size();
        }
    }

    public static final <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Solution solution = new LC_853().new Solution();
        print(solution.carFleet(12, new int[] { 10, 8, 0, 5, 3 }, new int[] { 2, 4,
                1, 1, 3 }));
        print(solution.carFleet(13, new int[] { 10, 2, 5, 7, 4, 6, 11 }, new int[] {
                7, 5, 10, 5, 9, 4, 1 }));
    }
}
