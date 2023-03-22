package main.kontur;

import java.util.*;

import static java.lang.Math.max;

public class Playground {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 3≤n,m≤500
        String commandLine = scan.nextLine();
        String[] tokens = commandLine.split("\\s+", 2);
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);
        ArrayList<char[]> cellRows = new ArrayList<>();

        // true - free
        int[][] plots = new int[n][m];
        for (int i = 0; i < n; i++) {
            cellRows.add(scan.nextLine().toCharArray());
        }
        // Формируем матрицу квартала
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = cellRows.get(i)[j];
                if(c == '.'){
                    // free
                    plots[i][j] = 1;
                   /* if(!playgroundOptions.isEmpty()){
                        playgroundOptions.add(new PlotFree(new ArrayList<>(i), new ArrayList<>(j)));
                    } else {
                    }*/

                } else {
                    // busy
                    plots[i][j] = 0;
                }
            }
        }
        Vector<Integer> d = new Vector(m);
        for (int i = 0; i < m; i++) {
            d.add(i, -1);
        }
        Vector<Integer> d1 = new Vector(m);
        Vector<Integer> d2 = new Vector(m);
        Stack<Integer> st = new Stack<>();
        int ans = 0;
    // Нахожденеие прямоугольника максимальной площади
        for (int i=0; i<n; ++i) {
            for (int j=0; j<m; ++j)
                if (plots[i][j] == 1)
                    d.add(j, i);
            while (!st.empty()) st.pop();
            for (int j=0; j<m; ++j) {
                while (!st.empty() && d.get(st.peek()) <= d.get(j))  st.pop();
                d1.add(j, st.empty() ? -1 : st.peek());
//                d1.add(j, st.empty() ? 0 : st.peek());
                st.push (j);
            }
            while (!st.empty()) st.pop();
            for (int j=m-1; j>=0; --j) {
                while (!st.empty() && d.get(st.peek()) <= d.get(j))  st.pop();
                d2.add(j, st.empty() ? m : st.peek());
                st.push (j);
            }
            for (int j=0; j<m; ++j)
                ans = max (ans, (i - d.get(j)) * (d2.get(j) - d1.get(j) - 1));
        }
        System.out.println(ans);

        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(plots[i][j]);
            }
            System.out.println();
        }*/

    }

    public static class PlotFree {
        ArrayList<Integer> xFromNs;
        ArrayList<Integer> yFromMs;

        public PlotFree(ArrayList<Integer> xFromNs, ArrayList<Integer> yFromMs) {
            this.xFromNs = xFromNs;
            this.yFromMs = yFromMs;
        }

        public ArrayList<Integer> getxFromNs() {
            return xFromNs;
        }

        public void setxFromNs(ArrayList<Integer> xFromNs) {
            this.xFromNs = xFromNs;
        }

        public ArrayList<Integer> getyFromMs() {
            return yFromMs;
        }

        public void setyFromMs(ArrayList<Integer> yFromMs) {
            this.yFromMs = yFromMs;
        }
    }

    public static class Plot {
        int xFromN;
        int yFromM;
        boolean free;

        public Plot(int xFromN, int yFromM, boolean free) {
            this.xFromN = xFromN;
            this.yFromM = yFromM;
            this.free = free;
        }

        public int getxFromN() {
            return xFromN;
        }

        public void setxFromN(int xFromN) {
            this.xFromN = xFromN;
        }

        public int getyFromM() {
            return yFromM;
        }

        public void setyFromM(int yFromM) {
            this.yFromM = yFromM;
        }

        public boolean isFree() {
            return free;
        }

        public void setFree(boolean free) {
            this.free = free;
        }

        @Override
        public boolean equals(Object obj) {
            Plot plot = (Plot) obj;
            return xFromN==(plot.xFromN) && yFromM==(plot.yFromM);
        }

        @Override
        public int hashCode(){
            return Objects.hash(xFromN, yFromM);
        }
    }
}
