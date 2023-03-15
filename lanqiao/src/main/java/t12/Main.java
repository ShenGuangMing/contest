package t12;


import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<List<Integer>> res = new ArrayList<>();
    private boolean[] visit;
    private int len, end;
    private static int count = 0, result, resultCount = 0;

    public static void main(String[] args) {
        Main main = new Main();
        result = 136;

        main.process(7, 7);
        System.out.println("res.size = " + res.size());
        System.out.println("count = " + count);
        System.out.println("resultCount = " + resultCount);
    }


    public void process(int len, int end) {
        this.len = len;
        this.end = end;
        visit = new boolean[10];
        full(0, new ArrayList<>());
        for (List<Integer> re : res) {
            if (re.get(0) - re.get(3) < 0){
                continue;
            }
            int x = re.get(0) * 100 + re.get(1) * 10 + re.get(2);
            int y = re.get(3) * 100 + re.get(4) * 10 + re.get(5);
            if ((x - y) * re.get(6) == result) {
                System.out.println(re);
                resultCount++;
            }
        }
    }
    public void full(int index, List<Integer> list) {
        if (index == len) {
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i <= end; i++) {
            if ((index % 3 == 0) && i == 0 || visit[i]) {
                continue;
            }else if (index == 0 && i == 1) {
                continue;
            }else if (index == 3 && (i > list.get(0))) {
                return;
            }else if (index == 3 && (list.get(0) - i > (result / 100 + 1))) {
                continue;
            }else if (index == 6 && result % i != 0) {
                return;
            }
            count++;
            visit[i] = true;
            list.add(i);
            full(index+1, list);
            visit[i] = false;
            list.remove(list.size()-1);
        }
    }

}
