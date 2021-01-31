package amazon;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CutTreeGolfProblem {

        public int cutOffTree(List<List<Integer>> forest) {

            int steps = 0;
            if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
                return -1;
            }

            if (forest.get(0).get(0) == 0) {
                return -1;
            }
            boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
            PriorityQueue<QItem> queue = new PriorityQueue<QItem>(new Comparator<QItem>() {
                @Override
                public int compare(QItem o1, QItem o2) {
                    if (o1.size <= o2.size) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            });
           // int row = 0;
            //int col = 0;
            queue.add(new QItem(0, 0, forest.get(0).get(0)));
            System.out.println("adding to queue::" + forest.get(0).get(0) + " Size of queue::" + queue.size());


            while (!queue.isEmpty()) {

                for (int i = 0; i < queue.size(); i++) {

                    QItem tree = queue.poll();
                    System.out.println("poll Queue::" + tree.size);

                    if (!visited[tree.row][tree.col]) {

                        visited[tree.row][tree.col] = true;

                        steps += tree.addSteps();
                        if (isValid(tree.row - 1, tree.col, forest, tree.size)) {
                            queue.add(new QItem(tree.row - 1, tree.col, forest.get(tree.row-1).get(tree.col)));
                        }
                        if (isValid(tree.row + 1, tree.col, forest, tree.size)) {
                            queue.add(new QItem(tree.row + 1, tree.col, forest.get(tree.row+1).get(tree.col)));
                        }
                        if (isValid(tree.row, tree.col - 1, forest, tree.size)) {
                            queue.add(new QItem(tree.row, tree.col - 1, forest.get(tree.row).get(tree.col-1)));
                        }
                        if (isValid(tree.row, tree.col + 1, forest, tree.size)) {
                            queue.add(new QItem(tree.row, tree.col + 1, forest.get(tree.row).get(tree.col+1)));
                        }


                    }
                }

            }
            return steps;
        }

        public boolean isValid(int row, int col, List<List<Integer>> forest, int prevTree) {
            if (row < 0 || col < 0 || row >= forest.size() || col >= forest.get(0).size() || forest.get(row).get(col) == 0 || prevTree > forest.get(row).get(col)) {
                return false;
            }
            return true;
        }

        class QItem {
            int row;
            int col;
            int size;
            int steps;

            public QItem(int row, int col, int size) {
                this.row = row;
                this.col = col;
                this.size = size;
                this.steps = 0;
            }

            public int addSteps() {
                steps++;
                return steps;
            }
        }
    public static void main(String[] args){
            List<Integer> l1 = new ArrayList<>();
            l1.add(1);
            l1.add(2);
            l1.add(3);

        List<Integer> l2 = new ArrayList<>();
        l2.add(0);
        l2.add(0);
        l2.add(4);

        List<Integer> l3 = new ArrayList<>();
        l3.add(7);
        l3.add(6);
        l3.add(5);

        List<List<Integer>> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        CutTreeGolfProblem c = new CutTreeGolfProblem();
        c.cutOffTree(list);
    }
}