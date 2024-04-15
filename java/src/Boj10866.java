import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class Boj10866 {

    public static void main(String[] args) {
        int n = Console.nextInt();
        Dequeue dequeue = new Dequeue();
        for (int i = 0; i < n; i++) {
            String[] input = Console.readLine().split(" ");
            String command = input[0];
            int value;
            try {
                value = Integer.parseInt(input[1]);
            } catch (ArrayIndexOutOfBoundsException e) {
                value = -1;
            }

            Command.doAction(command, dequeue, value);
        }
    }

    enum Command {

        PUSH_FRONT(
                "push_front",
                (dequeue, value) -> {
                    dequeue.pushFront(value);
                }
        ),
        PUSH_BACK(
                "push_back",
                (dequeue, value) -> {
                    dequeue.pushBack(value);
                }
        ),
        POP_FRONT(
                "pop_front",
                (dequeue, value) -> {
                    System.out.println(dequeue.popFront());
                }
        ),
        POP_BACK(
                "pop_back",
                (dequeue, value) -> {
                    System.out.println(dequeue.popBack());
                }
        ),
        SIZE(
                "size",
                (dequeue, value) -> {
                    System.out.println(dequeue.size());
                }
        ),
        EMPTY(
                "empty",
                (dequeue, value) -> {
                    if (dequeue.empty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                }
        ),
        FRONT(
                "front",
                (dequeue, value) -> {
                    System.out.println(dequeue.front());
                }
        ),
        BACK(
                "back",
                (dequeue, value) -> {
                    System.out.println(dequeue.back());
                }
        );

        Command(String value, BiConsumer<Dequeue, Integer> action) {
            this.value = value;
            this.action = action;
        }

        private final String value;
        private final BiConsumer<Dequeue, Integer> action;

        public static void doAction(String rawCommand, Dequeue dequeue, int value) {
            Command command = Arrays.stream(values())
                    .filter(it -> it.value.equals(rawCommand))
                    .findFirst()
                    .orElseThrow(RuntimeException::new);

            command.action.accept(dequeue, value);
        }
    }

    static class Dequeue {
        private final List<Integer> dequeue;

        Dequeue() {
            this.dequeue = new LinkedList<>();
        }

        public void pushFront(int value) {
            dequeue.add(0, value);
        }

        public void pushBack(int value) {
            dequeue.add(value);
        }

        public int popFront() {
            try {
                return dequeue.remove(0);
            } catch (IndexOutOfBoundsException e) {
                return -1;
            }
        }

        public int popBack() {
            try {
                return dequeue.remove(size() - 1);
            } catch (IndexOutOfBoundsException e) {
                return -1;
            }
        }

        public int size() {
            return dequeue.size();
        }

        public boolean empty() {
            return this.size() == 0;
        }

        public int front() {
            try {
                return dequeue.get(0);
            } catch (IndexOutOfBoundsException e) {
                return -1;
            }
        }

        public int back() {
            try {
                return dequeue.get(size() - 1);
            } catch (IndexOutOfBoundsException e) {
                return -1;
            }
        }
    }

    public static void displayResult(int answer) {
        System.out.println(answer);
    }

    public static class Console {

        private final static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public static int nextInt() {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
